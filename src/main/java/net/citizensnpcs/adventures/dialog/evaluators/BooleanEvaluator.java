package net.citizensnpcs.adventures.dialog.evaluators;

public class BooleanEvaluator implements Evaluator {
    private final boolean value;

    public BooleanEvaluator(boolean value) {
        this.value = value;
    }

    @Override
    public Object get() {
        return value;
    }

    @Override
    public boolean isConstant() {
        return true;
    }

    @Override
    public String toString() {
        return "BooleanEvaluator[" + value + "]";
    }

    public static BooleanEvaluator create(String raw) {
        return new BooleanEvaluator(Boolean.valueOf(raw));
    }
}
