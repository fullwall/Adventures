package net.citizensnpcs.adventures;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import net.citizensnpcs.adventures.dialog.DialogEngine;
import net.citizensnpcs.adventures.util.QueryRepresenters;
import net.citizensnpcs.api.event.NPCAddTraitEvent;
import net.citizensnpcs.api.event.NPCRemoveTraitEvent;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

import com.google.common.collect.Maps;

public class QueryEventListener implements Listener {
    private final Set<DialogTrait> dialogTraits = Collections.newSetFromMap(new WeakHashMap<DialogTrait, Boolean>());
    private final DialogEngine engine;

    private final Plugin plugin;

    public QueryEventListener(Plugin plugin, DialogEngine engine) {
        this.plugin = plugin;
        this.engine = engine;
    }

    private void executeQuery(Map<String, Object> eventMap, String eventName) {
        for (DialogTrait trait : getDialogTraits()) {
            trait.executeQuery(engine, eventName, eventMap);
        }
    }

    private Iterable<DialogTrait> getDialogTraits() {
        return dialogTraits;
    }

    @EventHandler(ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event) {
        Map<String, Object> eventMap = Maps.newHashMap();
        QueryRepresenters.representBlock(event.getBlock(), "block", eventMap);
        QueryRepresenters.representEntity(event.getPlayer(), "player", eventMap);
        executeQuery(eventMap, "onblockbreak");
    }

    @EventHandler(ignoreCancelled = true)
    public void onBlockPlace(BlockPlaceEvent event) {
        Map<String, Object> eventMap = Maps.newHashMap();
        QueryRepresenters.representBlock(event.getBlock(), "block", eventMap);
        QueryRepresenters.representEntity(event.getPlayer(), "player", eventMap);
        executeQuery(eventMap, "onblockplace");
    }

    @EventHandler(ignoreCancelled = true)
    public void onChat(AsyncPlayerChatEvent event) {
        final Map<String, Object> eventMap = Maps.newHashMap();
        final Player player = event.getPlayer();
        eventMap.put("message", event.getMessage());
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                QueryRepresenters.representEntity(player, "sender", eventMap);
                executeQuery(eventMap, "onchat");
            }
        }, 1);
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent event) {
        Map<String, Object> eventMap = Maps.newHashMap();
        QueryRepresenters.representEntity(event.getPlayer(), "player", eventMap);
        switch (event.getAction()) {
            case LEFT_CLICK_BLOCK:
                QueryRepresenters.representBlock(event.getClickedBlock(), "clicked", eventMap);
            case LEFT_CLICK_AIR:
                executeQuery(eventMap, "onblockleftclick");
                break;
            case RIGHT_CLICK_BLOCK:
                QueryRepresenters.representBlock(event.getClickedBlock(), "clicked", eventMap);
            case RIGHT_CLICK_AIR:
                executeQuery(eventMap, "onblockrightclick");
                break;
            case PHYSICAL:
            default:
                return;
        }
    }

    @EventHandler
    public void onTraitAdded(NPCAddTraitEvent event) {
        if (event.getTrait() instanceof DialogTrait)
            dialogTraits.add((DialogTrait) event.getTrait());
    }

    @EventHandler
    public void onTraitRemoved(NPCRemoveTraitEvent event) {
        dialogTraits.remove(event.getTrait());
    }
}
