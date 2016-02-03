package com.umeng.analytics.social;

public class a
        extends RuntimeException {
    private static final long b = -4656673116019167471L;
    protected int a = 5000;
    private String c = "";

    public a(int paramInt, String paramString) {
        super(paramString);
        this.a = paramInt;
        this.c = paramString;
    }

    public a(String paramString) {
        super(paramString);
        this.c = paramString;
    }

    public a(String paramString, Throwable paramThrowable) {
        super(paramString, paramThrowable);
        this.c = paramString;
    }

    public int a() {
        return this.a;
    }

    public String getMessage() {
        return this.c;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/social/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */