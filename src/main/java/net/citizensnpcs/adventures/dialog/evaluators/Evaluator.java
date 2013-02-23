package net.citizensnpcs.adventures.dialog.evaluators;

public interface Evaluator {
    Object get(VariableSource variables);

    boolean isConstant();
}
