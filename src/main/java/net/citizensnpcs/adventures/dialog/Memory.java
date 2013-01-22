package net.citizensnpcs.adventures.dialog;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class Memory implements Map<String, Object> {
    private final Map<String, Entry> delegate = Maps.newHashMap();

    private static class Entry {
        private Entry(Object value, ExpirationTime time) {
            this.value = value;
            this.time = time;
        }

        private Entry(Object value) {
            this(value, null);
        }

        private final Object value;
        private final ExpirationTime time;
    }

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        Entry entry = delegate.get(key);
        if (entry == null)
            return false;
        return !checkExpired(key, entry);
    }

    private boolean checkExpired(Object key, Entry entry) {
        if (entry.time != null && entry.time.hasExpired()) {
            delegate.remove(key);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Entry entry : delegate.values()) {
            if (entry.value.equals(value))
                return true;
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        Entry entry = delegate.get(key);
        return entry != null && !checkExpired(key, entry) ? entry : null;
    }

    @Override
    public Object put(String key, Object value) {
        return put(key, value, null);
    }

    public Object put(String key, Object value, ExpirationTime time) {
        return delegate.put(key, new Entry(value, time));
    }

    @Override
    public Object remove(Object key) {
        Entry entry = delegate.remove(key);
        return entry == null ? null : entry.value;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Object> m) {
        for (Map.Entry<? extends String, ? extends Object> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        delegate.clear();
    }

    @Override
    public Set<String> keySet() {
        return delegate.keySet();
    }

    @Override
    public Collection<Object> values() {
        return Collections2.transform(delegate.values(), new Function<Entry, Object>() {
            @Override
            public Object apply(@Nullable Entry input) {
                return input == null ? null : input.value;
            }
        });
    }

    @Override
    public Set<java.util.Map.Entry<String, Object>> entrySet() {
        if (isEmpty())
            return Collections.emptySet();
        Set<Map.Entry<String, Object>> set = Sets.newHashSet();
        for (final Map.Entry<String, Entry> entry : delegate.entrySet()) {
            set.add(new Map.Entry<String, Object>() {
                @Override
                public String getKey() {
                    return entry.getKey();
                }

                @Override
                public Object getValue() {
                    return entry.getValue().value;
                }

                @Override
                public Object setValue(Object value) {
                    return entry.setValue(new Entry(value, entry.getValue().time));
                }
            });
        }
        return set;
    }
}
