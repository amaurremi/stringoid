package com.flurry.sdk;

import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ef<V>
        extends FutureTask<V> {
    private final WeakReference<Callable<V>> a = null;
    private final WeakReference<Runnable> b;

    public ef(Runnable paramRunnable, V paramV) {
        super(paramRunnable, paramV);
        this.b = new WeakReference(paramRunnable);
    }

    public Runnable a() {
        return (Runnable) this.b.get();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/flurry/sdk/ef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */