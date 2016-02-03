package com.umeng.a.a.a.b;

public class c {
    public final String a;
    public final byte b;
    public final short c;

    public c() {
        this("", (byte) 0, (short) 0);
    }

    public c(String paramString, byte paramByte, short paramShort) {
        this.a = paramString;
        this.b = paramByte;
        this.c = paramShort;
    }

    public boolean a(c paramc) {
        return (this.b == paramc.b) && (this.c == paramc.c);
    }

    public String toString() {
        return "<TField name:'" + this.a + "' type:" + this.b + " field-id:" + this.c + ">";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/a/a/a/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */