package net.citizensnpcs.adventures.commands;

import net.citizensnpcs.adventures.Adventures;
import net.citizensnpcs.adventures.race.RaceDescriptor;
import net.citizensnpcs.adventures.race.Tribe;
import net.citizensnpcs.adventures.util.Language;
import net.citizensnpcs.api.command.Command;
import net.citizensnpcs.api.command.CommandContext;
import net.citizensnpcs.api.command.Requirements;
import net.citizensnpcs.api.command.exception.CommandException;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.util.Messaging;

import org.bukkit.command.CommandSender;

@Requirements
public class RaceCommands {
    private final Adventures plugin;

    public RaceCommands(Adventures plugin) {
        this.plugin = plugin;
    }

    @Command(
            aliases = "race",
            usage = "generate [race]",
            desc = "Generates a race at the location",
            modifiers = "generate",
            min = 2,
            max = 2,
            permission = "adventures.race.generate")
    public void generate(CommandContext args, CommandSender sender, NPC npc) throws CommandException {
        RaceDescriptor desc = plugin.getRaceRegistry().getDescriptor(args.getString(1));
        if (desc == null)
            throw new CommandException(Language.UNKNOWN_RACE, args.getString(1));
        if (args.getSenderLocation() == null)
            throw new CommandException(Language.NO_GENERATION_LOCATION);
        Tribe tribe = desc.generateAndRegisterTribe(args.getSenderLocation().getChunk());
        if (tribe == null)
            throw new CommandException(Language.UNKNOWN_RACE_GENERATOR);
        Messaging.sendTr(sender, Language.TRIBE_GENERATED_SUCCESSFULLY, desc.getName());
    }
}
