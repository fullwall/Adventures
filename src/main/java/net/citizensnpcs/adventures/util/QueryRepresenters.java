package net.citizensnpcs.adventures.util;

import java.util.Map;

import net.citizensnpcs.api.npc.NPC;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class QueryRepresenters {
    public static void representBlock(Block block, String root, Map<String, Object> eventMap) {
        eventMap.put(root, block);
        eventMap.put(root + ".type", block.getType());
        eventMap.put(root + ".type.name", block.getType().name().toLowerCase());
        QueryRepresenters.representLocation(block.getLocation(), root + ".location", eventMap);
    }

    public static void representEntity(Entity entity, String root, Map<String, Object> eventMap) {
        eventMap.put(root, entity);
        if (entity instanceof LivingEntity) {
            eventMap.put(root + ".health", ((LivingEntity) entity).getHealth());
            eventMap.put(root + ".maxhealth", ((LivingEntity) entity).getMaxHealth());
        }
        eventMap.put(root + ".type", entity.getType());
        eventMap.put(root + ".type.name", entity.getType().name().toLowerCase());
        QueryRepresenters.representLocation(entity.getLocation(), root + ".location", eventMap);
        if (entity instanceof Player) {
            Player player = (Player) entity;
            eventMap.put(root + ".name", player.getName());
            QueryRepresenters.representItemStack(player.getInventory().getItemInHand(), root + ".holding", eventMap);
        }
    }

    public static void representItemStack(ItemStack item, String root, Map<String, Object> eventMap) {
        if (item == null)
            return;
        eventMap.put(root, item);
        eventMap.put(root + ".type", item.getType());
        eventMap.put(root + ".type.name", item.getType().name());
        eventMap.put(root + ".durability", item.getDurability());
        eventMap.put(root + ".amount", item.getAmount());
        eventMap.put(root + ".meta", item.getItemMeta());
    }

    public static void representLocation(Location location, String root, Map<String, Object> eventMap) {
        eventMap.put(root, location);
        eventMap.put(root + ".x", location.getX());
        eventMap.put(root + ".y", location.getY());
        eventMap.put(root + ".z", location.getZ());
        eventMap.put(root + ".world", location.getWorld().getName());
        eventMap.put(root + ".yaw", location.getYaw());
        eventMap.put(root + ".pitch", location.getPitch());
    }

    public static void representNPC(NPC npc, String root, Map<String, Object> eventMap) {
        eventMap.put(root, npc);
        eventMap.put(root + ".spawned", npc.isSpawned());
        eventMap.put(root + ".id", npc.getId());
        if (npc.isSpawned())
            representEntity(npc.getEntity(), root + ".entity", eventMap);
        eventMap.put(root + ".name", npc.getName());
    }

}
