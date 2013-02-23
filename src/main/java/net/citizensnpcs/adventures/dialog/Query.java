package net.citizensnpcs.adventures.dialog;

import net.citizensnpcs.adventures.dialog.evaluators.VariableSource;

public interface Query extends VariableSource {
    boolean acceptsRule(Rule rule);

    boolean contains(String key);

    void forget(String... keys);

    Object get(String key);

    String getEventName();

    void remember(String key, Object value, ExpirationTime time);
}