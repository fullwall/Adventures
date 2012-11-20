package net.citizensnpcs.adventures.goap.npc;

import net.citizensnpcs.adventures.goap.Agent;
import net.citizensnpcs.adventures.goap.GoapGoal;
import net.citizensnpcs.adventures.goap.WorldState;

public class GoalRemoveThreat implements GoapGoal {
    @Override
    public boolean canContinue() {
        return true;
    }

    @Override
    public float evaluateRelevancy(Agent agent) {
        return agent.getSensor(ThreatSensor.class).hasThreats() ? 1 : 0;
    }

    @Override
    public WorldState getGoalState() {
        return GOAL;
    }

    private static WorldState GOAL = WorldState.create("hasThreat", false);
}
