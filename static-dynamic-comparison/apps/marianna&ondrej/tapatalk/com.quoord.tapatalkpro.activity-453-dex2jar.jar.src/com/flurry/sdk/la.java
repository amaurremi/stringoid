package com.flurry.sdk;

import java.lang.reflect.Member;
import java.util.HashMap;

public class la {
    final mw a;
    final boolean b;
    protected mo c;
    protected mu d;
    protected mu e;
    protected mu f;
    protected mu g;
    protected mu h;
    protected mu i;
    protected mu j;
    protected lb[] k = null;

    public la(mw parammw, boolean paramBoolean) {
        this.a = parammw;
        this.b = paramBoolean;
    }

    public kx a(iy paramiy) {
        md localmd = new md(paramiy, this.a.a());
        if (this.i == null) {
        }
        for (paramiy = null; ; paramiy = this.a.j().a(this.i.b(0))) {
            localmd.a(this.c, this.i, paramiy, this.j, this.k);
            localmd.a(this.d);
            localmd.b(this.e);
            localmd.c(this.f);
            localmd.d(this.g);
            localmd.e(this.h);
            return localmd;
        }
    }

    protected mu a(mu parammu1, mu parammu2, String paramString) {
        if ((parammu2 != null) && (parammu2.getClass() == parammu1.getClass())) {
            throw new IllegalArgumentException("Conflicting " + paramString + " creators: already had " + parammu2 + ", encountered " + parammu1);
        }
        if (this.b) {
            qy.a((Member) parammu1.a());
        }
        return parammu1;
    }

    public void a(mo parammo) {
        this.c = parammo;
    }

    public void a(mu parammu) {
        this.d = a(parammu, this.d, "String");
    }

    public void a(mu parammu, lb[] paramArrayOflb) {
        this.j = a(parammu, this.j, "property-based");
        if (paramArrayOflb.length > 1) {
            parammu = new HashMap();
            int n = paramArrayOflb.length;
            int m = 0;
            while (m < n) {
                String str = paramArrayOflb[m].c();
                Integer localInteger = (Integer) parammu.put(str, Integer.valueOf(m));
                if (localInteger != null) {
                    throw new IllegalArgumentException("Duplicate creator property \"" + str + "\" (index " + localInteger + " vs " + m + ")");
                }
                m += 1;
            }
        }
        this.k = paramArrayOflb;
    }

    public void b(mu parammu) {
        this.e = a(parammu, this.e, "int");
    }

    public void c(mu parammu) {
        this.f = a(parammu, this.f, "long");
    }

    public void d(mu parammu) {
        this.g = a(parammu, this.g, "double");
    }

    public void e(mu parammu) {
        this.h = a(parammu, this.h, "boolean");
    }

    public void f(mu parammu) {
        this.i = a(parammu, this.i, "delegate");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/la.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */