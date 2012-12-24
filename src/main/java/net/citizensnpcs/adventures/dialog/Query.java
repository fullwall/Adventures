package net.citizensnpcs.adventures.dialog;

public interface Query {
    Object get(String key);

    String getEventName();

    void remember(String key, Object value);

    void remember(String key, Object value, long expiration);

    boolean contains(String key);
}