package com.google.android.gms.internal;

import android.os.Process;

import java.util.concurrent.Callable;

final class lu
        implements Callable<T> {
    lu(Callable paramCallable) {
    }

    public T call() {
        try {
            Process.setThreadPriority(10);
            Object localObject = this.a.call();
            return (T) localObject;
        } catch (Exception localException) {
            lj.a(localException);
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/lu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */