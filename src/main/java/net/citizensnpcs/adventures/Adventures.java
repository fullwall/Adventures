package net.citizensnpcs.adventures;

import java.io.File;

import net.citizensnpcs.adventures.dialog.DialogEngine;

import org.bukkit.plugin.java.JavaPlugin;

public class Adventures extends JavaPlugin {
    private final DialogEngine engine = new DialogEngine();

    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
        getDataFolder().mkdirs();
        engine.load(new File(getDataFolder(), "dialog"));
    }
}
