package net.citizensnpcs.adventures.goap;

import net.citizensnpcs.adventures.astar.AStarGoal;
import net.citizensnpcs.adventures.astar.AStarNode;

public class GoapGoal implements AStarGoal {
    private WorldState goal;

    @Override
    public boolean isFinished(AStarNode node) {
        return ((GoapNode) node).stateEquals(goal);
    }

    @Override
    public float getInitialCost(AStarNode node) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float g(AStarNode from) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float h(AStarNode from, AStarNode to) {
        // TODO Auto-generated method stub
        return 0;
    }
}
