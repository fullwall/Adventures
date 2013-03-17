package net.citizensnpcs.adventures.goap;

public interface GoapGoal {
    boolean canContinue();

    float evaluateRelevancy(PlannerAgent agent);

    WorldState getGoalState();
}
