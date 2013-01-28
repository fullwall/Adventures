package net.citizensnpcs.adventures.dialog.evaluators;

import net.citizensnpcs.adventures.dialog.DialogParserException;

public class PlusEvaluator extends LeftRightEvaluator {
    private PlusEvaluator(Evaluator left, Evaluator right) {
        super(left, right);
    }

    @Override
    public Object get() {
        return plus(left.get(), right.get());
    }

    public static Evaluator create(Evaluator left, Evaluator right) {
        if (left.isConstant() && right.isConstant())
            return ConstantEvaluator.create(plus(left.get(), right.get()));
        return new PlusEvaluator(left, right);
    }

    private static Object plus(Object one, Object two) {
        if (one instanceof Integer && two instanceof Integer)
            return (Integer) one + (Integer) two;
        if (one instanceof Number && two instanceof Number)
            return ((Number) one).doubleValue() + ((Number) two).doubleValue();
        if (one instanceof String)
            return (String) one + two.toString();
        throw new DialogParserException("Expected two numbers or strings to add but got " + one + " " + two);
    }
}
