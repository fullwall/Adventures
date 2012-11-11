package net.citizensnpcs.adventures.astar;

public abstract class AStarNode implements Comparable<AStarNode> {
    float f, g, h;
    AStarNode parent;

    public abstract Plan buildPlan();

    @Override
    public int compareTo(AStarNode other) {
        return Float.compare(f, other.f);
    }

    public abstract Iterable<AStarNode> getNeighbours();

    protected AStarNode getParent() {
        return parent;
    }
}
