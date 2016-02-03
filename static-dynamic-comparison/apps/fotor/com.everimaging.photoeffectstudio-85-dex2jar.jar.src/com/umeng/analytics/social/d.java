package com.umeng.analytics.social;

public class d {
    private int a = -1;
    private String b = "";
    private String c = "";
    private Exception d = null;

    public d(int paramInt) {
        this.a = paramInt;
    }

    public d(int paramInt, Exception paramException) {
        this.a = paramInt;
        this.d = paramException;
    }

    public Exception a() {
        return this.d;
    }

    public void a(int paramInt) {
        this.a = paramInt;
    }

    public void a(String paramString) {
        this.b = paramString;
    }

    public int b() {
        return this.a;
    }

    public void b(String paramString) {
        this.c = paramString;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public String toString() {
        return "status=" + this.a + "\r\n" + "msg:  " + this.b + "\r\n" + "data:  " + this.c;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/social/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */