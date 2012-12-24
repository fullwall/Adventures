package net.citizensnpcs.adventures;

import java.io.File;

import net.citizensnpcs.adventures.dialog.DialogEngine;
import net.citizensnpcs.adventures.goap.npc.NPCAgent;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.trait.TraitInfo;

import org.bukkit.plugin.java.JavaPlugin;

public class Adventures extends JavaPlugin {
    private final DialogEngine engine = new DialogEngine();

    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
        getDataFolder().mkdirs();
        CitizensAPI.getTraitFactory().registerTrait(TraitInfo.create(NPCAgent.class).withName("npcagent"));
        engine.load(new File(getDataFolder(), "dialog"));
    }
}
