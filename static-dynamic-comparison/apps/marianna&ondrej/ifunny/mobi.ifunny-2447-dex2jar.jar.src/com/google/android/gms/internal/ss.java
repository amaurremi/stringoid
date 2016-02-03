package com.google.android.gms.internal;

import java.io.IOException;

public abstract class ss {
    protected volatile int f = -1;

    public static final void a(ss paramss, byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        try {
            paramArrayOfByte = sm.a(paramArrayOfByte, paramInt1, paramInt2);
            paramss.a(paramArrayOfByte);
            paramArrayOfByte.b();
            return;
        } catch (IOException paramss) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramss);
        }
    }

    public static final byte[] a(ss paramss) {
        byte[] arrayOfByte = new byte[paramss.e()];
        a(paramss, arrayOfByte, 0, arrayOfByte.length);
        return arrayOfByte;
    }

    public void a(sm paramsm) {
    }

    protected int b() {
        return 0;
    }

    public int d() {
        if (this.f < 0) {
            e();
        }
        return this.f;
    }

    public int e() {
        int i = b();
        this.f = i;
        return i;
    }

    public String toString() {
        return st.a(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */