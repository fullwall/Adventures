package net.citizensnpcs.adventures.goap.npc;

import net.citizensnpcs.adventures.goap.PlannerAgent;
import net.citizensnpcs.adventures.goap.Goal;
import net.citizensnpcs.adventures.goap.WorldState;

public class GoalRemoveThreat implements Goal {
    @Override
    public boolean canContinue() {
        return true;
    }

    @Override
    public float evaluateRelevancy(PlannerAgent agent) {
        return agent.getSensor(ThreatSensor.class).hasThreats() ? 1 : 0;
    }

    @Override
    public WorldState getGoalState() {
        return GOAL;
    }

    private static WorldState GOAL = WorldState.create("hasThreat", false);
}
