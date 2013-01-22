package net.citizensnpcs.adventures.dialog;

import java.util.concurrent.TimeUnit;

public interface Query {
    boolean contains(String key);

    Object get(String key);

    String getEventName();

    void remember(String key, Object value);

    void remember(String key, Object value, long expiration);

    void remember(String key, Object value, long expiration, TimeUnit unit);
}