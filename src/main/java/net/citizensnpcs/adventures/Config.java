package net.citizensnpcs.adventures;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;


public class Config {
	private final File configFile;
	private final Adventures plugin;
	public Config( Adventures plugin ) {
		this.plugin = plugin;
		
		// Save defaults
		get().options().copyDefaults( true );
		plugin.saveConfig();
		
		configFile = new File(plugin.getDataFolder(), FILE_NAME);
		
		Config.DEBUG = get().getBoolean("debug.enabled", false);
		Config.SHOW_TRACES = get().getBoolean("debug.detailed", true);
		Config.COLORS = get().getBoolean("debug.colors", true);
	}
	
	/**
	 * Returns the {@link FileConfiguration} for the Adventures plugin
	 * 
	 * @return The plugin configuration
	 */
	public final FileConfiguration get() {
		return plugin.getConfig();
	}
	
	/**
	 * Reloads the plugin's configuration file from disk.
	 * <b>This will not save the current configuration. Use {@link #save()} instead!</b>
	 */
	public void reload() {
		try {
			if(configFile.exists()) get().load(configFile);
			
		} catch (FileNotFoundException ex) {
			// TODO "Configuration file not found!"
		} catch (IOException ex) {
			// TODO "Could not read configuration file!"
		} catch (InvalidConfigurationException ex) {
			// TODO "Invalid configuration, please check if the YAML is valid!"
		}
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