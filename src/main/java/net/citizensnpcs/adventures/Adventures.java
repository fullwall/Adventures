package net.citizensnpcs.adventures;

import java.io.File;

import net.citizensnpcs.adventures.commands.AdminCommands;
import net.citizensnpcs.adventures.commands.DialogCommands;
import net.citizensnpcs.adventures.commands.RaceCommands;
import net.citizensnpcs.adventures.commands.TribeCommands;
import net.citizensnpcs.adventures.dialog.DialogEngine;
import net.citizensnpcs.adventures.dialog.statements.DenizenScript;
import net.citizensnpcs.adventures.race.RaceRegistry;
import net.citizensnpcs.adventures.race.RaceStorage;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.command.CommandManager;
import net.citizensnpcs.api.command.CommandMessages;
import net.citizensnpcs.api.command.Injector;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.trait.TraitInfo;
import net.citizensnpcs.api.util.Messaging;
import net.citizensnpcs.api.util.ResourceTranslationProvider;
import net.citizensnpcs.api.util.Translator;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.PluginClassLoader;

public class Adventures extends JavaPlugin {
    private final CommandManager commands = new CommandManager();
    private Config config;
    private final DialogEngine engine = new DialogEngine();
    private final RaceRegistry raceRegistry = new RaceRegistry();
    private RaceStorage storage;

    public DialogEngine getDialogEngine() {
        return engine;
    }

    public File getDialogFolder() {
        return new File(getDataFolder(), "dialog");
    }

    public PluginClassLoader getPluginClassLoader() {
        return (PluginClassLoader) super.getClassLoader();
    }

    public RaceRegistry getRaceRegistry() {
        return raceRegistry;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String cmdName, String[] args) {
        String modifier = args.length > 0 ? args[0] : "";
        if (!commands.hasCommand(command, modifier) && !modifier.isEmpty()) {
            return suggestClosestModifier(sender, command.getName(), modifier);
        }
        NPC npc = CitizensAPI.getDefaultNPCSelector().getSelected(sender);
        Object[] methodArgs = { sender, npc };
        return commands.executeSafe(command, args, sender, methodArgs);
    }

    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        commands.setInjector(new Injector(this));
        getDataFolder().mkdirs();

        config = new Config(this);
        storage = new RaceStorage(this, new File(getDataFolder(), "races"), raceRegistry);
        storage.load();
        setupEngine();
        setupCommands();

        Bukkit.getPluginManager().registerEvents(new QueryEventListener(this, engine), this);
        CitizensAPI.getTraitFactory().registerTrait(TraitInfo.create(DialogTrait.class).withName("dialog"));
        Translator.addTranslations(new ResourceTranslationProvider("messages_en.properties", Adventures.class));
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, raceRegistry, 0, 1);
    }

    public void reload() {
        engine.reloadAsynchronouslyFromFolder(getDialogFolder());
        config.reload();
    }

    private void setupCommands() {
        commands.register(AdminCommands.class);
        commands.register(DialogCommands.class);
        commands.register(RaceCommands.class);
        commands.register(TribeCommands.class);
    }

    private void setupEngine() {
        Plugin denizenPlugin = Bukkit.getPluginManager().getPlugin("Denizen");
        if (denizenPlugin != null)
            engine.getStatementRegistry().register(DenizenScript.class);
        engine.loadFolderAsynchronously(getDialogFolder());
    }

    private boolean suggestClosestModifier(CommandSender sender, String command, String modifier) {
        String closest = commands.getClosestCommandModifier(command, modifier);
        if (!closest.isEmpty()) {
            Messaging.send(sender, ChatColor.GRAY + Messaging.tr(CommandMessages.UNKNOWN_COMMAND));
            Messaging.send(sender, " <e>/<a>" + command + " <e>" + closest + "<a>");
            return true;
        }
        return false;
    }
}
