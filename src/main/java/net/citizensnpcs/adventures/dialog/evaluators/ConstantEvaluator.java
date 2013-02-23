package net.citizensnpcs.adventures.dialog.evaluators;

public class ConstantEvaluator implements Evaluator {
    private final Object value;

    private ConstantEvaluator(Object value) {
        this.value = value;
    }

    @Override
    public Object get(VariableSource variables) {
        return value;
    }

    @Override
    public boolean isConstant() {
        return true;
    }

    @Override
    public String toString() {
        return "ConstantEvaluator[" + value.toString() + "]";
    }

    public static Evaluator create(Object value) {
        return new ConstantEvaluator(value);
    }
}
