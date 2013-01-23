package net.citizensnpcs.adventures.dialog;

import java.util.concurrent.TimeUnit;

public class ExpirationTime {
    private final long expirationTime;
    private final boolean persistent;

    private ExpirationTime(long expirationTime, boolean isPersistent) {
        this.expirationTime = expirationTime;
        this.persistent = isPersistent;
    }

    public long getExpirationTimeFromNow() {
        return System.nanoTime() + expirationTime;
    }

    public boolean isPersistent() {
        return persistent;
    }

    public static ExpirationTime expiringAt(long expirationTime, TimeUnit unit, boolean isPersistent) {
        return new ExpirationTime(TimeUnit.NANOSECONDS.convert(expirationTime, unit), isPersistent);
    }

    public static ExpirationTime infinite(boolean isPersistent) {
        return expiringAt(Long.MAX_VALUE, TimeUnit.DAYS, isPersistent);
    }
}
