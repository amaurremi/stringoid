package com.flurry.sdk;

public enum ay {
    private final int e;

    private ay(int paramInt) {
        this.e = paramInt;
    }

    public static ay a(int paramInt) {
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */