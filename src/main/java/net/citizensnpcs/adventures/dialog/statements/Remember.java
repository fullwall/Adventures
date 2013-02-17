package net.citizensnpcs.adventures.dialog.statements;

import java.util.Collection;
import java.util.List;

import net.citizensnpcs.adventures.dialog.ExpirationTime;
import net.citizensnpcs.adventures.dialog.QueryContext;
import net.citizensnpcs.adventures.dialog.QueryRunnable;
import net.citizensnpcs.adventures.dialog.evaluators.Evaluator;

import com.google.common.collect.Lists;

public class Remember implements QueryRunnable {
    MemoryEntry[] entries;

    private Remember(Collection<MemoryEntry> collection) {
        this.entries = collection.toArray(new MemoryEntry[collection.size()]);
    }

    @Override
    public void run(QueryContext context) {
        for (MemoryEntry entry : entries) {
            context.getQuery().remember((String) entry.key.get(), entry.value, entry.expiration);
        }
    }

    public static class Builder {
        private final List<MemoryEntry> entries = Lists.newArrayList();

        public Remember build() {
            return new Remember(entries);
        }

        public Builder remember(Evaluator key, Object value, ExpirationTime time) {
            entries.add(new MemoryEntry(key, value, time));
            return this;
        }
    }

    private static class MemoryEntry {
        private final ExpirationTime expiration;
        private final Evaluator key;
        private final Object value;

        private MemoryEntry(Evaluator key, Object value, ExpirationTime time) {
            this.key = key;
            this.value = value;
            this.expiration = time;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
