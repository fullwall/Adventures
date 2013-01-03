package net.citizensnpcs.adventures.goap.npc;

import net.citizensnpcs.adventures.goap.Goal;
import net.citizensnpcs.adventures.goap.PlannerAgent;
import net.citizensnpcs.adventures.goap.WorldState;
import net.citizensnpcs.adventures.sensors.ThreatSensor;

import com.google.inject.Inject;

public class GoalRemoveThreat implements Goal {
    @Inject
    private PlannerAgent agent;

    @Override
    public boolean canContinue() {
        return evaluateRelevancy(agent) == 1;
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
