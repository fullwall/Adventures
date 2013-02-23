package net.citizensnpcs.adventures.dialog.statements;

import net.citizensnpcs.adventures.dialog.DialogEngine.ParseContext;
import net.citizensnpcs.adventures.dialog.DialogException;
import net.citizensnpcs.adventures.dialog.QueryContext;
import net.citizensnpcs.adventures.dialog.QueryRunnable;

public class Forget implements QueryRunnable {
    private final StatementContext statementContext;

    private Forget(StatementContext statementContext) {
        this.statementContext = statementContext;
    }

    @Override
    public void run(QueryContext context) {
        Object raw = statementContext.getUnsafe(context.getQuery(), "memory");
        if (raw instanceof String[]) {
            context.getQuery().forget((String[]) raw);
        } else if (raw instanceof String) {
            context.getQuery().forget(raw.toString());
        }
        throw new DialogException("Didn't recognise memory type " + raw);
    }

    @StatementBuilder(name = "forget", arguments = "[memory]")
    public static Forget build(ParseContext parse, StatementContext statement) {
        return new Forget(statement);
    }
}
