package net.citizensnpcs.adventures;

import java.io.File;

import net.citizensnpcs.adventures.dialog.DialogEngine;
import net.citizensnpcs.adventures.dialog.statements.DenizenScript;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.command.CommandManager;
import net.citizensnpcs.api.trait.TraitInfo;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Adventures extends JavaPlugin {
    private final CommandManager commands = new CommandManager();
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
        setupEngine();
        setupCommands();

        Bukkit.getPluginManager().registerEvents(new QueryEventListener(this, engine), this);
        CitizensAPI.getTraitFactory().registerTrait(TraitInfo.create(DialogTrait.class).withName("dialog"));
    }

    private void setupCommands() {
        commands.register(Class.class);
    }

    private void setupEngine() {
        Plugin denizenPlugin = Bukkit.getPluginManager().getPlugin("Denizen");
        if (denizenPlugin != null)
            engine.getStatementRegistry().register(DenizenScript.class);
        engine.loadFolderAsynchronously(new File(getDataFolder(), "dialog"));
    }
}
