package com.umeng.a.a.a.b;

public final class f {
    public final String a;
    public final byte b;
    public final int c;

    public f() {
        this("", (byte) 0, 0);
    }

    public f(String paramString, byte paramByte, int paramInt) {
        this.a = paramString;
        this.b = paramByte;
        this.c = paramInt;
    }

    public boolean a(f paramf) {
        return (this.a.equals(paramf.a)) && (this.b == paramf.b) && (this.c == paramf.c);
    }

    public boolean equals(Object paramObject) {
        if ((paramObject instanceof f)) {
            return a((f) paramObject);
        }
        return false;
    }

    public String toString() {
        return "<TMessage name:'" + this.a + "' type: " + this.b + " seqid:" + this.c + ">";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/a/a/a/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */