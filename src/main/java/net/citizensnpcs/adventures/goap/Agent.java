package net.citizensnpcs.adventures.goap;

public interface Agent {
    Iterable<Action> getAvailableActions();

    float getCostModifierFor(Action action);
}
