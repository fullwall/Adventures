package net.citizensnpcs.adventures.commands;

import java.io.File;
import java.util.Collection;
import java.util.UUID;

import net.citizensnpcs.adventures.Adventures;
import net.citizensnpcs.adventures.race.util.BuildingSchematic;
import net.citizensnpcs.api.command.Command;
import net.citizensnpcs.api.command.CommandContext;
import net.citizensnpcs.api.command.exception.CommandException;
import net.citizensnpcs.api.npc.NPC;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.google.common.base.Function;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Collections2;
import com.google.common.collect.Multimap;
import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EmptyClipboardException;
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.Selection;

public class WorldeditCommands {
    private final Multimap<UUID, TaggedRegion> buildingTags = ArrayListMultimap.create();
    private final Adventures plugin;
    private final WorldEditPlugin worldedit;

    public WorldeditCommands(Adventures plugin) {
        this.plugin = plugin;
        this.worldedit = ((WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit"));
    }

    @Command(
            aliases = "/savebuilding",
            usage = "[name]",
            desc = "Saves the current selection to a building",
            modifiers = "*",
            min = 1,
            max = 1,
            permission = "adventures.editor.save")
    public void save(CommandContext args, Player sender, NPC npc) throws CommandException {
        LocalSession session = worldedit.getSession(sender);
        if (session == null)
            throw new CommandException();
        final CuboidClipboard clipboard;
        try {
            clipboard = session.getClipboard();
        } catch (EmptyClipboardException e) {
            throw new CommandException();
        }
        final Location origin = new Location(null, clipboard.getOrigin().getX(), clipboard.getOrigin().getY(),
                clipboard.getOrigin().getZ());
        Collection<TaggedRegion> relativeTags = Collections2.transform(buildingTags.get(sender.getUniqueId()),
                new Function<TaggedRegion, TaggedRegion>() {
            @Override
            public TaggedRegion apply(TaggedRegion arg0) {
                return new TaggedRegion(arg0.getName(), arg0.getMin().subtract(origin), arg0.getMax().subtract(
                        origin));
            }
        });
        new BuildingSchematic(args.getString(1), clipboard, relativeTags).save(new File(plugin.getDataFolder(), args
                .getString(1)));
    }

    @Command(
            aliases = "/tag",
            usage = "[name] (-c)",
            desc = "Tags the current selection",
            modifiers = "*",
            flags = "c",
            min = 1,
            max = 1,
            permission = "adventures.editor.tag")
    public void tag(CommandContext args, Player sender, NPC npc) throws CommandException {
        if (args.hasFlag('c')) {
            buildingTags.removeAll(sender.getUniqueId());
            return;
        }
        Selection selection = worldedit.getSelection(sender);
        if (selection == null)
            throw new CommandException();
        buildingTags.put(sender.getUniqueId(), new TaggedRegion(args.getString(1), selection.getMinimumPoint(),
                selection.getMaximumPoint()));
    }
}
