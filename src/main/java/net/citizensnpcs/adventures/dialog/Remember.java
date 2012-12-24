package net.citizensnpcs.adventures.dialog;

import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;

public class Remember implements QueryRunnable {
    MemoryEntry[] entries;

    private Remember(Collection<MemoryEntry> collection) {
        this.entries = collection.toArray(new MemoryEntry[collection.size()]);
    }

    @Override
    public void run(QueryContext context) {
        for (MemoryEntry entry : entries) {
            if (entry.expiration > 0)
                context.getQuery().remember(entry.key, entry.value, entry.expiration);
            else
                context.getQuery().remember(entry.key, entry.value);
        }
    }

    public static class Builder {
        private final List<MemoryEntry> entries = Lists.newArrayList();

        public Remember build() {
            return new Remember(entries);
        }

        public Builder remember(String key, Object value) {
            entries.add(new MemoryEntry(key, value, 0));
            return this;
        }

        public Builder remember(String key, Object value, long expiration) {
            entries.add(new MemoryEntry(key, value, expiration));
            return this;
        }
    }

    private static class MemoryEntry {
        long expiration;

        String key;
        Object value;

        private MemoryEntry(String key, Object value, long expiration) {
            this.key = key;
            this.value = value;
            this.expiration = expiration;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
