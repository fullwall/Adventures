package net.citizensnpcs.adventures;

import java.io.File;

import net.citizensnpcs.adventures.dialog.DialogEngine;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.trait.TraitInfo;

import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.base.Supplier;

public class Adventures extends JavaPlugin {
    private final DialogEngine engine = new DialogEngine();

    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
        getDataFolder().mkdirs();
        engine.loadFolderAsynchronously(new File(getDataFolder(), "dialog"));
        CitizensAPI.getTraitFactory().registerTrait(
                TraitInfo.create(AdventuresTrait.class).withName("adventurestrait")
                        .withSupplier(new Supplier<AdventuresTrait>() {
                            @Override
                            public AdventuresTrait get() {
                                return new AdventuresTrait(engine);
                            }
                        }));
    }
}
