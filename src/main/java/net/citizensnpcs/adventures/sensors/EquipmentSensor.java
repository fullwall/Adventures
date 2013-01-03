package net.citizensnpcs.adventures.sensors;

import net.citizensnpcs.adventures.goap.PlannerAgent;
import net.citizensnpcs.adventures.goap.WorldState;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.google.inject.Inject;

public class EquipmentSensor implements Sensor {
    @Inject
    private PlannerAgent agent;
    private final WorldState state = WorldState.createEmptyState();

    @Override
    public WorldState generateState() {
        ItemStack weapon = ((Player) agent.getNPC().getBukkitEntity()).getInventory().getItemInHand();
        state.put("hasWeapon", weapon.getType() == Material.DIAMOND_SWORD);
        return state;
    }
}
