package com.google.android.gms.common.internal;

import android.os.Looper;
import android.util.Log;

public final class b {
    public static void a(Object paramObject) {
        if (paramObject == null) {
            throw new IllegalArgumentException("null reference");
        }
    }

    public static void a(String paramString) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            Log.e("Asserts", "checkMainThread: current thread " + Thread.currentThread() + " IS NOT the main thread " + Looper.getMainLooper().getThread() + "!");
            throw new IllegalStateException(paramString);
        }
    }

    public static void a(boolean paramBoolean) {
        if (!paramBoolean) {
            throw new IllegalStateException();
        }
    }

    public static void a(boolean paramBoolean, Object paramObject) {
        if (!paramBoolean) {
            throw new IllegalStateException(String.valueOf(paramObject));
        }
    }

    public static void b(String paramString) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            Log.e("Asserts", "checkNotMainThread: current thread " + Thread.currentThread() + " IS the main thread " + Looper.getMainLooper().getThread() + "!");
            throw new IllegalStateException(paramString);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */