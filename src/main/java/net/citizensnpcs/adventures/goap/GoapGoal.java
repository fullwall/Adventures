package net.citizensnpcs.adventures.goap;

import net.citizensnpcs.adventures.astar.AStarGoal;
import net.citizensnpcs.adventures.astar.AStarNode;

public class GoapGoal implements AStarGoal {
    private WorldState goal;

    @Override
    public float g(AStarNode from) {
        return ((GoapNode) from).difference(goal);
    }

    @Override
    public float getInitialCost(AStarNode node) {
        return g(node);
    }

    @Override
    public float h(AStarNode from, AStarNode to) {
        return ((GoapNode) from).difference((GoapNode) to);
    }

    @Override
    public boolean isFinished(AStarNode node) {
        return ((GoapNode) node).stateEquals(goal);
    }
}
