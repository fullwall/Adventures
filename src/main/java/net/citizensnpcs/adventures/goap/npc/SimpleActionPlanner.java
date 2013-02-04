package net.citizensnpcs.adventures.goap.npc;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.citizensnpcs.adventures.goap.Action;
import net.citizensnpcs.adventures.goap.ActionPlan;
import net.citizensnpcs.adventures.goap.Goal;
import net.citizensnpcs.adventures.goap.PlannerAgent;
import net.citizensnpcs.api.ai.tree.BehaviorStatus;
import net.citizensnpcs.api.astar.Plan;

import com.google.common.collect.Lists;

public class SimpleActionPlanner implements ActionPlanner {
    private final PlannerAgent agent;
    private final List<Action> availableActions = Lists.newArrayList();
    private final List<Goal> availableGoals = Lists.newArrayList();
    private Goal currentGoal;
    private Plan currentPlan;

    public SimpleActionPlanner(PlannerAgent agent) {
        this.agent = agent;
    }

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

    @Override
    public void reset() {
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
            if (goal == currentGoal) {
                break;
            }
            if (agent.contains(goal.getGoalState())) {
                continue;
            }
            return goal;
        }
        return null;
    }

    @Override
    public boolean shouldExecute() {
        return availableGoals.size() > 0 && availableActions.size() > 0;
    }

    @SuppressWarnings("unchecked")
    private boolean shouldReplaceCurrentPlan(Plan plan) {
        if (plan == null)
            return false;
        if (currentPlan == null)
            return true;
        return ((Comparable<Plan>) currentPlan).compareTo(plan) < 0 && !currentPlan.equals(plan);
    }

    private void switchPlanTo(Goal goal, Plan plan) {
        currentGoal = goal;
        currentPlan = plan;
    }

    @Override
    public BehaviorStatus update() {
        replan();
        if (currentPlan == null)
            return BehaviorStatus.FAILURE;
        if (!currentGoal.canContinue()) {
            reset();
            return BehaviorStatus.FAILURE;
        }
        currentPlan.update(agent);
        if (currentPlan.isComplete()) {
            if (currentPlan instanceof ActionPlan)
                agent.apply(((ActionPlan) currentPlan).getWorldStateChanges());
            reset();
            return BehaviorStatus.SUCCESS;
        }
        return BehaviorStatus.RUNNING;
    }
}
