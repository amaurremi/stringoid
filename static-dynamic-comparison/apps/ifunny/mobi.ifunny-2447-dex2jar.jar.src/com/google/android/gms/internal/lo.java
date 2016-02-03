package com.google.android.gms.internal;

@ii
public abstract class lo {
    private final Runnable a = new lp(this);
    private volatile Thread b;

    public abstract void a();

    public abstract void b();

    public final void e() {
        ls.a(this.a);
    }

    public final void f() {
        b();
        if (this.b != null) {
            this.b.interrupt();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/lo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */