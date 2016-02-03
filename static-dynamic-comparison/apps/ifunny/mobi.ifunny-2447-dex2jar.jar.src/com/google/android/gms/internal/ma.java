package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@ii
public class ma<T>
        implements Future<T> {
    private final Object a = new Object();
    private T b = null;
    private boolean c = false;
    private boolean d = false;

    public void a(T paramT) {
        synchronized (this.a) {
            if (this.c) {
                throw new IllegalStateException("Provided CallbackFuture with multiple values.");
            }
        }
        this.c = true;
        this.b = paramT;
        this.a.notifyAll();
    }

    public boolean cancel(boolean paramBoolean) {
        if (!paramBoolean) {
            return false;
        }
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
        }
        this.d = true;
        this.c = true;
        this.a.notifyAll();
        return true;
    }

    public T get() {
        synchronized (this.a) {
            boolean bool = this.c;
            if (bool) {
            }
        }
        try {
            this.a.wait();
            if (this.d) {
                throw new CancellationException("CallbackFuture was cancelled.");
                localObject2 =finally;
                throw ((Throwable) localObject2);
            }
            Object localObject3 = this.b;
            return (T) localObject3;
        } catch (InterruptedException localInterruptedException) {
            for (; ; ) {
            }
        }
    }

    public T get(long paramLong, TimeUnit paramTimeUnit) {
        synchronized (this.a) {
            boolean bool = this.c;
            if (!bool) {
            }
            try {
                paramLong = paramTimeUnit.toMillis(paramLong);
                if (paramLong != 0L) {
                    this.a.wait(paramLong);
                }
            } catch (InterruptedException paramTimeUnit) {
                for (; ; ) {
                }
            }
            if (!this.c) {
                throw new TimeoutException("CallbackFuture timed out.");
            }
        }
        if (this.d) {
            throw new CancellationException("CallbackFuture was cancelled.");
        }
        paramTimeUnit = this.b;
        return paramTimeUnit;
    }

    public boolean isCancelled() {
        synchronized (this.a) {
            boolean bool = this.d;
            return bool;
        }
    }

    public boolean isDone() {
        synchronized (this.a) {
            boolean bool = this.c;
            return bool;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ma.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */