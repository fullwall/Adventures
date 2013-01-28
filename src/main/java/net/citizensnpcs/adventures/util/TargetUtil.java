package net.citizensnpcs.adventures.util;

import net.citizensnpcs.adventures.dialog.DialogException;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TargetUtil {
    private TargetUtil() {
    }

    /**
     * Accepted formats: p:name n:npcid
     */
    private static void parseAndSend(String message, String target) {
        if (target.equalsIgnoreCase("log")) {
            if (Bukkit.getServer() == null) {
                System.out.println(message);
            } else
                Bukkit.getConsoleSender().sendMessage(message);
            return;
        }
        if (target.equalsIgnoreCase("broadcast")) {
            Bukkit.broadcastMessage(message);
        }
        if (target.startsWith("p:")) {
            Player player = Bukkit.getPlayerExact(target.substring(2));
            if (player == null)
                throw new DialogException("Couldn't find online player from target " + target);
            player.sendMessage(message);
            return;
        }
        if (target.startsWith("n:")) {
            int id;
            try {
                id = Integer.parseInt(target.substring(2));
            } catch (NumberFormatException ex) {
                throw new DialogException("Invalid ID " + target.substring(2));
            }
            NPC npc = CitizensAPI.getNPCRegistry().getById(id);
            if (npc == null)
                throw new DialogException("Couldn't find NPC with id " + id);
            if (!(npc.getBukkitEntity() instanceof CommandSender))
                throw new DialogException("NPC was not a command sender");
            ((CommandSender) npc.getBukkitEntity()).sendMessage(message);
            return;
        }
        throw new DialogException("Unable to parse target format");
    }

    public static void sendMessage(String message, Object rawTarget) {
        if (rawTarget instanceof CommandSender) {
            ((CommandSender) rawTarget).sendMessage(message);
            return;
        }
        if (rawTarget instanceof CommandSender[]) {
            for (CommandSender sender : ((CommandSender[]) rawTarget)) {
                sender.sendMessage(message);
            }
            return;
        }
        if (rawTarget instanceof String) {
            parseAndSend(message, (String) rawTarget);
            return;
        }
        if (rawTarget instanceof String[]) {
            for (String string : (String[]) rawTarget) {
                parseAndSend(message, string);
            }
            return;
        }
        throw new DialogException("Invalid target type " + rawTarget);
    }
}
