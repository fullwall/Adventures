package net.citizensnpcs.adventures.dialog;

import java.util.Collection;
import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

public class Response {
    private final String name;
    private final QueryRunnable[] statements;

    private Response(String name, Collection<QueryRunnable> statements) {
        this.name = name;
        this.statements = statements.toArray(new QueryRunnable[statements.size()]);
    }

    public String getName() {
        return name;
    }

    public void run(QueryContext context, QueryRunnable callback) {
        for (QueryRunnable statement : statements) {
            statement.run(context);
        }
        if (callback != null)
            callback.run(context);
    }

    public static class Builder {
        private String name;
        private final List<QueryRunnable> statements = Lists.newArrayList();

        public Response build() {
            Preconditions.checkNotNull(name);
            return new Response(name, statements);
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder statement(QueryRunnable statement) {
            statements.add(statement);
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
