package com.google.android.gms.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class lv
        implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);

    public Thread newThread(Runnable paramRunnable) {
        return new Thread(paramRunnable, "AdWorker #" + this.a.getAndIncrement());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/lv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */