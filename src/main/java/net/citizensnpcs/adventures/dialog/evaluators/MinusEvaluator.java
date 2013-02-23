package net.citizensnpcs.adventures.dialog.evaluators;

import net.citizensnpcs.adventures.dialog.DialogParserException;

public class MinusEvaluator extends LeftRightEvaluator {
    private MinusEvaluator(Evaluator left, Evaluator right) {
        super(left, right);
    }

    @Override
    public Object get(VariableSource variables) {
        return minus(left.get(variables), right.get(variables));
    }

    public static Evaluator create(Evaluator left, Evaluator right) {
        if (left.isConstant() && right.isConstant())
            return ConstantEvaluator.create(minus(left.get(null), right.get(null)));
        return new MinusEvaluator(left, right);
    }

    private static Object minus(Object one, Object two) {
        if (one instanceof Integer && two instanceof Integer)
            return (Integer) one - (Integer) two;
        if (one instanceof Number && two instanceof Number)
            return ((Number) one).doubleValue() - ((Number) two).doubleValue();
        throw new DialogParserException("Expected two numbers while subtracting");
    }
}