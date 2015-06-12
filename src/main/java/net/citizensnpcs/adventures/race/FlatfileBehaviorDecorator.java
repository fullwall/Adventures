package net.citizensnpcs.adventures.race;

import com.google.common.base.Splitter;

import net.citizensnpcs.adventures.DialogTrait;
import net.citizensnpcs.adventures.util.BehaviorLoader;
import net.citizensnpcs.adventures.util.BehaviorLoader.Context;
import net.citizensnpcs.api.ai.tree.Behavior;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.util.DataKey;
import net.citizensnpcs.api.util.FileStorage;

public class FlatfileBehaviorDecorator implements TribeDecorator {
    private final FileStorage storage;

    public FlatfileBehaviorDecorator(FileStorage storage) {
        this.storage = storage;
    }

    @Override
    public void decorate(Tribe tribe) {
        if (!tribe.getTribeAI().iterator().hasNext()) {
            Behavior rootTribeGoal = BehaviorLoader.loadBehaviors(new Context(tribe), storage.getKey("tribe.behavior"));
            if (rootTribeGoal != null) {
                tribe.getTribeAI().addBehavior(rootTribeGoal, 1);
            }
        }
        for (NPC npc : tribe.getMembers()) {
            Behavior rootMemberGoal = BehaviorLoader.loadBehaviors(new Context(tribe, npc),
                    storage.getKey("members.behavior"));
            if (rootMemberGoal != null) {
                npc.getDefaultGoalController().addBehavior(rootMemberGoal, 1);
            }
            DialogTrait trait = new DialogTrait();
            DataKey dialogKey = storage.getKey("dialog.allowed-rules");
            if (dialogKey.keyExists()) {
                for (String allowed : Splitter.on(',').trimResults().omitEmptyStrings()
                        .split(dialogKey.getString(""))) {
                    trait.assignRule(allowed);
                }
            }
            npc.addTrait(trait);
        }
    }
}
