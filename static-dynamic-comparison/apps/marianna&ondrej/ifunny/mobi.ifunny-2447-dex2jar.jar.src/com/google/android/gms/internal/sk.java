package com.google.android.gms.internal;

import java.io.IOException;

class sk
        implements rk {
    private sm a;
    private byte[] b;
    private final int c;

    public sk(int paramInt) {
        this.c = paramInt;
        a();
    }

    public void a() {
        this.b = new byte[this.c];
        this.a = sm.a(this.b);
    }

    public void a(int paramInt, long paramLong) {
        this.a.a(paramInt, paramLong);
    }

    public void a(int paramInt, String paramString) {
        this.a.a(paramInt, paramString);
    }

    public byte[] b() {
        int i = this.a.a();
        if (i < 0) {
            throw new IOException();
        }
        if (i == 0) {
            return this.b;
        }
        byte[] arrayOfByte = new byte[this.b.length - i];
        System.arraycopy(this.b, 0, arrayOfByte, 0, arrayOfByte.length);
        return arrayOfByte;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/sk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */