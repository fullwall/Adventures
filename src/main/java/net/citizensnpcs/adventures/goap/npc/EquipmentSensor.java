package net.citizensnpcs.adventures.goap.npc;

import net.citizensnpcs.adventures.goap.Agent;
import net.citizensnpcs.adventures.goap.Sensor;
import net.citizensnpcs.adventures.goap.WorldState;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class EquipmentSensor implements Sensor {
    private final WorldState state = WorldState.createEmptyState();
    private Agent agent;

    @Override
    public WorldState generateState() {
        ItemStack weapon = ((Player) agent.getNPC().getBukkitEntity()).getInventory().getItemInHand();
        state.put("hasWeapon", weapon.getType() == Material.DIAMOND_SWORD);
        return state;
    }
}
