package net.citizensnpcs.adventures.dialog;

import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;

public class Response {
    private final QueryRunnable[] statements;

    private Response(Collection<QueryRunnable> statements) {
        this.statements = statements.toArray(new QueryRunnable[statements.size()]);
    }

    public void run(QueryContext context, QueryRunnable callback) {
        for (QueryRunnable statement : statements) {
            statement.run(context);
        }
        if (callback != null)
            callback.run(context);
    }

    public static class Builder {
        public Response build() {
            return new Response(statements);
        }

        private final List<QueryRunnable> statements = Lists.newArrayList();

        public Builder statement(QueryRunnable statement) {
            statements.add(statement);
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
