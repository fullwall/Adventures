package net.citizensnpcs.adventures.astar;

import java.util.List;

import com.google.common.collect.Lists;

public abstract class AStarNode implements Comparable<AStarNode> {
    float f, g, h;
    AStarNode parent;

    public abstract Iterable<AStarNode> getNeighbours();

    @Override
    public int compareTo(AStarNode other) {
        return Float.compare(f, other.f);
    }

    public List<AStarNode> buildPath() {
        AStarNode start = this;
        List<AStarNode> list = Lists.newArrayList(start);
        while (start.parent != null) {
            list.add(0, start.parent);
            start = start.parent;
        }
        return list;
    }
}
