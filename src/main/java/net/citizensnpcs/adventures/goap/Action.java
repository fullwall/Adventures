package net.citizensnpcs.adventures.goap;

public interface Action {
    boolean evaluateContextPreconditions();

    WorldState getEffects();

    WorldState getPreconditions();
}
