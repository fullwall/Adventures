package net.citizensnpcs.adventures.util.debug;

import net.citizensnpcs.adventures.Adventures;
import net.citizensnpcs.adventures.Config;
import net.citizensnpcs.api.util.Colorizer;
import net.citizensnpcs.api.util.Messaging;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;


public class Debug {
	private static CommandSender sender = null;
	private Adventures plugin;
	
	
	public Debug( Adventures plugin ) {
		this.plugin = plugin;
		
		sender = Bukkit.getServer().getConsoleSender();
	}
	
	/**
	 * Logs a message to the console. This will only send the message if the
	 * debug option is enabled inside the configuration!
	 * 
	 * @param message The message to send
	 * @param args Optional arguments to parse
	 */
	public static void log( String message, Object... args ) {
		if(!Config.DEBUG) return;
		
		send(parseArguments(message, args));
	}
	
	/**
	 * Logs a message with an additional info tag to the console. This will only
	 * send the message if the debug option is enabled inside the configuration!
	 * 
	 * @param message The message to send
	 * @param args Optional arguments to parse
	 */
	public static void info( String message, Object... args ) {
		if(!Config.DEBUG) return;
		
		String msg = ChatColor.RESET + parseArguments(message, args);
		send("<&3>" + Language.INFORMATION.toUpperCase() + ": " + msg);
	}
	
	/**
	 * Logs a message with an additional error tag to the console. This will only
	 * send the message if the debug option is enabled inside the configuration!
	 * 
	 * @param message The message to send
	 * @param args Optional arguments to parse
	 */
	public static void error( String message, Object... args ) {
		if(!Config.DEBUG) return;
		
		String msg = ChatColor.RESET + parseArguments(message, args);
		send("<&4>" + Language.ERROR.toUpperCase() + ": " + msg);
	}
	
	/**
	 * Sends a message to the console.
	 * 
	 * @param message The message to send
	 */
	private static void send( String message ) {
		sender.sendMessage(parseColors(ChatColor.GOLD + "[q] " + message));
	}
	
	/**
	 * Sends a formatted message to the specificied sender.
	 * 
	 * @param sender The sender to send the message to
	 * @param message The message to send
	 * @param args Additional arguments to parse
	 */
	public static void send( CommandSender sender, String message, Object... args ) {
		String msg = parseColors(parseArguments(message, args));
		sender.sendMessage(msg);
	}
	
	/**
	 * Parses color codes inside a message string. If the colors are disabled
	 * inside the configuration, they will be stripped out again.
	 * 
	 * @param msg The message to parse
	 * 
	 * @return The colorized message
	 */
	private static String parseColors( String msg ) {
		String colorized = Colorizer.parseColors(msg);
		
		if(!Config.COLORS) colorized = ChatColor.stripColor(colorized);
			
		return colorized;
	}
	
	/**
	 * Parses arguments inside a message string. Argument format: '%' + id.
	 * 
	 * @param msg The message to parse
	 * @param args The argument list
	 * 
	 * @return The parsed message string
	 */
	private static String parseArguments( String msg, Object... args ) {
		if(args.length < 1) return msg;
		
		for (int i = 0; i < args.length; i++) {
			msg = msg.replaceAll( "%" + i, args[i].toString() );
		}
		
		return msg;
	}
	
}
