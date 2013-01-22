package net.citizensnpcs.adventures;

import java.util.Map;

import net.citizensnpcs.adventures.dialog.AbstractQuery;
import net.citizensnpcs.adventures.dialog.DialogEngine;
import net.citizensnpcs.adventures.dialog.ExpirationTime;
import net.citizensnpcs.adventures.dialog.Memory;
import net.citizensnpcs.api.trait.Trait;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.google.common.collect.Maps;

public class AdventuresTrait extends Trait {
    private DialogEngine dialogEngine;
    private final Memory memory = new Memory();

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
        Map<String, Object> eventMap = Maps.newHashMap();
        eventMap.put("message", event.getMessage());
        executeQuery("onchat", eventMap);
    }

    private void executeQuery(String eventName, Map<String, Object> eventMap) {
        eventMap.putAll(memory);
        dialogEngine.execute(new SimpleQuery(eventName, eventMap));
    }

    @Override
    public void run() {
    }

    private class SimpleQuery extends AbstractQuery {
        public SimpleQuery(String eventName, Map<String, Object> queryMap) {
            super(eventName, queryMap);
        }

        @Override
        public void remember(String key, Object value, ExpirationTime time) {
            memory.put(key, value, time);
        }
    }
}
