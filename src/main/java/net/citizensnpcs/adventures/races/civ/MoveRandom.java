package net.citizensnpcs.adventures.races.civ;

import net.citizensnpcs.adventures.util.BehaviorLoader.Context;
import net.citizensnpcs.api.ai.goals.WanderGoal;
import net.citizensnpcs.api.ai.tree.Behavior;
import net.citizensnpcs.api.ai.tree.BehaviorStatus;
import net.citizensnpcs.api.util.DataKey;

public class MoveRandom implements Behavior {
    private final Context context;
    private final Behavior goal;

    private MoveRandom(Context context) {
        this.context = context;
        this.goal = WanderGoal.createWithNPC(context.npc);
    }

    @Override
    public void reset() {
        goal.reset();
    }

    @Override
    public BehaviorStatus run() {
        BehaviorStatus res = goal.run();
        return res == BehaviorStatus.RUNNING ? res : BehaviorStatus.SUCCESS;
    }

    @Override
    public boolean shouldExecute() {
        if (context.tribe.data().<Boolean> get("executing", false)) {
            return false;
        }
        return goal.shouldExecute();
    }

    public static Behavior createInstance(Context context, DataKey key) {
        return new MoveRandom(context);
    }
}
