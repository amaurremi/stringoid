package com.flurry.sdk;

public enum ar {
    private final int h;

    private ar(int paramInt) {
        this.h = paramInt;
    }

    public static ar a(int paramInt) {
        switch (paramInt) {
            default:
                return null;
            case 0:
                return a;
            case 1:
                return b;
            case 2:
                return c;
            case 3:
                return d;
            case 4:
                return e;
            case 5:
                return f;
        }
        return g;
    }

    public int a() {
        return this.h;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */