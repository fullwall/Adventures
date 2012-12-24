package net.citizensnpcs.adventures.goap;

public interface Goal {
    boolean canContinue();

    float evaluateRelevancy(PlannerAgent agent);

    WorldState getGoalState();
}
