package net.citizensnpcs.adventures.util;

import net.citizensnpcs.adventures.Config;
import net.citizensnpcs.api.util.Colorizer;
import net.citizensnpcs.api.util.Translator;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Debug {
    public Debug() {
        sender = Bukkit.getServer().getConsoleSender();
    }

    private static CommandSender sender = null;

    /**
     * Logs an untranslated message to the console. This will only send the
     * message if the debug option is enabled inside the configuration!
     * 
     * @param message 
     *            The message to send
     * @param args 
     *            Optional arguments to parse
     */
    public static void debug(String message, Object... args) {
        if (!Config.DEBUG)
            return;
        send(Translator.translate(message, args));
    }
    
    /**
     * Logs a message to the console. This will only send the message if the
     * debug option is enabled inside the configuration!
     * 
     * @param message
     *            The message to send
     * @param args
     *            Optional arguments to parse
     */
    public static void debugTr(String message, Object... args) {
        if (!Config.DEBUG)
            return;
        send(Translator.translate(message, args));
    }
    
    /**
     * Logs a message with an additional error tag to the console. This will only
     * send the message if the debug option is enabled inside the configuration!
     * 
     * @param message 
     *            The message to send
     * @param args 
     *            Optional arguments to parse
     */
    public static void error(String message, Object... args) {
        if(!Config.DEBUG)
            return;
        String prefix = Translator.translate(Language.ERROR_LABEL);
        String msg = ChatColor.RESET + Translator.translate(message, args);
        send("<&4>" + prefix.toUpperCase() + ": " + msg);
    }

    /**
     * Logs a message with an additional info tag to the console. This will only
     * send the message if the debug option is enabled inside the configuration!
     * 
     * @param message 
     *            The message to send
     * @param args 
     *            Optional arguments to parse
     */
    public static void info(String message, Object... args) {
        if(!Config.DEBUG)
            return;
        String prefix = Translator.translate(Language.INFO_LABEL);
        String msg = ChatColor.RESET + Translator.translate(message, args);
        send("<&3>" + prefix.toUpperCase() + ": " + msg);
    }

    private static String parseColors(String msg) {
        String colorized = Colorizer.parseColors(msg);
        if (!Config.COLORS)
            colorized = ChatColor.stripColor(colorized);
        return colorized;
    }

    private static void send(String message) {
        sender.sendMessage(parseColors(ChatColor.GOLD + "[Adventures] " + message));
    }
}
