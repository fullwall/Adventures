package net.citizensnpcs.adventures.goap;

public interface Agent {
    float evaluateRelevancy(Action action);

    Iterable<Action> getAvailableActions();
}
