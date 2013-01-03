package net.citizensnpcs.adventures;

import net.citizensnpcs.api.ai.GoalController;
import net.citizensnpcs.api.ai.SimpleGoalController;

public class GoalControllerAISystem implements AISystem {
    private final GoalController goalController = new SimpleGoalController();

    @Override
    public void run() {
        goalController.run();
    }
}
