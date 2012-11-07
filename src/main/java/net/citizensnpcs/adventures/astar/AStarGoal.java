package net.citizensnpcs.adventures.astar;

public interface AStarGoal {
    /**
     * Returns whether the supplied {@link AStarNode} represents the goal state
     * for this <code>AStarGoal</code>. This will halt execution of the calling
     * {@link AStarMachine}.
     * 
     * @param node
     *            The node to check
     * @return Whether the node is the goal state
     */
    boolean isFinished(AStarNode node);

    /**
     * Returns the initial cost value when starting from the supplied
     * {@link AStarNode}. This represents an initial estimate for reaching the
     * goal state from the start node.
     * 
     * @param node
     *            The start node
     * @return The initial cost
     */
    float getInitialCost(AStarNode node);

    float g(AStarNode from);

    float h(AStarNode from, AStarNode to);
}
