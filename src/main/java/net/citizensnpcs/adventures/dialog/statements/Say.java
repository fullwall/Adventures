package net.citizensnpcs.adventures.dialog.statements;

import net.citizensnpcs.adventures.dialog.DialogEngine.ParseContext;
import net.citizensnpcs.adventures.dialog.QueryContext;
import net.citizensnpcs.adventures.dialog.QueryRunnable;
import net.citizensnpcs.adventures.dialog.statements.StatementContext.Locals;
import net.citizensnpcs.adventures.util.TargetUtil;

public class Say implements QueryRunnable {
    private final StatementContext statementContext;

    public Say(StatementContext context) {
        this.statementContext = context;
    }

    @Override
    public void run(QueryContext context) {
        Locals locals = statementContext.createLocals(context.getQuery());
        Object rawTarget = locals.getUnsafe("target");
        String message = locals.getSafe("message", String.class);
        TargetUtil.sendMessage(message, rawTarget);
    }

    @StatementBuilder(name = "say", arguments = "[message] [target]")
    public static QueryRunnable parse(ParseContext parseContext, StatementContext context) {
        return new Say(context);
    }
}
