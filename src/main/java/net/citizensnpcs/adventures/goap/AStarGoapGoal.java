package net.citizensnpcs.adventures.goap;

import net.citizensnpcs.adventures.astar.AStarGoal;
import net.citizensnpcs.adventures.astar.AStarNode;

public class AStarGoapGoal implements AStarGoal {
    private final WorldState goal;

    private AStarGoapGoal(WorldState goal) {
        this.goal = goal.clone();
    }

    @Override
    public float g(AStarNode from) {
        return ((AStarGoapNode) from).heuristic(goal);
    }

    @Override
    public float getInitialCost(AStarNode node) {
        return g(node);
    }

    @Override
    public float h(AStarNode from, AStarNode to) {
        return ((AStarGoapNode) from).heuristic((AStarGoapNode) to);
    }

    @Override
    public boolean isFinished(AStarNode node) {
        return ((AStarGoapNode) node).stateEquals(goal);
    }

    public static AStarGoal createWithGoalState(WorldState goalState) {
        return new AStarGoapGoal(goalState);
    }
}
