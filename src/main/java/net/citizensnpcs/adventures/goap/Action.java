package net.citizensnpcs.adventures.goap;

public interface Action {
    boolean evaluateContextPreconditions();

    float evaluateRelevancy();

    WorldState getEffects();

    WorldState getPreconditions();
}
