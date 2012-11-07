package net.citizensnpcs.adventures.astar;

import java.util.List;

public class AStarMachine {
    private AStarStorage storage;

    public void initialise(AStarStorage storage) {
        this.storage = storage;
    }

    public List<AStarNode> run(AStarGoal goal, AStarNode start) {
        storage.beginNewGoal();
        storage.open(start);
        start.f = goal.getInitialCost(start);
        AStarNode node;
        while (true) {
            node = storage.removeBestNode();
            if (node == null)
                return null;
            if (goal.isFinished(node))
                return node.buildPath();
            storage.close(node);
            for (AStarNode neighbour : node.getNeighbours()) {
                f(goal, node, neighbour);
                if (!storage.shouldExamine(neighbour))
                    continue;
                storage.open(neighbour);
                neighbour.parent = start;
            }
        }
    }

    private void f(AStarGoal goal, AStarNode node, AStarNode neighbour) {
        float g = node.g + goal.g(neighbour);
        float h = goal.h(node, neighbour);

        neighbour.f = g + h;
        neighbour.g = g;
        neighbour.h = h;
    }
}
