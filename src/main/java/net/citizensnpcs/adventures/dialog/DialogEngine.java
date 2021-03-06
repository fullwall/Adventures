package net.citizensnpcs.adventures.dialog;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collection;

import net.citizensnpcs.adventures.dialog.statements.Argument;
import net.citizensnpcs.adventures.dialog.statements.Code;
import net.citizensnpcs.adventures.dialog.statements.Forget;
import net.citizensnpcs.adventures.dialog.statements.Say;
import net.citizensnpcs.adventures.dialog.statements.StatementRegistry;
import net.citizensnpcs.api.CitizensAPI;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.bukkit.Bukkit;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.io.Files;

public class DialogEngine {
    private final DialogRegistry globalRegistry = new SimpleDialogRegistry();
    private final StatementRegistry statementRegistry = new StatementRegistry();

    public DialogEngine() {
        statementRegistry.register(Say.class);
        statementRegistry.register(Code.class);
        statementRegistry.register(Forget.class);
    }

    public boolean execute(Query query) {
        Rule lastMatching = globalRegistry.getBestRule(query);
        try {
            if (lastMatching != null)
                lastMatching.run(new SimpleQueryContext(query));
        } catch (DialogException ex) {
            Throwables.getRootCause(ex).printStackTrace();
            lastMatching = null;
        }
        return lastMatching != null;
    }

    public StatementRegistry getStatementRegistry() {
        return statementRegistry;
    }

    public void loadFolderAsynchronously(final File folder) {
        Bukkit.getScheduler().runTaskAsynchronously(CitizensAPI.getPlugin(), new Runnable() {
            @Override
            public void run() {
                folder.mkdirs();
                for (File file : folder.listFiles(DIALOG_FILE_FILTER)) {
                    try {
                        parse(folder, Files.toString(file, Charsets.UTF_8));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void parse(final File parsingFolder, String string) {
        DialogLexer lexer = new DialogLexer(new ANTLRStringStream(string));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DialogParser parser = new DialogParser(tokens);
        try {
            parser.program(new ParseContext() {
                @Override
                public QueryRunnable buildStatement(String name, Collection<Argument> args) {
                    return statementRegistry.getMatchingStatement(this, name, args);
                }

                @Override
                public String disambiguateName(String raw) {
                    if (parsingFolder != null) {
                        return parsingFolder.getName() + '/' + raw;
                    }
                    return raw;
                }

                @Override
                public void responseLoaded(Response response) {
                    globalRegistry.registerResponse(response);
                }

                @Override
                public void ruleLoaded(Collection<String> eventNames, Rule rule) {
                    globalRegistry.registerRule(eventNames, rule);
                }
            });
        } catch (RecognitionException e) {
            e.printStackTrace();
        } catch (DialogException e) {
            e.printStackTrace();
        }
    }

    public void parse(String string) {
        parse(null, string);
    }

    public void reloadAsynchronouslyFromFolder(File file) {
        globalRegistry.clear();
        loadFolderAsynchronously(file);
    }

    public interface ParseContext {
        QueryRunnable buildStatement(String name, Collection<Argument> args);

        String disambiguateName(String raw);

        void responseLoaded(Response response);

        void ruleLoaded(Collection<String> eventNames, Rule rule);
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

    private static final FilenameFilter DIALOG_FILE_FILTER = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return true;
        }
    };
}
