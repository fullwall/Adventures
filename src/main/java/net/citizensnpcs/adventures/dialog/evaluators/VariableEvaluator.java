package net.citizensnpcs.adventures.dialog.evaluators;

public class VariableEvaluator implements Evaluator {
    private final Evaluator identifier;

    private VariableEvaluator(Evaluator identifier) {
        this.identifier = identifier;
    }

    @Override
    public Object get(VariableSource variables) {
        return variables.getVariable((String) identifier.get(variables));
    }

    @Override
    public boolean isConstant() {
        return false;
    }

    @Override
    public String toString() {
        return "VariableEvaluator [" + (identifier.isConstant() ? identifier.get(null) : identifier) + "]";
    }

    public static VariableEvaluator create(Evaluator evaluator) {
        return new VariableEvaluator(evaluator);
    }
}
