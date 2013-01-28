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
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
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

    private Iterable<DialogTrait> getDialogTraits() {
        return dialogTraits;
    }

    @EventHandler(ignoreCancelled = true)
    public void onChat(final AsyncPlayerChatEvent event) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                Map<String, Object> eventMap = Maps.newHashMap();
                eventMap.put("message", event.getMessage());
                representEntity(eventMap, event.getPlayer(), "sender");
                for (DialogTrait trait : getDialogTraits()) {
                    trait.executeQuery(engine, "onchat", eventMap);
                }
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

    private void representEntity(Map<String, Object> eventMap, LivingEntity entity, String root) {
        eventMap.put(root, entity);
        eventMap.put(root + ".health", entity.getHealth());
        eventMap.put(root + ".maxhealth", entity.getMaxHealth());
        eventMap.put(root + ".type", entity.getType().name().toLowerCase());
        Location location = entity.getLocation();
        eventMap.put(root + "location.x", location.getX());
        eventMap.put(root + "location.y", location.getY());
        eventMap.put(root + "location.z", location.getZ());
        eventMap.put(root + "location.world", location.getWorld().getName());
        eventMap.put(root + "location.yaw", location.getYaw());
        eventMap.put(root + "location.pitch", location.getPitch());
        if (entity instanceof Player) {
            Player player = (Player) entity;
            eventMap.put(root + ".name", player.getName());
        }
    }
}
