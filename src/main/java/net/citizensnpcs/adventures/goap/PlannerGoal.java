package net.citizensnpcs.adventures.goap;

import net.citizensnpcs.api.astar.AStarGoal;

public class PlannerGoal implements AStarGoal<PlannerNode> {
    private final WorldState goal;

    private PlannerGoal(WorldState goal) {
        this.goal = goal.clone();
    }

    @Override
    public float g(PlannerNode from, PlannerNode to) {
        return from.heuristic(to);
    }

    @Override
    public float getInitialCost(PlannerNode node) {
        return node.difference(goal);
    }

    @Override
    public float h(PlannerNode from) {
        return from.heuristic(goal);
    }

    @Override
    public boolean isFinished(PlannerNode node) {
        return node.stateEquals(goal);
    }

    public static AStarGoal<PlannerNode> createWithGoalState(WorldState goalState) {
        return new PlannerGoal(goalState);
    }
}
