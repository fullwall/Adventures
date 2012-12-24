package net.citizensnpcs.adventures.dialog.evaluators;

public class DivideEvaluator extends LeftRightEvaluator {
    private DivideEvaluator(Evaluator left, Evaluator right) {
        super(left, right);
    }

    @Override
    public Object get() {
        return divide(left, right);
    }

    public static Evaluator create(Evaluator left, Evaluator right) {
        if (left.isConstant() && right.isConstant())
            return ConstantEvaluator.create(divide(left.get(), right.get()));
        return new DivideEvaluator(left, right);
    }

    private static Object divide(Object one, Object two) {
        if (one instanceof Integer && two instanceof Integer)
            return (Integer) one / (Integer) two;
        if (one instanceof Number && two instanceof Number)
            return ((Number) one).doubleValue() / ((Number) two).doubleValue();
        throw new IllegalStateException();
    }
}