package net.citizensnpcs.adventures.dialog.evaluators;

import net.citizensnpcs.adventures.dialog.DialogParserException;

public class ModEvaluator extends LeftRightEvaluator {
    private ModEvaluator(Evaluator left, Evaluator right) {
        super(left, right);
    }

    @Override
    public Object get(VariableSource variables) {
        return mod(left.get(variables), right.get(variables));
    }

    public static Evaluator create(Evaluator left, Evaluator right) {
        if (left.isConstant() && right.isConstant())
            return ConstantEvaluator.create(mod(left.get(null), right.get(null)));
        return new ModEvaluator(left, right);
    }

    private static Object mod(Object one, Object two) {
        if (one instanceof Integer && two instanceof Integer)
            return (Integer) one % (Integer) two;
        if (one instanceof Number && two instanceof Number)
            return ((Number) one).doubleValue() % ((Number) two).doubleValue();
        throw new DialogParserException("Expected two numbers while mod");
    }
}