package net.citizensnpcs.adventures.dialog.statements;

import net.citizensnpcs.adventures.dialog.QueryContext;
import net.citizensnpcs.adventures.dialog.QueryRunnable;

public class CallResponse implements QueryRunnable {
    private final QueryRunnable callback;
    private final String target;

    private CallResponse(String target, QueryRunnable callback) {
        this.target = target;
        this.callback = callback;
    }

    @Override
    public void run(QueryContext query) {
        query.callResponse(target, callback);
    }

    public static class Builder {
        private QueryRunnable callback;
        private final String target;

        public Builder(String targetResponse) {
            this.target = targetResponse;
        }

        public CallResponse build() {
            return new CallResponse(target, callback);
        }

        public Builder callback(QueryRunnable callback) {
            this.callback = callback;
            return this;
        }
    }

    public static Builder builder(String targetResponse) {
        return new Builder(targetResponse);
    }
}
