package net.citizensnpcs.adventures.races.test;

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
        this.goal.reset();
    }

    @Override
    public BehaviorStatus run() {
        BehaviorStatus res = this.goal.run();
        boolean stillRunning = (res == BehaviorStatus.RUNNING);
        return stillRunning ? BehaviorStatus.RUNNING : BehaviorStatus.SUCCESS;
    }

    @Override
    public boolean shouldExecute() {
        if (context.tribe.data().get("executing", false) == true) {
            return false;
        }
        return this.goal.shouldExecute();
    }

    public static Behavior createInstance(Context context, DataKey key) {
        return new MoveRandom(context);
    }
}
