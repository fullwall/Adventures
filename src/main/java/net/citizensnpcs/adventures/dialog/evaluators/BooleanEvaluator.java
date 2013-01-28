package net.citizensnpcs.adventures.dialog.evaluators;

public class BooleanEvaluator {
    public static Evaluator create(String raw) {
        return create(Boolean.valueOf(raw));
    }

    public static Evaluator create(boolean value) {
        return ConstantEvaluator.create(value);
    }
}
