package net.citizensnpcs.adventures.goap;

public interface Action {
    void activate();

    boolean evaluateContextPreconditions();

    float getCost();

    WorldState getEffects();

    WorldState getPreconditions();

    boolean isComplete();

    void update();
}
