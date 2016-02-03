package com.flurry.sdk;

import java.io.UnsupportedEncodingException;

public class gy
        implements CharSequence, Comparable<gy> {
    private static final byte[] a = new byte[0];
    private byte[] b = a;
    private int c;
    private String d;

    public gy() {
    }

    public gy(gy paramgy) {
        this.c = paramgy.c;
        this.b = new byte[paramgy.c];
        System.arraycopy(paramgy.b, 0, this.b, 0, this.c);
        this.d = paramgy.d;
    }

    public gy(String paramString) {
        this.b = a(paramString);
        this.c = this.b.length;
        this.d = paramString;
    }

    public static final byte[] a(String paramString) {
        try {
            paramString = paramString.getBytes("UTF-8");
            return paramString;
        } catch (UnsupportedEncodingException paramString) {
            paramString.printStackTrace();
        }
        return new byte[0];
    }

    public int a(gy paramgy) {
        return ga.a(this.b, 0, this.c, paramgy.b, 0, paramgy.c);
    }

    public gy a(int paramInt) {
        if (this.c < paramInt) {
            byte[] arrayOfByte = new byte[paramInt];
            System.arraycopy(this.b, 0, arrayOfByte, 0, this.c);
            this.b = arrayOfByte;
        }
        this.c = paramInt;
        this.d = null;
        return this;
    }

    public byte[] a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public char charAt(int paramInt) {
        return toString().charAt(paramInt);
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1;
        if (paramObject == this) {
            bool1 = true;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (!(paramObject instanceof gy));
            paramObject = (gy) paramObject;
            bool1 = bool2;
        } while (this.c != ((gy) paramObject).c);
        paramObject = ((gy) paramObject).b;
        int i = 0;
        for (; ; ) {
            if (i >= this.c) {
                break label78;
            }
            bool1 = bool2;
            if (this.b[i] != paramObject[i]) {
                break;
            }
            i += 1;
        }
        label78:
        return true;
    }

    public int hashCode() {
        int i = 0;
        int j = 0;
        while (i < this.c) {
            j = j * 31 + this.b[i];
            i += 1;
        }
        return j;
    }

    public int length() {
        return toString().length();
    }

    public CharSequence subSequence(int paramInt1, int paramInt2) {
        return toString().subSequence(paramInt1, paramInt2);
    }

    public String toString() {
        if (this.d == null) {
        }
        try {
            this.d = new String(this.b, 0, this.c, "UTF-8");
            return this.d;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            for (; ; ) {
                localUnsupportedEncodingException.printStackTrace();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/gy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */