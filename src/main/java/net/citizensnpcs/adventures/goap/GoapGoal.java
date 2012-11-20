package net.citizensnpcs.adventures.goap;

public interface GoapGoal {
    boolean canContinue();

    WorldState getGoalState();

    float evaluateRelevancy(Agent agent);
}
