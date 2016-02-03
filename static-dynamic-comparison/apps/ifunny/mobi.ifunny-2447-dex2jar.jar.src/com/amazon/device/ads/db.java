package com.amazon.device.ads;

class db {
    private boolean a = true;
    private String b;
    private boolean c;

    static db a() {
        return new db().b(false);
    }

    private db b(boolean paramBoolean) {
        this.a = paramBoolean;
        return this;
    }

    db a(String paramString) {
        this.b = paramString;
        return this;
    }

    db a(boolean paramBoolean) {
        this.c = paramBoolean;
        return this;
    }

    boolean b() {
        return this.a;
    }

    String c() {
        return this.b;
    }

    boolean d() {
        return c() != null;
    }

    boolean e() {
        return this.c;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */