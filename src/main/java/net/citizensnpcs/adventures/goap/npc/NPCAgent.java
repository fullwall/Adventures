package net.citizensnpcs.adventures.goap.npc;

import java.util.List;
import java.util.Map;

import net.citizensnpcs.adventures.astar.AStarGoal;
import net.citizensnpcs.adventures.astar.AStarMachine;
import net.citizensnpcs.adventures.astar.AStarNode;
import net.citizensnpcs.adventures.astar.Plan;
import net.citizensnpcs.adventures.goap.AStarGoapGoal;
import net.citizensnpcs.adventures.goap.AStarGoapNode;
import net.citizensnpcs.adventures.goap.Action;
import net.citizensnpcs.adventures.goap.Agent;
import net.citizensnpcs.adventures.goap.GoapGoal;
import net.citizensnpcs.adventures.goap.Sensor;
import net.citizensnpcs.adventures.goap.WorldState;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class NPCAgent implements Agent {
    private final List<Action> availableActions = Lists.newArrayList();
    private final List<GoapGoal> availableGoals = Lists.newArrayList();
    private GoapGoal currentGoal;
    private Plan currentPlan;
    private final AStarMachine machine = AStarMachine.createWithDefaultStorage();
    private final Map<Class<? extends Sensor>, Sensor> sensors = Maps.newHashMap();
    private final WorldState worldState = WorldState.createEmptyState();

    @Override
    public Iterable<Action> getAvailableActions() {
        return availableActions;
    }

    @Override
    public float getCostModifierFor(Action action) {
        return 0;
    }

    public Sensor getSensorFor(Class<? extends Sensor> clazz) {
        return sensors.get(clazz);
    }

    private void replan() {
        GoapGoal best = selectBestGoal();
        if (best == null)
            return;
        AStarNode root = AStarGoapNode.create(this, worldState);
        AStarGoal goal = AStarGoapGoal.createWithGoalState(best.getGoalState());
        currentPlan = machine.run(goal, root);
        currentGoal = best;
    }

    private void resetPlan() {
        currentPlan = null;
        currentGoal = null;
    }

    private GoapGoal selectBestGoal() {
        float bestRelevancy = Float.MIN_VALUE;
        GoapGoal bestGoal = null;
        for (GoapGoal goal : availableGoals) {
            float relevancy = goal.evaluateRelevancy();
            if (relevancy > bestRelevancy) {
                bestGoal = goal;
                bestRelevancy = relevancy;
            }
        }
        return bestGoal;
    }

    public void update() {
        updateSensors();
        if (currentPlan == null) {
            replan();
        } else {
            currentPlan.update();
            if (currentPlan.isComplete()) {
                worldState.apply(currentPlan.getWorldStateChanges());
                resetPlan();
            }
            if (!currentGoal.canContinue()) {
                resetPlan();
            }
        }
    }

    private void updateSensors() {
        for (Sensor sensor : sensors.values())
            worldState.apply(sensor.generateState());
    }
}
