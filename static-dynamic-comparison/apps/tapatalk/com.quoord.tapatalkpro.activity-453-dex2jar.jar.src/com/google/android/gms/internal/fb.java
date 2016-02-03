package com.google.android.gms.internal;

import android.os.Looper;
import android.util.Log;

public final class fb {
    public static void a(boolean paramBoolean, Object paramObject) {
        if (!paramBoolean) {
            throw new IllegalStateException(String.valueOf(paramObject));
        }
    }

    public static void aj(String paramString) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            Log.e("Asserts", "checkMainThread: current thread " + Thread.currentThread() + " IS NOT the main thread " + Looper.getMainLooper().getThread() + "!");
            throw new IllegalStateException(paramString);
        }
    }

    public static void ak(String paramString) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            Log.e("Asserts", "checkNotMainThread: current thread " + Thread.currentThread() + " IS the main thread " + Looper.getMainLooper().getThread() + "!");
            throw new IllegalStateException(paramString);
        }
    }

    public static void d(Object paramObject) {
        if (paramObject == null) {
            throw new IllegalArgumentException("null reference");
        }
    }

    public static void x(boolean paramBoolean) {
        if (!paramBoolean) {
            throw new IllegalStateException();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/fb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */