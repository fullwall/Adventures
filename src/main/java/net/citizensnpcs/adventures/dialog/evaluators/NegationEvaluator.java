package net.citizensnpcs.adventures.dialog.evaluators;

public class NegationEvaluator implements Evaluator {
    private final Evaluator evaluator;

    private NegationEvaluator(Evaluator evaluator) {
        this.evaluator = evaluator;
    }

    @Override
    public Object get() {
        return negate(evaluator.get());
    }

    @Override
    public boolean isConstant() {
        return evaluator.isConstant();
    }

    public static Evaluator create(Evaluator evaluator) {
        if (evaluator.isConstant())
            return ConstantEvaluator.create(negate(evaluator.get()));
        return new NegationEvaluator(evaluator);
    }

    private static Object negate(Object object) {
        if (object instanceof Integer)
            return -(Integer) object;
        if (object instanceof Number)
            return -((Number) object).doubleValue();
        throw new IllegalStateException();
    }
}
