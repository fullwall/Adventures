package net.citizensnpcs.adventures;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import net.citizensnpcs.adventures.dialog.DialogEngine;
import net.citizensnpcs.api.event.NPCAddTraitEvent;
import net.citizensnpcs.api.event.NPCRemoveTraitEvent;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
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
        representBlock(event.getBlock(), "block", eventMap);
        representEntity(event.getPlayer(), "player", eventMap);
        executeQuery(eventMap, "onblockbreak");
    }

    @EventHandler(ignoreCancelled = true)
    public void onBlockPlace(BlockPlaceEvent event) {
        Map<String, Object> eventMap = Maps.newHashMap();
        representBlock(event.getBlock(), "block", eventMap);
        representEntity(event.getPlayer(), "player", eventMap);
        executeQuery(eventMap, "onblockplace");
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent event) {
        Map<String, Object> eventMap = Maps.newHashMap();
        representEntity(event.getPlayer(), "player", eventMap);
        switch (event.getAction()) {
            case LEFT_CLICK_BLOCK:
                representBlock(event.getClickedBlock(), "clicked", eventMap);
            case LEFT_CLICK_AIR:
                executeQuery(eventMap, "onblockleftclick");
                break;
            case RIGHT_CLICK_BLOCK:
                representBlock(event.getClickedBlock(), "clicked", eventMap);
            case RIGHT_CLICK_AIR:
                executeQuery(eventMap, "onblockrightclick");
                break;
            case PHYSICAL:
            default:
                return;
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onChat(final AsyncPlayerChatEvent event) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                Map<String, Object> eventMap = Maps.newHashMap();
                eventMap.put("message", event.getMessage());
                representEntity(event.getPlayer(), "sender", eventMap);
                executeQuery(eventMap, "onchat");
            }
        });
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

    private void representBlock(Block block, String root, Map<String, Object> eventMap) {
        eventMap.put(root, block);
        eventMap.put(root + ".type", block.getType());
        eventMap.put(root + ".type.name", block.getType().name().toLowerCase());
        representLocation(block.getLocation(), root + ".location", eventMap);
    }

    private void representEntity(LivingEntity entity, String root, Map<String, Object> eventMap) {
        eventMap.put(root, entity);
        eventMap.put(root + ".health", entity.getHealth());
        eventMap.put(root + ".maxhealth", entity.getMaxHealth());
        eventMap.put(root + ".type", entity.getType());
        eventMap.put(root + ".type.name", entity.getType().name().toLowerCase());
        representLocation(entity.getLocation(), root + ".location", eventMap);
        if (entity instanceof Player) {
            Player player = (Player) entity;
            eventMap.put(root + ".name", player.getName());
            representItemStack(player.getInventory().getItemInHand(), root + ".holding", eventMap);
        }
    }

    private void representItemStack(ItemStack item, String root, Map<String, Object> eventMap) {
        if (item == null)
            return;
        eventMap.put(root + ".type", item.getType());
        eventMap.put(root + ".type.name", item.getType().name());
        eventMap.put(root + ".durability", item.getDurability());
        eventMap.put(root + ".amount", item.getAmount());
        eventMap.put(root + ".meta", item.getItemMeta());
        eventMap.put(root, item);
    }

    private void representLocation(Location location, String root, Map<String, Object> eventMap) {
        eventMap.put(root + ".x", location.getX());
        eventMap.put(root + ".y", location.getY());
        eventMap.put(root + ".z", location.getZ());
        eventMap.put(root + ".world", location.getWorld().getName());
        eventMap.put(root + ".yaw", location.getYaw());
        eventMap.put(root + ".pitch", location.getPitch());
    }
}
