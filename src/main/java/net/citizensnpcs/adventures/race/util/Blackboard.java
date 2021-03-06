package net.citizensnpcs.adventures.race.util;

import java.util.HashMap;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Blackboard extends HashMap<String, Object> {
    private final Multimap<String, PropertySubscriber<?>> subscribers = ArrayListMultimap.create();

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Object put(String key, Object value) {
        Object old = super.put(key, value);
        for (PropertySubscriber sub : subscribers.get(key.toString())) {
            sub.onChanged(old, value);
        }
        return old;
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Object remove(Object key) {
        Object old = super.remove(key);
        if (old != null) {
            for (PropertySubscriber sub : subscribers.get(key.toString())) {
                sub.onChanged(old, null);
            }
        }
        return old;
    }

    public void subscribe(String key, PropertySubscriber<?> subscriber) {
        subscribers.put(key, subscriber);
    }

    public void unsubscribe(String key, PropertySubscriber<?> subscriber) {
        subscribers.remove(key, subscriber);
    }

    public static interface PropertySubscriber<T> {
        public void onChanged(T oldState, T newState);
    }

    private static final long serialVersionUID = 5305847736654938046L;
}
