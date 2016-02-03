package com.flurry.sdk;

public enum cn {
    private String d;

    private cn(String paramString) {
        this.d = paramString;
    }

    public static cn a(String paramString) {
        if (b.a().equals(paramString)) {
            return b;
        }
        if (c.a().equals(paramString)) {
            return c;
        }
        return a;
    }

    public String a() {
        return this.d;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */