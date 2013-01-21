package net.citizensnpcs.adventures.dialog;

import java.util.Collections;
import java.util.Map;

public abstract class AbstractQuery implements Query {
    private final Map<String, Object> queryVariables;
    private final String eventName;

    public AbstractQuery(String eventName, Map<String, Object> queryMap) {
        this.queryVariables = queryMap == null ? Collections.<String, Object> emptyMap() : queryMap;
        this.eventName = eventName;
    }

    @Override
    public boolean contains(String key) {
        return queryVariables.containsKey(key);
    }

    @Override
    public Object get(String key) {
        return queryVariables.get(key);
    }

    @Override
    public String getEventName() {
        return eventName;
    }

    @Override
    public void remember(String key, Object value) {
        remember(key, value, Long.MAX_VALUE);
    }
}
