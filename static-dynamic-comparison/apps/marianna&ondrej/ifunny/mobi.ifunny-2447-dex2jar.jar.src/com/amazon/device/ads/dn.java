package com.amazon.device.ads;

import android.content.Context;

import java.io.File;

class dn
        implements dl {
    public static final String a = dn.class.getSimpleName();
    private static dl m = new dn();
    protected Context b;
    private cm c;
    private cz d;
    private gs e;
    private gw f;
    private boolean g;
    private boolean h;
    private int i;
    private long j;
    private boolean k = false;
    private File l;

    protected dn() {
        cx.a();
        hv.b();
        this.e = new gs();
    }

    public static dl i() {
        return m;
    }

    public cm a() {
        return this.c;
    }

    public void a(int paramInt) {
        int i1 = cq.b();
        int n = paramInt;
        if (i1 < paramInt) {
            n = i1;
        }
        if (n == 0) {
            this.i = 0;
            this.j = 0L;
            return;
        }
        this.i = (n * 1000);
        this.j = (System.currentTimeMillis() + this.i);
    }

    public void a(Context paramContext) {
        try {
            if (!this.g) {
                this.g = true;
                e(paramContext);
                b(paramContext);
                he.a().a(paramContext);
                c(paramContext);
                d(paramContext);
                j();
            }
            return;
        } finally {
            paramContext =finally;
            throw paramContext;
        }
    }

    public void a(boolean paramBoolean) {
        this.k = paramBoolean;
    }

    public cz b() {
        return this.d;
    }

    protected void b(Context paramContext) {
        this.l = paramContext.getFilesDir();
    }

    public gs c() {
        return this.e;
    }

    protected void c(Context paramContext) {
        this.c = new cm(paramContext);
    }

    public int d() {
        if ((this.i == 0) || (this.j == 0L)) {
            return 0;
        }
        long l1 = System.currentTimeMillis();
        if (l1 >= this.j) {
            this.i = 0;
            this.j = 0L;
            return 0;
        }
        return (int) (this.j - l1);
    }

    protected void d(Context paramContext) {
        this.d = new cz(paramContext);
    }

    protected void e(Context paramContext) {
        this.b = paramContext.getApplicationContext();
    }

    public boolean e() {
        return this.k;
    }

    public void f() {
        k().c();
        this.h = true;
    }

    public File g() {
        return this.l;
    }

    public Context h() {
        return this.b;
    }

    protected void j() {
        this.f = new gw();
    }

    protected gw k() {
        return this.f;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */