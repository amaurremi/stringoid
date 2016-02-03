package com.google.android.gms.internal;

import android.os.SystemClock;

public final class pr
        implements pq {
    private static pr a;

    public static pq c() {
        try {
            if (a == null) {
                a = new pr();
            }
            pr localpr = a;
            return localpr;
        } finally {
        }
    }

    public long a() {
        return System.currentTimeMillis();
    }

    public long b() {
        return SystemClock.elapsedRealtime();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/pr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */