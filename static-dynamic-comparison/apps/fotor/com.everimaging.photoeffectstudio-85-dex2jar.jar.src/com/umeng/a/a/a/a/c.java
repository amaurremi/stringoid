package com.umeng.a.a.a.a;

import java.io.Serializable;

public class c
        implements Serializable {
    private final boolean a;
    public final byte b;
    private final String c;
    private final boolean d;

    public c(byte paramByte) {
        this(paramByte, false);
    }

    public c(byte paramByte, String paramString) {
        this.b = paramByte;
        this.a = true;
        this.c = paramString;
        this.d = false;
    }

    public c(byte paramByte, boolean paramBoolean) {
        this.b = paramByte;
        this.a = false;
        this.c = null;
        this.d = paramBoolean;
    }

    public boolean a() {
        return this.a;
    }

    public String b() {
        return this.c;
    }

    public boolean c() {
        return this.b == 12;
    }

    public boolean d() {
        return (this.b == 15) || (this.b == 13) || (this.b == 14);
    }

    public boolean e() {
        return this.d;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/a/a/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */