package net.aufdemrand.denizen.scripts.triggers.core;

import net.aufdemrand.denizen.npc.traits.TriggerTrait;
import net.aufdemrand.denizen.scripts.triggers.AbstractTrigger;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;

import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageTrigger extends AbstractTrigger implements Listener {

    @EventHandler
    public void damageTrigger(EntityDamageByEntityEvent event) {
        // Get player
        Player player = null;
        if (event.getDamager() instanceof Player) player = (Player) event.getDamager();
        else if (event.getDamager() instanceof Projectile
                && ((Projectile) event.getDamager()).getShooter() instanceof Player)
            player = (Player) ((Projectile)event.getDamager()).getShooter();

        // Get NPC
        if (CitizensAPI.getNPCRegistry().isNPC(event.getEntity()) && player != null) {
            NPC npc = CitizensAPI.getNPCRegistry().getNPC(event.getEntity());

            // Check if NPC has triggers.
            if (!npc.hasTrait(TriggerTrait.class)) return;
            
            // Check if trigger is enabled.
            if (!npc.getTrait(TriggerTrait.class).isEnabled(name)) return;

            // If engaged or not cool, calls On Unavailable, if cool, calls On Click
            // If available (not engaged, and cool) sets cool down and returns true. 
            if (!npc.getTrait(TriggerTrait.class).trigger(this, player)) return;

            // Get Interact Script for Player/NPC
            String script = sH.getInteractScript(npc, player, this.getClass());

            // Parse Damage Trigger, if unable to parse call No Damange Trigger action
            if (!parse(denizen.getNPCRegistry().getDenizen(npc), player, script))
                denizen.getNPCRegistry().getDenizen(npc).action("no damage trigger", player);
        }
    }

    @Override
    public void onEnable() {
        denizen.getServer().getPluginManager().registerEvents(this, denizen);
    }

}
