package net.citizensnpcs.adventures.dialog.evaluators;

import net.citizensnpcs.adventures.dialog.DialogParserException;

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

    @Override
    public String toString() {
        return "NumberEvaluator[" + value + "]";
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
        throw new DialogParserException("Couldn't parse a number from " + raw);
    }
}
