package net.citizensnpcs.adventures.astar;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import com.google.common.collect.Maps;

public class SimpleAStarStorage implements AStarStorage {
    private final Queue<AStarNode> queue = new PriorityQueue<AStarNode>();
    private final Map<AStarNode, Float> closed = Maps.newHashMap();
    private final Map<AStarNode, Float> open = Maps.newHashMap();

    @Override
    public void open(AStarNode node) {
        queue.offer(node);
        open.put(node, node.f);
    }

    @Override
    public AStarNode removeBestNode() {
        return queue.poll();
    }

    @Override
    public void close(AStarNode node) {
        closed.put(node, node.f);
    }

    @Override
    public boolean shouldExamine(AStarNode neighbour) {
        Float openF = open.get(neighbour);
        if (openF != null && openF > neighbour.f) {
            open.remove(neighbour);
            openF = null;
        }
        Float closedF = closed.get(neighbour);
        if (closedF != null && closedF > neighbour.f) {
            closed.remove(neighbour);
            closedF = null;
        }
        return closedF == null && openF == null;
    }

    @Override
    public void beginNewGoal() {
        queue.clear();
        closed.clear();
    }
}
