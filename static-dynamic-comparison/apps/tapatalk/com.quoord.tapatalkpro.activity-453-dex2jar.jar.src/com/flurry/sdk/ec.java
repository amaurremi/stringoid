package com.flurry.sdk;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class ec {
    private static ec a;
    private final Thread.UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();
    private final Map<Thread.UncaughtExceptionHandler, Void> c = new WeakHashMap();

    private ec() {
        Thread.setDefaultUncaughtExceptionHandler(new a(null));
    }

    public static ec a() {
        try {
            if (a == null) {
                a = new ec();
            }
            ec localec = a;
            return localec;
        } finally {
        }
    }

    private void a(Thread paramThread, Throwable paramThrowable) {
        Iterator localIterator = b().iterator();
        while (localIterator.hasNext()) {
            Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) localIterator.next();
            try {
                localUncaughtExceptionHandler.uncaughtException(paramThread, paramThrowable);
            } catch (Throwable localThrowable) {
            }
        }
    }

    private Set<Thread.UncaughtExceptionHandler> b() {
        synchronized (this.c) {
            Set localSet = this.c.keySet();
            return localSet;
        }
    }

    private void b(Thread paramThread, Throwable paramThrowable) {
        if (this.b != null) {
            this.b.uncaughtException(paramThread, paramThrowable);
        }
    }

    public void a(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler) {
        synchronized (this.c) {
            this.c.put(paramUncaughtExceptionHandler, null);
            return;
        }
    }

    final class a
            implements Thread.UncaughtExceptionHandler {
        private a() {
        }

        public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
            ec.a(ec.this, paramThread, paramThrowable);
            ec.b(ec.this, paramThread, paramThrowable);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */