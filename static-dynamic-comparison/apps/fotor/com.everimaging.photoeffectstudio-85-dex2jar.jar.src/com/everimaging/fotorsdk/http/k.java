package com.everimaging.fotorsdk.http;

import java.lang.ref.WeakReference;

public class k {
    private final WeakReference<b> a;

    public k(b paramb) {
        this.a = new WeakReference(paramb);
    }

    public boolean a() {
        b localb = (b) this.a.get();
        return (localb == null) || (localb.b());
    }

    public boolean a(boolean paramBoolean) {
        b localb = (b) this.a.get();
        return (localb == null) || (localb.a(paramBoolean));
    }

    public boolean b() {
        b localb = (b) this.a.get();
        return (localb == null) || (localb.a());
    }

    public boolean c() {
        if ((b()) || (a())) {
        }
        for (boolean bool = true; ; bool = false) {
            if (bool) {
                this.a.clear();
            }
            return bool;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/http/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */