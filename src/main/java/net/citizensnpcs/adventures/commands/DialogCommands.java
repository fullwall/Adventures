package net.citizensnpcs.adventures.commands;

import net.citizensnpcs.adventures.Adventures;
import net.citizensnpcs.adventures.DialogTrait;
import net.citizensnpcs.adventures.util.Language;
import net.citizensnpcs.api.command.Command;
import net.citizensnpcs.api.command.CommandContext;
import net.citizensnpcs.api.command.Requirements;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.util.Messaging;

import org.bukkit.command.CommandSender;

@Requirements(selected = true, ownership = true)
public class DialogCommands {
    public DialogCommands(Adventures plugin) {
    }

    @Command(
            aliases = "dialog",
            usage = "assign [rule name]",
            desc = "Assign dialog rules",
            modifiers = "assign",
            max = 2,
            min = 2,
            permission = "adventures.dialog.assign")
    public void assign(CommandContext args, CommandSender sender, NPC npc) {
        npc.getTrait(DialogTrait.class).assignRule(args.getString(1));
        Messaging.sendTr(sender, Language.ASSIGNED_SUCCESSFULLY, args.getString(1));
    }

    @Command(
            aliases = "dialog",
            usage = "unassign [rule name]",
            desc = "Unassign dialog rules",
            modifiers = "unassign",
            max = 2,
            min = 2,
            permission = "adventures.dialog.unassign")
    public void unassign(CommandContext args, CommandSender sender, NPC npc) {
        npc.getTrait(DialogTrait.class).unassignRule(args.getString(1));
        Messaging.sendTr(sender, Language.UNASSIGNED_SUCCESSFULLY, args.getString(1));
    }
}
