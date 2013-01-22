package net.citizensnpcs.adventures.dialog;

import java.util.concurrent.TimeUnit;

public class ExpirationTime {
    private final boolean persistent;
    private final long expirationTime;

    private ExpirationTime(long expirationTime, TimeUnit unit, boolean isPersistent) {
        this.expirationTime = unit == null ? expirationTime : System.nanoTime()
                + TimeUnit.NANOSECONDS.convert(expirationTime, unit);
        this.persistent = isPersistent;
    }

    public boolean isPersistent() {
        return persistent;
    }

    public boolean hasExpired() {
        return System.nanoTime() >= expirationTime;
    }

    public static ExpirationTime expiringAt(long expirationTime, TimeUnit unit, boolean isPersistent) {
        return new ExpirationTime(expirationTime, unit, isPersistent);
    }

    public static ExpirationTime infinite(boolean isPersistent) {
        return expiringAt(Long.MAX_VALUE, TimeUnit.DAYS, isPersistent);
    }
}
