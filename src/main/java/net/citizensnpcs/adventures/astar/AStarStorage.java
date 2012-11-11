package net.citizensnpcs.adventures.astar;

public interface AStarStorage {
    void beginNewGoal();

    void close(AStarNode node);

    void open(AStarNode node);

    AStarNode removeBestNode();

    boolean shouldExamine(AStarNode neighbour);
}
