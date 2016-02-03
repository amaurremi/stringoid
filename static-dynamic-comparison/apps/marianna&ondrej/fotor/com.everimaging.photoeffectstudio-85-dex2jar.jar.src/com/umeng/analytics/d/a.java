package com.umeng.analytics.d;

import com.umeng.a.a.a.h;

public enum a
        implements h {
    private final int e;

    private a(int paramInt) {
        this.e = paramInt;
    }

    public static a a(int paramInt) {
        switch (paramInt) {
            default:
                return null;
            case 0:
                return a;
            case 1:
                return b;
            case 2:
                return c;
        }
        return d;
    }

    public int a() {
        return this.e;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */