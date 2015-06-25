package net.citizensnpcs.adventures.race.util;

import org.bukkit.Material;

import net.citizensnpcs.adventures.util.MaterialHolder;
import net.citizensnpcs.api.ai.tree.Behavior;
import net.citizensnpcs.api.ai.tree.BehaviorStatus;
import net.citizensnpcs.api.npc.NPC;

public class GatherMaterialTask implements Behavior {
    private final MaterialHolder holder;
    private final NPC npc;
    private final Material required;

    public GatherMaterialTask(MaterialHolder holder, Material required, NPC npc) {
        this.holder = holder;
        this.required = required;
        this.npc = npc;
    }

    @Override
    public void reset() {
    }

    @Override
    public BehaviorStatus run() {
        return null;
    }

    @Override
    public boolean shouldExecute() {
        return npc.isSpawned();
    }
}
