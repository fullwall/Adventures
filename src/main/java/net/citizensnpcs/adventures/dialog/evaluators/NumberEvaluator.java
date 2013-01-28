package net.citizensnpcs.adventures.dialog.evaluators;

import net.citizensnpcs.adventures.dialog.DialogParserException;

public class NumberEvaluator {
    public static Evaluator create(String raw) {
        try {
            return ConstantEvaluator.create(Integer.parseInt(raw));
        } catch (NumberFormatException iex) {
            try {
                return ConstantEvaluator.create(Long.parseLong(raw));
            } catch (NumberFormatException lex) {
                try {
                    return ConstantEvaluator.create(Double.parseDouble(raw));
                } catch (NumberFormatException dex) {
                    dex.printStackTrace();
                }
            }
        }
        throw new DialogParserException("Couldn't parse a number from " + raw);
    }
}
