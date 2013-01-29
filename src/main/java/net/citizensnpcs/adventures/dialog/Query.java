package net.citizensnpcs.adventures.dialog;

public interface Query {
    boolean contains(String key);

    void forget(String... keys);

    Object get(String key);

    String getEventName();

    void remember(String key, Object value, ExpirationTime time);
}