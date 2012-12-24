package net.citizensnpcs.adventures.goap.npc;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.citizensnpcs.adventures.goap.ActionPlan;
import net.citizensnpcs.adventures.goap.Action;
import net.citizensnpcs.adventures.goap.PlannerAgent;
import net.citizensnpcs.adventures.goap.Goal;
import net.citizensnpcs.api.astar.Plan;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class NPCPlanner implements Planner {
    @Inject
    private PlannerAgent agent;
    private final List<Action> availableActions = Lists.newArrayList();
    private final List<Goal> availableGoals = Lists.newArrayList();
    private Goal currentGoal;
    private Plan currentPlan;

    @Override
    public Iterable<Action> getAvailableActions() {
        return availableActions;
    }

    @Override
    public float getCostModifierFor(Action action) {
        return 1F;
    }

    private void replan() {
        Goal best = selectBestGoal(agent);
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

    private Goal selectBestGoal(final PlannerAgent agent) {
        Collections.sort(availableGoals, new Comparator<Goal>() {
            @Override
            public int compare(Goal o1, Goal o2) {
                // descending order
                return (int) (o2.evaluateRelevancy(agent) - o1.evaluateRelevancy(agent));
            }
        });
        for (Goal goal : availableGoals) {
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

    private void switchPlanTo(Goal goal, Plan plan) {
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
            if (currentPlan instanceof ActionPlan)
                agent.apply(((ActionPlan) currentPlan).getWorldStateChanges());
            resetPlan();
        }
    }
}
