package net.citizensnpcs.adventures.dialog.evaluators;

import net.citizensnpcs.adventures.dialog.DialogParserException;

public class PowerEvaluator extends LeftRightEvaluator {
    private PowerEvaluator(Evaluator left, Evaluator right) {
        super(left, right);
    }

    @Override
    public Object get(VariableSource variables) {
        return pow(left.get(variables), right.get(variables));
    }

    public static Evaluator create(Evaluator left, Evaluator right) {
        if (left.isConstant() && right.isConstant())
            return ConstantEvaluator.create(pow(left.get(null), right.get(null)));
        return new PowerEvaluator(left, right);
    }

    private static Object pow(Object one, Object two) {
        if (one instanceof Integer && two instanceof Integer)
            return Math.pow((Integer) one, (Integer) two);
        if (one instanceof Number && two instanceof Number)
            return Math.pow(((Number) one).doubleValue(), ((Number) two).doubleValue());
        throw new DialogParserException("Expected two numbers to raise to the power but got " + one + " " + two);
    }
}
