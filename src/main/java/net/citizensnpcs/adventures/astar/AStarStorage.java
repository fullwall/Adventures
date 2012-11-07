package net.citizensnpcs.adventures.astar;

public interface AStarStorage {
    void open(AStarNode node);

    AStarNode removeBestNode();

    void close(AStarNode node);

    boolean shouldExamine(AStarNode neighbour);

    void beginNewGoal();
}
