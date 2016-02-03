package com.google.android.gms.internal;

@ii
public final class dl
        extends eb {
    private final Object a = new Object();
    private dq b;
    private dk c;

    public void a() {
        synchronized (this.a) {
            if (this.c != null) {
                this.c.m();
            }
            return;
        }
    }

    public void a(int paramInt) {
        for (; ; ) {
            synchronized (this.a) {
                if (this.b != null) {
                    if (paramInt == 3) {
                        paramInt = 1;
                        this.b.a(paramInt);
                        this.b = null;
                    }
                } else {
                    return;
                }
            }
            paramInt = 2;
        }
    }

    public void a(dk paramdk) {
        synchronized (this.a) {
            this.c = paramdk;
            return;
        }
    }

    public void a(dq paramdq) {
        synchronized (this.a) {
            this.b = paramdq;
            return;
        }
    }

    public void b() {
        synchronized (this.a) {
            if (this.c != null) {
                this.c.n();
            }
            return;
        }
    }

    public void c() {
        synchronized (this.a) {
            if (this.c != null) {
                this.c.o();
            }
            return;
        }
    }

    public void d() {
        synchronized (this.a) {
            if (this.c != null) {
                this.c.p();
            }
            return;
        }
    }

    public void e() {
        synchronized (this.a) {
            if (this.b != null) {
                this.b.a(0);
                this.b = null;
                return;
            }
            if (this.c != null) {
                this.c.q();
            }
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */