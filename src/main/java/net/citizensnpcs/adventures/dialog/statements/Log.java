package net.citizensnpcs.adventures.dialog.statements;

import net.citizensnpcs.adventures.dialog.QueryContext;
import net.citizensnpcs.adventures.dialog.QueryRunnable;
import net.citizensnpcs.adventures.dialog.evaluators.Evaluator;

public class Log implements QueryRunnable {
    private final Evaluator evaluator;

    private Log(Evaluator evaluator) {
        this.evaluator = evaluator;
    }

    @Override
    public void run(QueryContext context) {
        System.err.println(evaluator.get());
    }

    public static Log logging(Evaluator evaluator) {
        return new Log(evaluator);
    }
}