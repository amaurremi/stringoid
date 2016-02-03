package com.umeng.a.a.a;

import com.umeng.a.a.a.b.h;
import com.umeng.a.a.a.b.k;
import com.umeng.a.a.a.b.m;

public class c
        extends j {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    private static final m j = new m("TApplicationException");
    private static final com.umeng.a.a.a.b.c k = new com.umeng.a.a.a.b.c("message", (byte) 11, (short) 1);
    private static final com.umeng.a.a.a.b.c l = new com.umeng.a.a.a.b.c("type", (byte) 8, (short) 2);
    private static final long m = 1L;
    protected int i = 0;

    public c() {
    }

    public c(int paramInt) {
        this.i = paramInt;
    }

    public c(int paramInt, String paramString) {
        super(paramString);
        this.i = paramInt;
    }

    public c(String paramString) {
        super(paramString);
    }

    public static c a(h paramh)
            throws j {
        paramh.j();
        String str = null;
        int n = 0;
        com.umeng.a.a.a.b.c localc = paramh.l();
        if (localc.b == 0) {
            paramh.k();
            return new c(n, str);
        }
        switch (localc.c) {
            default:
                k.a(paramh, localc.b);
        }
        for (; ; ) {
            paramh.m();
            break;
            if (localc.b == 11) {
                str = paramh.z();
            } else {
                k.a(paramh, localc.b);
                continue;
                if (localc.b == 8) {
                    n = paramh.w();
                } else {
                    k.a(paramh, localc.b);
                }
            }
        }
    }

    public int a() {
        return this.i;
    }

    public void b(h paramh)
            throws j {
        paramh.a(j);
        if (getMessage() != null) {
            paramh.a(k);
            paramh.a(getMessage());
            paramh.c();
        }
        paramh.a(l);
        paramh.a(this.i);
        paramh.c();
        paramh.d();
        paramh.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/a/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */