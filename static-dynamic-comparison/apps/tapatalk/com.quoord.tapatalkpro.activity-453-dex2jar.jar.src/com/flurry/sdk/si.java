package com.flurry.sdk;

public class si {
    protected final byte[][] a = new byte[a.values().length][];
    protected final char[][] b = new char[b.values().length][];

    private final byte[] a(int paramInt) {
        return new byte[paramInt];
    }

    private final char[] b(int paramInt) {
        return new char[paramInt];
    }

    public final void a(a parama, byte[] paramArrayOfByte) {
        this.a[parama.ordinal()] = paramArrayOfByte;
    }

    public final void a(b paramb, char[] paramArrayOfChar) {
        this.b[paramb.ordinal()] = paramArrayOfChar;
    }

    public final byte[] a(a parama) {
        int i = parama.ordinal();
        byte[] arrayOfByte = this.a[i];
        if (arrayOfByte == null) {
            return a(a.a(parama));
        }
        this.a[i] = null;
        return arrayOfByte;
    }

    public final char[] a(b paramb) {
        return a(paramb, 0);
    }

    public final char[] a(b paramb, int paramInt) {
        int i = paramInt;
        if (b.a(paramb) > paramInt) {
            i = b.a(paramb);
        }
        paramInt = paramb.ordinal();
        paramb = this.b[paramInt];
        if ((paramb == null) || (paramb.length < i)) {
            return b(i);
        }
        this.b[paramInt] = null;
        return paramb;
    }

    public static enum a {
        private final int d;

        private a(int paramInt) {
            this.d = paramInt;
        }
    }

    public static enum b {
        private final int e;

        private b(int paramInt) {
            this.e = paramInt;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/si.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */