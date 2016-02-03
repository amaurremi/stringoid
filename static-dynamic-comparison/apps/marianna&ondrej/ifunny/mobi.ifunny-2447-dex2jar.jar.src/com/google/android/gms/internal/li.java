package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;

@ii
final class li {
    private long a = -1L;
    private long b = -1L;

    public long a() {
        return this.b;
    }

    public void b() {
        this.b = SystemClock.elapsedRealtime();
    }

    public void c() {
        this.a = SystemClock.elapsedRealtime();
    }

    public Bundle d() {
        Bundle localBundle = new Bundle();
        localBundle.putLong("topen", this.a);
        localBundle.putLong("tclose", this.b);
        return localBundle;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/li.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */