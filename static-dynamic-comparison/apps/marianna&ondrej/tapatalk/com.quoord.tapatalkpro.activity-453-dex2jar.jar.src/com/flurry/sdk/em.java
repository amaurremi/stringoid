package com.flurry.sdk;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class em
        extends eg<en> {
    private static em a = null;

    protected em() {
        super(em.class.getName(), 0, 5, 5000L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(11, new ee()));
    }

    public static em a() {
        try {
            if (a == null) {
                a = new em();
            }
            em localem = a;
            return localem;
        } finally {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/em.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */