package com.google.android.gms.internal;

import android.os.Handler;

final class fs {
    private final Runnable a;
    private volatile boolean b = false;

    public fs(fr paramfr) {
        this.a = new ft(this, paramfr);
    }

    public void a() {
        this.b = true;
        mv.a.removeCallbacks(this.a);
    }

    public void b() {
        mv.a.postDelayed(this.a, 250L);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/fs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */