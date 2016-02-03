package com.google.android.gms.internal;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@ii
public class mc<T>
        implements Future<T> {
    private final T a;

    public mc(T paramT) {
        this.a = paramT;
    }

    public boolean cancel(boolean paramBoolean) {
        return false;
    }

    public T get() {
        return (T) this.a;
    }

    public T get(long paramLong, TimeUnit paramTimeUnit) {
        return (T) this.a;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/mc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */