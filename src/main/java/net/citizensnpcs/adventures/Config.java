package net.citizensnpcs.adventures;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import net.citizensnpcs.adventures.util.Language;
import net.citizensnpcs.api.util.Messaging;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    private final File configFile;
    private final Adventures plugin;

    public Config(Adventures plugin) {
        this.plugin = plugin;

        // Save defaults
        get().options().copyDefaults(true);
        plugin.saveConfig();

        configFile = new File(plugin.getDataFolder(), FILE_NAME);
        load();
    }

    private final FileConfiguration get() {
        return plugin.getConfig();
    }

    private void load() {
        Config.DEBUG = get().getBoolean("debug.enabled", false);
        Config.SHOW_TRACES = get().getBoolean("debug.detailed", true);
        Config.COLORS = get().getBoolean("debug.colors", true);
    }

    /**
     * Reloads the plugin's configuration file from disk. <b>This will not save
     * the current configuration. Use {@link #save()} instead!</b>
     */
    public void reload() {
        try {
            if (configFile.exists()) {
                get().load(configFile);
            }
        } catch (FileNotFoundException ex) {
            Messaging.severeTr(Language.CONFIG_FILE_NOT_FOUND);
        } catch (IOException ex) {
            Messaging.severeTr(Language.CONFIG_FILE_LOAD_ERROR);
            ex.printStackTrace();
        } catch (InvalidConfigurationException ex) {
            Messaging.severeTr(Language.CONFIG_FILE_INVALID);
            ex.printStackTrace();
        }
        load();
    }

    /** Saves the current state of the plugin's configuration file */
    public void save() {
        plugin.saveConfig();
    }

    public static boolean COLORS;
    public static boolean DEBUG;
    private final static String FILE_NAME = "config.yml";
    public static boolean SHOW_TRACES;
}
