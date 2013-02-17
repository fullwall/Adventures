package net.citizensnpcs.adventures.dialog.evaluators;

public class VariableEvaluator implements Evaluator {
    private final Evaluator identifier;
    private final VariableSource variableSource;

    private VariableEvaluator(VariableSource source, Evaluator identifier) {
        this.identifier = identifier;
        this.variableSource = source;
    }

    @Override
    public Object get() {
        return variableSource.getVariable((String) identifier.get());
    }

    @Override
    public boolean isConstant() {
        return false;
    }

    @Override
    public String toString() {
        return "VariableEvaluator [" + identifier.get() + "]";
    }

    public static VariableEvaluator create(VariableSource source, Evaluator evaluator) {
        return new VariableEvaluator(source, evaluator);
    }
}
