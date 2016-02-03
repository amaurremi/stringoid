package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

class c
        implements Runnable {
    private final WeakReference<te> c = new WeakReference(this.a);

    c(b paramb, te paramte) {
    }

    public void run() {
        b.a(this.b, false);
        te localte = (te) this.c.get();
        if (localte != null) {
            localte.b(b.a(this.b));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */