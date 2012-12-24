package net.citizensnpcs.adventures.dialog;

public interface QueryContext {
    boolean callResponse(String responseIdentifier);

    boolean callResponse(String responseIdentifier, QueryRunnable callback);

    Query getQuery();

    void runRedirectQuery(String target, String event);
}
