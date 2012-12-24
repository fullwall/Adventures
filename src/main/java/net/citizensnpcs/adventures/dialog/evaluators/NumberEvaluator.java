package net.citizensnpcs.adventures.dialog.evaluators;

public class NumberEvaluator implements Evaluator {
    private final Number value;

    public NumberEvaluator(Number number) {
        this.value = number;
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
        try {
            return new NumberEvaluator(Integer.parseInt(raw));
        } catch (NumberFormatException ex) {
            try {
                return new NumberEvaluator(Double.parseDouble(raw));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        throw new IllegalArgumentException();
    }
}
