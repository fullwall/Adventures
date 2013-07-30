package net.citizensnpcs.adventures.commands;

import net.citizensnpcs.adventures.Adventures;
import net.citizensnpcs.adventures.util.Language;
import net.citizensnpcs.api.command.Command;
import net.citizensnpcs.api.command.CommandContext;
import net.citizensnpcs.api.command.Requirements;
import net.citizensnpcs.api.command.exception.CommandException;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.util.Messaging;

import org.bukkit.command.CommandSender;

@Requirements
public class TribeCommands {
    private final Adventures plugin;

    public TribeCommands(Adventures plugin) {
        this.plugin = plugin;
    }

    @Command(
            aliases = "tribe",
            usage = "remove (-a)",
            desc = "Removes a tribe",
            modifiers = "remove",
            min = 1,
            max = 2,
            permission = "adventures.tribe.remove")
    public void remove(CommandContext args, CommandSender sender, NPC npc) throws CommandException {
        if (args.hasFlag('a')) {
            plugin.getRaceRegistry().destroyAllTribes();
            Messaging.sendTr(sender, Language.TRIBES_REMOVED_SUCCESSFULLY);
        }
    }
}
