package net.citizensnpcs.adventures.dialog.evaluators;

public class StringEvaluator implements Evaluator {
    private final String value;

    public StringEvaluator(String value) {
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

    public static Evaluator create(String raw) {
        return new StringEvaluator(raw.replace("\"", "").replace("'", ""));
    }
}