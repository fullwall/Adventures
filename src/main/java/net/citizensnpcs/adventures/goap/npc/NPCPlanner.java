package net.citizensnpcs.adventures.goap.npc;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.citizensnpcs.adventures.goap.AStarGoapPlan;
import net.citizensnpcs.adventures.goap.Action;
import net.citizensnpcs.adventures.goap.GoapAgent;
import net.citizensnpcs.adventures.goap.GoapGoal;
import net.citizensnpcs.api.astar.Plan;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class NPCPlanner implements Planner {
    private final List<Action> availableActions = Lists.newArrayList();
    private final List<GoapGoal> availableGoals = Lists.newArrayList();
    private GoapGoal currentGoal;
    private Plan currentPlan;
    @Inject
    private GoapAgent agent;

    @Override
    public Iterable<Action> getAvailableActions() {
        return availableActions;
    }

    @Override
    public float getCostModifierFor(Action action) {
        return 1F;
    }

    private void replan() {
        GoapGoal best = selectBestGoal(agent);
        if (best != null) {
            Plan plan = agent.generatePlan(best.getGoalState());
            boolean replace = shouldReplaceCurrentPlan(plan);
            if (replace)
                switchPlanTo(best, plan);
        }
    }

    private void resetPlan() {
        currentPlan = null;
        currentGoal = null;
    }

    private GoapGoal selectBestGoal(final GoapAgent agent) {
        Collections.sort(availableGoals, new Comparator<GoapGoal>() {
            @Override
            public int compare(GoapGoal o1, GoapGoal o2) {
                // descending order
                return (int) (o2.evaluateRelevancy(agent) - o1.evaluateRelevancy(agent));
            }
        });
        for (GoapGoal goal : availableGoals) {
            if (goal == currentGoal || agent.contains(goal.getGoalState()))
                continue;
            return goal;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private boolean shouldReplaceCurrentPlan(Plan plan) {
        if (currentPlan == null)
            return true;
        return ((Comparable<Plan>) currentPlan).compareTo(plan) < 0 && !currentPlan.equals(plan);
    }

    private void switchPlanTo(GoapGoal goal, Plan plan) {
        currentGoal = goal;
        currentPlan = plan;
    }

    @Override
    public void update() {
        updatePlan();
    }

    private void updatePlan() {
        replan();
        if (currentPlan == null)
            return;
        if (!currentGoal.canContinue())
            resetPlan();
        currentPlan.update(agent);
        if (currentPlan.isComplete()) {
            if (currentPlan instanceof AStarGoapPlan)
                agent.apply(((AStarGoapPlan) currentPlan).getWorldStateChanges());
            resetPlan();
        }
    }
}
