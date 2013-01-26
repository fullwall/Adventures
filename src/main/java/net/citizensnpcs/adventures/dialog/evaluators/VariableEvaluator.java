package net.citizensnpcs.adventures.dialog.evaluators;

public class VariableEvaluator implements Evaluator {
    private final String identifier;
    private final VariableSource variableSource;

    private VariableEvaluator(VariableSource source, String identifier) {
        this.identifier = identifier;
        this.variableSource = source;
    }

    @Override
    public Object get() {
        return variableSource.getVariable(identifier);
    }

    @Override
    public boolean isConstant() {
        return false;
    }

    @Override
    public String toString() {
        return "VariableEvaluator [" + identifier + "]";
    }

    public static VariableEvaluator create(VariableSource source, String identifier) {
        return new VariableEvaluator(source, identifier);
    }
}
