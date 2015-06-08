package net.citizensnpcs.adventures;

import java.io.File;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import net.citizensnpcs.adventures.commands.AdminCommands;
import net.citizensnpcs.adventures.commands.DialogCommands;
import net.citizensnpcs.adventures.commands.RaceCommands;
import net.citizensnpcs.adventures.commands.TribeCommands;
import net.citizensnpcs.adventures.commands.WorldeditCommands;
import net.citizensnpcs.adventures.dialog.DialogEngine;
import net.citizensnpcs.adventures.race.RaceRegistry;
import net.citizensnpcs.adventures.race.RaceStorage;
import net.citizensnpcs.adventures.race.TribeTrait;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.command.CommandManager;
import net.citizensnpcs.api.command.CommandMessages;
import net.citizensnpcs.api.command.Injector;
import net.citizensnpcs.api.event.DespawnReason;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCDataStore;
import net.citizensnpcs.api.npc.NPCRegistry;
import net.citizensnpcs.api.npc.SimpleNPCDataStore;
import net.citizensnpcs.api.trait.Trait;
import net.citizensnpcs.api.trait.TraitInfo;
import net.citizensnpcs.api.util.Messaging;
import net.citizensnpcs.api.util.ResourceTranslationProvider;
import net.citizensnpcs.api.util.Storage;
import net.citizensnpcs.api.util.Translator;
import net.citizensnpcs.api.util.YamlStorage;

public class Adventures extends JavaPlugin {
    private final CommandManager commands = new CommandManager();
    private Config config;
    private final DialogEngine engine = new DialogEngine();
    private NPCRegistry npcRegistry;
    private NPCDataStore npcStorage;
    private final RaceRegistry raceRegistry = new RaceRegistry();
    private RaceStorage storage;

    private void despawnNPCs() {
        Iterator<NPC> itr = npcRegistry.iterator();
        while (itr.hasNext()) {
            NPC npc = itr.next();
            try {
                npc.despawn(DespawnReason.REMOVAL);
                for (Trait trait : npc.getTraits()) {
                    trait.onRemove();
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
            itr.remove();
        }
    }

    public DialogEngine getDialogEngine() {
        return engine;
    }

    public File getDialogFolder() {
        return new File(getDataFolder(), "dialog");
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
        npcStorage.storeAll(npcRegistry);
        npcStorage.saveToDiskImmediate();
        storage.save();
        despawnNPCs();
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        commands.setInjector(new Injector(this));
        getDataFolder().mkdirs();

        config = new Config(this);
        setupEngine();
        setupRegistry();
        storage = new RaceStorage(this, new File(getDataFolder(), "races"), raceRegistry);
        storage.load();
        setupCommands();
        Translator.addTranslations(new ResourceTranslationProvider("messages_en.properties", Adventures.class));
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, raceRegistry, 0, 1);
        scheduleSaveTask(20 * 60 * 60);
    }

    public void reload() {
        engine.reloadAsynchronouslyFromFolder(getDialogFolder());
        config.reload();

        despawnNPCs();
        npcStorage.loadInto(npcRegistry);
    }

    private void scheduleSaveTask(int delay) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                if (npcStorage == null)
                    return;
                npcStorage.storeAll(npcRegistry);
                npcStorage.saveToDisk();
            }
        }, delay, delay);
    }

    private void setupCommands() {
        commands.register(AdminCommands.class);
        commands.register(DialogCommands.class);
        commands.register(RaceCommands.class);
        commands.register(TribeCommands.class);
        commands.register(WorldeditCommands.class);
    }

    private void setupEngine() {
        CitizensAPI.getTraitFactory().registerTrait(TraitInfo.create(DialogTrait.class).withName("dialog"));
        CitizensAPI.getTraitFactory().registerTrait(TraitInfo.create(TribeTrait.class).withName("tribetrait"));
        engine.loadFolderAsynchronously(getDialogFolder());
        Bukkit.getPluginManager().registerEvents(new QueryEventListener(this, engine), this);
    }

    private void setupRegistry() {
        Storage storage = new YamlStorage(new File(getDataFolder(), "npcs.yml"));
        if (!storage.load())
            throw new RuntimeException("Failed to load NPCs");
        npcStorage = SimpleNPCDataStore.create(storage);
        npcRegistry = CitizensAPI.createNamedNPCRegistry(REGISTRY_NAME, npcStorage);
        npcStorage.loadInto(npcRegistry);
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

    public static final String REGISTRY_NAME = "Adventures";
}
