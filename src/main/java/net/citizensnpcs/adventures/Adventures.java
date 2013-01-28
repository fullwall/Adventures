package net.citizensnpcs.adventures;

import java.io.File;

import net.citizensnpcs.adventures.dialog.DialogEngine;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.trait.TraitInfo;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Adventures extends JavaPlugin {
    private final DialogEngine engine = new DialogEngine();

    public DialogEngine getDialogEngine() {
        return engine;
    }

    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
        getDataFolder().mkdirs();
        engine.loadFolderAsynchronously(new File(getDataFolder(), "dialog"));
        Bukkit.getPluginManager().registerEvents(new QueryEventListener(this, engine), this);
        CitizensAPI.getTraitFactory().registerTrait(TraitInfo.create(DialogTrait.class).withName("dialog"));
    }
}
