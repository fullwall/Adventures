package net.citizensnpcs.adventures.dialog;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import net.citizensnpcs.api.util.DataKey;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class Memory implements Map<String, Object> {
    private final Map<String, Entry> delegate = Maps.newHashMap();

    private boolean checkExpired(String key, Entry entry) {
        if (entry.expiration != Long.MAX_VALUE && System.nanoTime() >= entry.expiration) {
            delegate.remove(key);
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        delegate.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        Entry entry = delegate.get((String ) key);
        if (entry == null)
            return false;
        return !checkExpired((String ) key, entry);
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
                    return entry.setValue(new Entry(value, entry.getValue()));
                }
            });
        }
        return set;
    }

    @Override
    public Object get(Object key) {
        Entry entry = delegate.get(key);
        return entry != null && !checkExpired((String ) key, entry) ? entry : null;
    }

    @Override
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public Set<String> keySet() {
        return delegate.keySet();
    }

    public void load(DataKey key) {
        delegate.clear();
        for (DataKey sub : key.getSubKeys()) {
            long expiration = sub.getLong("expiration");
            Object value = sub.getRaw("value");
            delegate.put(sub.name(), new Entry(value, expiration, true));
        }
    }

    @Override
    public Object put(String key, Object value) {
        return put(key, value, null);
    }

    public Object put(String key, Object value, ExpirationTime time) {
        return delegate.put(key, new Entry(value, time.getExpirationTimeFromNow(), time.isPersistent()));
    }

    @Override
    public void putAll(Map<? extends String, ? extends Object> m) {
        for (Map.Entry<? extends String, ? extends Object> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public Object remove(Object key) {
        Entry entry = delegate.remove(key);
        return entry == null ? null : entry.value;
    }

    public void save(DataKey key) {
        key.removeKey("");
        for (Map.Entry<String, Entry> entry : delegate.entrySet()) {
            if (!entry.getValue().isPersistent)
                continue;
            DataKey root = key.getRelative(entry.getKey());
            root.setLong("expiration", entry.getValue().expiration);
            root.setRaw("value", entry.getValue().value);
        }
    }

    @Override
    public int size() {
        return delegate.size();
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

    private static class Entry {
        private final long expiration;
        private final boolean isPersistent;

        private final Object value;

        private Entry(Object value) {
            this(value, Long.MAX_VALUE, false);
        }

        private Entry(Object value, Entry entry) {
            this(value, entry.expiration, entry.isPersistent);
        }

        private Entry(Object value, long expiration, boolean isPersistent) {
            this.value = value;
            this.expiration = expiration;
            this.isPersistent = isPersistent;
        }
    }
}
