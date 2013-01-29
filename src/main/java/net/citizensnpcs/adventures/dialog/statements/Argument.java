package net.citizensnpcs.adventures.dialog.statements;

import net.citizensnpcs.adventures.dialog.evaluators.Evaluator;

public class Argument {
    final String name;
    final Evaluator value;

    public Argument(String name, Evaluator value) {
        this.name = name;
        this.value = value;
    }
}