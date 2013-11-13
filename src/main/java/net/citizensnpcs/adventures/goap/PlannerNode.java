package net.citizensnpcs.adventures.goap;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import net.citizensnpcs.api.astar.AStarNode;
import net.citizensnpcs.api.astar.Plan;

import com.google.common.collect.Lists;

public class PlannerNode extends AStarNode {
    private final PlannerAgent agent;
    private final Action applied;
    private float cachedModifier = -1f;
    private final WorldState state;

    private PlannerNode(PlannerAgent agent, WorldState initialState) {
        this(agent, initialState, null);
    }

    private PlannerNode(PlannerAgent agent, WorldState initialState, Action appliedAction) {
        this.agent = agent;
        this.state = initialState;
        this.applied = appliedAction;
    }

    @Override
    public Plan buildPlan() {
        Deque<Action> actions = new ArrayDeque<Action>();
        Iterable<PlannerNode> parents = getParents();
        for (PlannerNode start : parents) {
            if (start.applied != null)
                actions.add(start.applied);
        }
        Action[] plan = actions.toArray(new Action[actions.size()]);
        return new ActionPlan(state, plan, getPathCost());
    }

    public int difference(WorldState otherState) {
        return otherState.difference(state);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PlannerNode other = (PlannerNode) obj;
        if (applied == null) {
            if (other.applied != null) {
                return false;
            }
        } else if (!applied.equals(other.applied)) {
            return false;
        }
        if (state == null) {
            if (other.state != null) {
                return false;
            }
        } else if (!state.equals(other.state)) {
            return false;
        }
        return true;
    }

    private float getHeuristicModifier() {
        if (applied == null)
            return 0;
        return cachedModifier == -1 ? cachedModifier = Math.max(1, agent.getCostModifierFor(applied))
                * Math.max(1, applied.getCost()) : cachedModifier;
    }

    @Override
    public Iterable<AStarNode> getNeighbours() {
        List<AStarNode> neighbours = Collections.emptyList();
        for (Action action : agent.getAvailableActions()) {
            WorldState preconditions = action.getPreconditions();
            if (preconditions != null && state.difference(preconditions) != 0)
                continue;
            boolean canExecute = action.evaluateContextPreconditions();
            if (!canExecute)
                continue;
            WorldState effects = action.getEffects();
            WorldState newState = state.apply(effects);
            PlannerNode newNode = PlannerNode.create(agent, newState, action);
            if (neighbours == Collections.EMPTY_LIST)
                neighbours = Lists.newArrayList();
            neighbours.add(newNode);
        }
        return neighbours;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((applied == null) ? 0 : applied.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        return result;
    }

    public float heuristic(PlannerNode to) {
        return heuristic(to.state);
    }

    public float heuristic(WorldState goal) {
        return state.difference(goal) + getHeuristicModifier();
    }

    public boolean stateEquals(WorldState goal) {
        return goal.difference(state) == 0;
    }

    public static PlannerNode create(PlannerAgent agent, WorldState initialState) {
        return new PlannerNode(agent, initialState);
    }

    public static PlannerNode create(PlannerAgent agent, WorldState initialState, Action appliedAction) {
        return new PlannerNode(agent, initialState, appliedAction);
    }
}
