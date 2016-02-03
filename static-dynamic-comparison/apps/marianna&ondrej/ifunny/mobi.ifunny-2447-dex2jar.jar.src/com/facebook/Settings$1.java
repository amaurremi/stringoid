package com.facebook;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class Settings$1
        implements ThreadFactory {
    private final AtomicInteger counter = new AtomicInteger(0);

    public Thread newThread(Runnable paramRunnable) {
        return new Thread(paramRunnable, "FacebookSdk #" + this.counter.incrementAndGet());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Settings$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */