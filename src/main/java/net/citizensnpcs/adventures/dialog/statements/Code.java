package net.citizensnpcs.adventures.dialog.statements;

import javax.script.ScriptException;

import net.citizensnpcs.adventures.dialog.DialogEngine.ParseContext;
import net.citizensnpcs.adventures.dialog.DialogException;
import net.citizensnpcs.adventures.dialog.QueryContext;
import net.citizensnpcs.adventures.dialog.QueryRunnable;
import net.citizensnpcs.adventures.dialog.statements.StatementContext.Locals;
import net.citizensnpcs.api.CitizensAPI;

public class Code implements QueryRunnable {
    private final String extension;
    private final StatementContext statementContext;

    private Code(String extension, StatementContext statementContext) {
        this.extension = extension;
        this.statementContext = statementContext;
    }

    @Override
    public void run(QueryContext context) {
        Locals locals = statementContext.createLocals(context.getQuery());
        String code = locals.getRequired("code", String.class);
        try {
            CitizensAPI.getScriptCompiler().run(code, extension, locals.getMap());
        } catch (ScriptException e) {
            throw new DialogException(e);
        }
    }

    @StatementBuilder(name = "js|py|lua|rb|clj|scala|groovy", arguments = "[code]")
    public static QueryRunnable code(ParseContext parseContext, StatementContext statementContext) {
        return new Code(statementContext.getName(), statementContext);
    }
}
