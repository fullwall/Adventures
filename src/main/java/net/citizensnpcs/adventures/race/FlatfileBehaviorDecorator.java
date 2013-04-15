package net.citizensnpcs.adventures.race;

import net.citizensnpcs.adventures.DialogTrait;
import net.citizensnpcs.adventures.util.BehaviorLoader;
import net.citizensnpcs.api.ai.Goal;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.util.FileStorage;

public class FlatfileBehaviorDecorator implements TribeMemberDecorator {
    private final FileStorage storage;

    public FlatfileBehaviorDecorator(FileStorage storage) {
        this.storage = storage;
    }

    @Override
    public NPC decorate(Tribe tribe, NPC npc) {
        Goal rootMemberGoal = BehaviorLoader.loadBehaviors(storage.getFile(), storage.getKey("members.behavior"));
        Goal rootTribeGoal = BehaviorLoader.loadBehaviors(storage.getFile(), storage.getKey("tribe.behavior"));
        if (rootMemberGoal != null)
            npc.getDefaultGoalController().addGoal(rootMemberGoal, 1);
        if (rootTribeGoal != null)
            tribe.getTribeAI().addGoal(rootTribeGoal, 1);
        npc.addTrait(DialogTrait.class);
        return npc;
    }
}
