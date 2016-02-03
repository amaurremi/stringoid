package com.flurry.sdk;

public class im
        implements hp {
    protected final String a;
    protected byte[] b;
    protected byte[] c;
    protected char[] d;

    public im(String paramString) {
        this.a = paramString;
    }

    public final String a() {
        return this.a;
    }

    public final char[] b() {
        char[] arrayOfChar2 = this.d;
        char[] arrayOfChar1 = arrayOfChar2;
        if (arrayOfChar2 == null) {
            arrayOfChar1 = ig.a().a(this.a);
            this.d = arrayOfChar1;
        }
        return arrayOfChar1;
    }

    public final byte[] c() {
        byte[] arrayOfByte2 = this.c;
        byte[] arrayOfByte1 = arrayOfByte2;
        if (arrayOfByte2 == null) {
            arrayOfByte1 = ig.a().c(this.a);
            this.c = arrayOfByte1;
        }
        return arrayOfByte1;
    }

    public final byte[] d() {
        byte[] arrayOfByte2 = this.b;
        byte[] arrayOfByte1 = arrayOfByte2;
        if (arrayOfByte2 == null) {
            arrayOfByte1 = ig.a().b(this.a);
            this.b = arrayOfByte1;
        }
        return arrayOfByte1;
    }

    public final boolean equals(Object paramObject) {
        if (paramObject == this) {
            return true;
        }
        if ((paramObject == null) || (paramObject.getClass() != getClass())) {
            return false;
        }
        paramObject = (im) paramObject;
        return this.a.equals(((im) paramObject).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/im.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */