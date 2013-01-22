package net.citizensnpcs.adventures.dialog.statements;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import net.citizensnpcs.adventures.dialog.QueryContext;
import net.citizensnpcs.adventures.dialog.QueryRunnable;

import com.google.common.collect.Lists;

public class Remember implements QueryRunnable {
    MemoryEntry[] entries;

    private Remember(Collection<MemoryEntry> collection) {
        this.entries = collection.toArray(new MemoryEntry[collection.size()]);
    }

    @Override
    public void run(QueryContext context) {
        for (MemoryEntry entry : entries) {
            context.getQuery().remember(entry.key, entry.value, entry.expiration, entry.unit);
        }
    }

    public static class Builder {
        private final List<MemoryEntry> entries = Lists.newArrayList();

        public Remember build() {
            return new Remember(entries);
        }

        public Builder remember(String key, Object value) {
            return remember(key, value, Long.MAX_VALUE);
        }

        public Builder remember(String key, Object value, long expiration) {
            return remember(key, value, expiration, null);
        }

        public Builder remember(String key, Object value, long expiration, TimeUnit unit) {
            entries.add(new MemoryEntry(key, value, expiration, unit));
            return this;
        }
    }

    private static class MemoryEntry {
        private final long expiration;
        private final String key;
        private final Object value;
        private final TimeUnit unit;

        private MemoryEntry(String key, Object value, long expiration, TimeUnit unit) {
            this.key = key;
            this.value = value;
            this.expiration = expiration;
            this.unit = unit;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
