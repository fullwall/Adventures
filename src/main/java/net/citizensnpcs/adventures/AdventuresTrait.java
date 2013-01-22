package net.citizensnpcs.adventures;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import net.citizensnpcs.adventures.dialog.AbstractQuery;
import net.citizensnpcs.adventures.dialog.DialogEngine;
import net.citizensnpcs.api.trait.Trait;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.google.common.collect.DiscreteDomains;
import com.google.common.collect.Ranges;

public class AdventuresTrait extends Trait {
    private DialogEngine dialogEngine;

    public AdventuresTrait() {
        super("adventurestrait");
    }

    public AdventuresTrait(DialogEngine engine) {
        this();
        this.dialogEngine = engine;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        dialogEngine.execute(null);
    }

    @Override
    public void run() {
    }

    public static void main(String[] args) {
        System.err.println(Ranges.<Integer> all().asSet(DiscreteDomains.integers()));
    }

    private class SimpleQuery extends AbstractQuery {
        public SimpleQuery(String eventName, Map<String, Object> queryMap) {
            super(eventName, queryMap);
        }

        @Override
        public void remember(String key, Object value, long expiration, TimeUnit unit) {
            // memory.put(key, value, expiration, units);
            // TODO: figure out a good syntax for persistence and add a Memory
            // class
        }
    }
}
