package net.citizensnpcs.adventures.goap;

public interface Agent {
    Iterable<Action> getAvailableActions();
}
