package net.citizensnpcs.adventures.dialog.evaluators;

public class ModEvaluator extends LeftRightEvaluator {
    private ModEvaluator(Evaluator left, Evaluator right) {
        super(left, right);
    }

    @Override
    public Object get() {
        return mod(left.get(), right.get());
    }

    public static Evaluator create(Evaluator left, Evaluator right) {
        if (left.isConstant() && right.isConstant())
            return ConstantEvaluator.create(mod(left.get(), right.get()));
        return new ModEvaluator(left, right);
    }

    private static Object mod(Object one, Object two) {
        if (one instanceof Integer && two instanceof Integer)
            return (Integer) one % (Integer) two;
        if (one instanceof Number && two instanceof Number)
            return ((Number) one).doubleValue() % ((Number) two).doubleValue();
        throw new IllegalStateException();
    }
}