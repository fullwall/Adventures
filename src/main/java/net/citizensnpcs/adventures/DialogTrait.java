package net.citizensnpcs.adventures;

import java.util.Map;
import java.util.Set;

import net.citizensnpcs.adventures.dialog.AbstractQuery;
import net.citizensnpcs.adventures.dialog.DialogEngine;
import net.citizensnpcs.adventures.dialog.ExpirationTime;
import net.citizensnpcs.adventures.dialog.Memory;
import net.citizensnpcs.adventures.dialog.Rule;
import net.citizensnpcs.adventures.util.QueryRepresenters;
import net.citizensnpcs.api.persistence.Persist;
import net.citizensnpcs.api.trait.Trait;
import net.citizensnpcs.api.util.DataKey;

import com.google.common.collect.Sets;

public class DialogTrait extends Trait {
    @Persist("assignedrules")
    private final Set<String> assignedRules = Sets.newHashSet();
    private final Memory memory = new Memory();

    public DialogTrait() {
        super("dialog");
    }

    public void assignRule(String toAssign) {
        assignedRules.add(toAssign);
    }

    public void executeQuery(DialogEngine engine, String eventName, Map<String, Object> eventMap) {
        QueryRepresenters.representNPC(getNPC(), "me", eventMap);
        eventMap.putAll(memory);
        engine.execute(new SimpleQuery(eventName, eventMap));
    }

    @Override
    public void load(DataKey key) {
        memory.load(key.getRelative("memory"));
    }

    @Override
    public void run() {
    }

    @Override
    public void save(DataKey key) {
        memory.save(key.getRelative("memory"));
    }

    public void unassignRule(String assigned) {
        assignedRules.remove(assigned);
    }

    private class SimpleQuery extends AbstractQuery {
        public SimpleQuery(String eventName, Map<String, Object> queryMap) {
            super(eventName, queryMap);
        }

        @Override
        public boolean acceptsRule(Rule rule) {
            if (assignedRules.isEmpty())
                return true;
            return assignedRules.contains(rule.getName()) || assignedRules.contains(rule.getFileName());
        }

        @Override
        public void forget(String... keys) {
            super.forget(keys);
            for (String key : keys) {
                memory.remove(key);
            }
        }

        @Override
        public void remember(String key, Object value, ExpirationTime time) {
            memory.put(key, value, time);
        }
    }
}
