package com.google.android.gms.internal;

import java.io.IOException;

class q
        implements o {
    private ko kk;
    private byte[] kl;
    private final int km;

    public q(int paramInt) {
        this.km = paramInt;
        reset();
    }

    public void b(int paramInt, long paramLong)
            throws IOException {
        this.kk.b(paramInt, paramLong);
    }

    public void b(int paramInt, String paramString)
            throws IOException {
        this.kk.b(paramInt, paramString);
    }

    public void reset() {
        this.kl = new byte[this.km];
        this.kk = ko.o(this.kl);
    }

    public byte[] z()
            throws IOException {
        int i = this.kk.mv();
        if (i < 0) {
            throw new IOException();
        }
        if (i == 0) {
            return this.kl;
        }
        byte[] arrayOfByte = new byte[this.kl.length - i];
        System.arraycopy(this.kl, 0, arrayOfByte, 0, arrayOfByte.length);
        return arrayOfByte;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */