package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

class ft
        implements Runnable {
    private final WeakReference<fr> c = new WeakReference(this.a);

    ft(fs paramfs, fr paramfr) {
    }

    public void run() {
        fr localfr = (fr) this.c.get();
        if ((!fs.a(this.b)) && (localfr != null)) {
            localfr.e();
            this.b.b();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */