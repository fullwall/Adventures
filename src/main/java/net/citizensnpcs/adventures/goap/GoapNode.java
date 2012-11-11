package net.citizensnpcs.adventures.goap;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import net.citizensnpcs.adventures.astar.AStarNode;
import net.citizensnpcs.adventures.astar.Plan;

import com.google.common.collect.Lists;

public class GoapNode extends AStarNode {
    private final Agent agent;
    private final Action applied;
    private final WorldState state;

    private GoapNode(Agent agent, WorldState initialState) {
        this(agent, initialState, null);
    }

    private GoapNode(Agent agent, WorldState initialState, Action appliedAction) {
        this.agent = agent;
        this.state = initialState;
        this.applied = appliedAction;
    }

    @Override
    public Plan buildPlan() {
        GoapNode start = this;
        Deque<Action> actions = new ArrayDeque<Action>();
        while (start != null) {
            if (start.applied != null)
                actions.addFirst(start.applied);
            start = (GoapNode) start.getParent();
        }
        Action[] plan = actions.toArray(new Action[actions.size()]);
        return new GoapPlan(plan);
    }

    public int difference(GoapNode to) {
        return to.state.difference(state);
    }

    public int difference(WorldState goal) {
        return state.difference(goal);
    }

    @Override
    public Iterable<AStarNode> getNeighbours() {
        List<AStarNode> neighbours = null;
        for (Action action : agent.getAvailableActions()) {
            WorldState preconditions = action.getPreconditions();
            if (state.difference(preconditions) != 0)
                continue;
            boolean canExecute = action.evaluateContextPreconditions();
            if (!canExecute)
                continue;
            WorldState effects = action.getEffects();
            WorldState newState = state.apply(effects);
            GoapNode newNode = GoapNode.create(agent, newState);
            if (neighbours == null)
                neighbours = Lists.newArrayList();
            neighbours.add(newNode);
        }
        return neighbours;
    }

    public boolean stateEquals(WorldState goal) {
        return goal.difference(state) == 0;
    }

    public static GoapNode create(Agent agent, WorldState initialState) {
        return new GoapNode(agent, initialState);
    }
}
