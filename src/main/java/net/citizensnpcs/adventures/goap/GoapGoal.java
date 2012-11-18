package net.citizensnpcs.adventures.goap;

public interface GoapGoal {
    boolean canContinue();

    float evaluateRelevancy();

    WorldState getGoalState();
}
