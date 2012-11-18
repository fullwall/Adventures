package net.citizensnpcs.adventures.goap;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import net.citizensnpcs.adventures.astar.AStarNode;
import net.citizensnpcs.adventures.astar.Plan;

import com.google.common.collect.Lists;

public class AStarGoapNode extends AStarNode {
    private final Agent agent;
    private final Action applied;
    private float cachedModifier = -1f;
    private final WorldState state;

    private AStarGoapNode(Agent agent, WorldState initialState) {
        this(agent, initialState, null);
    }

    private AStarGoapNode(Agent agent, WorldState initialState, Action appliedAction) {
        this.agent = agent;
        this.state = initialState;
        this.applied = appliedAction;
    }

    @Override
    public Plan buildPlan() {
        AStarGoapNode start = this;
        Deque<Action> actions = new ArrayDeque<Action>();
        while (start != null) {
            if (start.applied != null)
                actions.addFirst(start.applied);
            start = (AStarGoapNode) start.getParent();
        }
        Action[] plan = actions.toArray(new Action[actions.size()]);
        return new AStarGoapPlan(state, plan);
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

    public static AStarGoapNode create(Agent agent, WorldState initialState) {
        return new AStarGoapNode(agent, initialState);
    }
}