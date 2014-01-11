package net.citizensnpcs.adventures.util;

import net.citizensnpcs.adventures.Adventures;
import net.citizensnpcs.adventures.dialog.DialogException;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.util.Messaging;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TargetUtil {
    private TargetUtil() {
    }

    /**
     * Accepted formats: p:name n:npc id e:id
     */
    private static void parseAndSend(String message, String target) {
        if (target.equalsIgnoreCase("log")) {
            System.out.println(message);
            return;
        }

        if (target.equalsIgnoreCase("broadcast")) {
            Bukkit.broadcastMessage(message);
            return;
        }

        if (target.startsWith("p:")) {
            Player player = Bukkit.getPlayerExact(target.substring(2));
            if (player == null)
                throw new DialogException("Couldn't find online player from target " + target);
            Messaging.send(player, message);
            return;
        }

        if (target.startsWith("n:")) {
            int id;
            try {
                id = Integer.parseInt(target.substring(2));
            } catch (NumberFormatException ex) {
                throw new DialogException("Invalid ID " + target.substring(2));
            }
            NPC npc = CitizensAPI.getNamedNPCRegistry(Adventures.REGISTRY_NAME).getById(id);
            if (npc == null)
                throw new DialogException("Couldn't find NPC with id " + id);
            if (!(npc.getEntity() instanceof CommandSender))
                throw new DialogException("NPC was not a command sender");

            Messaging.send((CommandSender) npc.getEntity(), message);
            return;
        }

        throw new DialogException("Unable to parse target format");
    }

    public static void sendMessage(String message, Object rawTarget) {
        if (rawTarget instanceof CommandSender) {
            Messaging.send((CommandSender) rawTarget, message);
            return;
        }
        if (rawTarget instanceof CommandSender[]) {
            for (CommandSender sender : ((CommandSender[]) rawTarget)) {
                Messaging.send(sender, message);
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
