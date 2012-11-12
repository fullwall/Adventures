package net.citizensnpcs.adventures.goap;

import net.citizensnpcs.adventures.astar.AStarGoal;
import net.citizensnpcs.adventures.astar.AStarNode;

public class GoapGoal implements AStarGoal {
    private final WorldState goal;

    public GoapGoal(WorldState goal) {
        this.goal = goal.clone();
    }

    @Override
    public float g(AStarNode from) {
        return ((GoapNode) from).heuristic(goal);
    }

    @Override
    public float getInitialCost(AStarNode node) {
        return g(node);
    }

    @Override
    public float h(AStarNode from, AStarNode to) {
        return ((GoapNode) from).heuristic((GoapNode) to);
    }

    @Override
    public boolean isFinished(AStarNode node) {
        return ((GoapNode) node).stateEquals(goal);
    }
}
