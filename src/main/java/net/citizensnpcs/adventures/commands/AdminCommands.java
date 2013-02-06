package net.citizensnpcs.adventures.commands;

import java.io.File;

import net.citizensnpcs.adventures.Adventures;
import net.citizensnpcs.api.command.Command;
import net.citizensnpcs.api.command.CommandContext;
import net.citizensnpcs.api.command.Requirements;
import net.citizensnpcs.api.npc.NPC;

import org.bukkit.command.CommandSender;

@Requirements
public class AdminCommands {
    private final Adventures plugin;

    public AdminCommands(Adventures plugin) {
        this.plugin = plugin;
    }

    @Command(
            aliases = "adventures",
            usage = "reload",
            desc = "Reload dialog",
            modifiers = "reload",
            max = 1,
            min = 1,
            permission = "adventures.admin.reload")
    public void reload(CommandContext context, CommandSender sender, NPC npc) {
        plugin.getDialogEngine().reloadAsynchronouslyFromFolder(new File(plugin.getDataFolder(), "dialog"));
    }
}
