package net.citizensnpcs.adventures.dialog.statements;

import java.util.Map;

import javax.script.ScriptException;

import net.citizensnpcs.adventures.dialog.DialogEngine.ParseContext;
import net.citizensnpcs.adventures.dialog.DialogException;
import net.citizensnpcs.adventures.dialog.QueryContext;
import net.citizensnpcs.adventures.dialog.QueryRunnable;
import net.citizensnpcs.api.CitizensAPI;

import com.google.common.collect.Maps;

public class Code implements QueryRunnable {
    private final String extension;
    private final StatementContext statementContext;
    private final Map<String, Object> codeVars;

    private Code(String extension, StatementContext statementContext) {
        this.extension = extension;
        this.statementContext = statementContext;
        this.codeVars = Maps.newHashMap(statementContext.getMap());
    }

    @StatementHandler(name = "js|py|lua|rb|clj|scala", arguments = "[code]")
    public static QueryRunnable js(ParseContext parseContext, StatementContext statementContext) {
        return new Code(statementContext.getName(), statementContext);
    }

    @Override
    public void run(QueryContext context) {
        String code = statementContext.getRequired("code", String.class);
        try {
            CitizensAPI.getScriptCompiler().run(code, extension, codeVars);
        } catch (ScriptException e) {
            throw new DialogException(e);
        }
    }
}
