package net.citizensnpcs.adventures.dialog;

public class CallEventCallback implements QueryRunnable {
    private final String event;
    private final String target;

    public CallEventCallback(String target, String event) {
        this.target = target;
        this.event = event;
    }

    @Override
    public void run(QueryContext context) {
        context.runRedirectQuery(target, event);
    }
}
