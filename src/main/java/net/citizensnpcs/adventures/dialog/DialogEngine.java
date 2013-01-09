package net.citizensnpcs.adventures.dialog;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import net.citizensnpcs.adventures.dialog.evaluators.VariableSource;
import net.citizensnpcs.api.CitizensAPI;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.bukkit.Bukkit;

import com.google.common.base.Preconditions;

public class DialogEngine implements VariableSource {
    private Query currentQuery;
    private final DialogRegistry globalRegistry = new SimpleDialogRegistry();

    public void execute(Query query) {
        currentQuery = query;

        Rule lastMatching = globalRegistry.getBestRule(query);
        if (lastMatching != null)
            lastMatching.run(new SimpleQueryContext(query));
        currentQuery = null;
    }

    private class SimpleQueryContext implements QueryContext {
        private final Query query;

        public SimpleQueryContext(Query query) {
            this.query = query;
        }

        @Override
        public boolean callResponse(String responseIdentifier) {
            return callResponse(responseIdentifier, null);
        }

        @Override
        public boolean callResponse(String responseIdentifier, QueryRunnable callback) {
            Preconditions.checkNotNull(responseIdentifier);
            Response response = globalRegistry.getResponse(responseIdentifier);
            if (response == null)
                return false;
            response.run(this, callback);
            return true;
        }

        @Override
        public Query getQuery() {
            return query;
        }

        @Override
        public void runRedirectQuery(String target, String event) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Object getVariable(String key) {
        if (currentQuery == null)
            throw new IllegalStateException();
        return currentQuery.get(key);
    }

    public void load(final File folder) {
        Bukkit.getScheduler().runTaskAsynchronously(CitizensAPI.getPlugin(), new Runnable() {
            @Override
            public void run() {
                folder.mkdirs();

                for (File file : folder.listFiles(DIALOG_FILE_FILTER)) {
                    DialogLexer lexer;
                    try {
                        lexer = new DialogLexer(new ANTLRFileStream(file.getAbsolutePath()));
                    } catch (IOException e) {
                        e.printStackTrace();
                        continue;
                    }
                    CommonTokenStream tokens = new CommonTokenStream(lexer);
                    DialogParser parser = new DialogParser(tokens);
                    parser.setVariableSource(DialogEngine.this);
                    try {
                        parser.program(globalRegistry);
                    } catch (RecognitionException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private static final FilenameFilter DIALOG_FILE_FILTER = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return true;
        }
    };
}
