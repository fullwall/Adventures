package net.citizensnpcs.adventures.dialog.evaluators;

import net.citizensnpcs.adventures.dialog.DialogParserException;

public class NegationEvaluator implements Evaluator {
    private final Evaluator evaluator;

    private NegationEvaluator(Evaluator evaluator) {
        this.evaluator = evaluator;
    }

    @Override
    public Object get(VariableSource variables) {
        return negate(evaluator.get(variables));
    }

    @Override
    public boolean isConstant() {
        return evaluator.isConstant();
    }

    public static Evaluator create(Evaluator evaluator) {
        if (evaluator.isConstant())
            return ConstantEvaluator.create(negate(evaluator.get(null)));
        return new NegationEvaluator(evaluator);
    }

    private static Object negate(Object object) {
        if (object instanceof Integer)
            return -(Integer) object;
        if (object instanceof Number)
            return -((Number) object).doubleValue();
        throw new DialogParserException("Expected a number to negate");
    }
}
