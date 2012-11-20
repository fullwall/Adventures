package net.citizensnpcs.adventures;

import net.citizensnpcs.adventures.goap.npc.NPCAgent;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.trait.TraitInfo;

import org.bukkit.plugin.java.JavaPlugin;

public class Adventures extends JavaPlugin {
    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
        CitizensAPI.getTraitFactory().registerTrait(TraitInfo.create(NPCAgent.class).withName("npcagent"));
    }
}
