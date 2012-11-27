package net.citizensnpcs.adventures.goap;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import net.citizensnpcs.api.astar.AStarNode;
import net.citizensnpcs.api.astar.Plan;

import com.google.common.collect.Lists;

public class AStarGoapNode extends AStarNode {
    private final GoapAgent agent;
    private final Action applied;
    private float cachedModifier = -1f;
    private final WorldState state;

    private AStarGoapNode(GoapAgent agent, WorldState initialState) {
        this(agent, initialState, null);
    }

    private AStarGoapNode(GoapAgent agent, WorldState initialState, Action appliedAction) {
        this.agent = agent;
        this.state = initialState;
        this.applied = appliedAction;
    }

    @Override
    public Plan buildPlan() {
        Deque<Action> actions = new ArrayDeque<Action>();
        Iterable<AStarGoapNode> parents = getParents();
        for (AStarGoapNode start : parents) {
            if (start.applied != null)
                actions.add(start.applied);
        }
        Action[] plan = actions.toArray(new Action[actions.size()]);
        return new AStarGoapPlan(state, plan, getPathCost());
    }

    private float getHeuristicModifier() {
        if (applied == null)
            return 0;
        return cachedModifier == -1 ? cachedModifier = agent.getCostModifierFor(applied) * applied.getCost()
                : cachedModifier;
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
            AStarGoapNode newNode = AStarGoapNode.create(agent, newState);
            if (neighbours == null)
                neighbours = Lists.newArrayList();
            neighbours.add(newNode);
        }
        return neighbours;
    }

    public float heuristic(AStarGoapNode to) {
        return heuristic(to.state);
    }

    public float heuristic(WorldState goal) {
        return state.difference(goal) + getHeuristicModifier();
    }

    public boolean stateEquals(WorldState goal) {
        return goal.difference(state) == 0;
    }

    public int difference(WorldState otherState) {
        return otherState.difference(state);
    }

    public static AStarGoapNode create(GoapAgent agent, WorldState initialState) {
        return new AStarGoapNode(agent, initialState);
    }
}
