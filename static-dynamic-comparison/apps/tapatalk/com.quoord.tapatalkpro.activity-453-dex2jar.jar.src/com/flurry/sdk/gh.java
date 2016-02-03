package com.flurry.sdk;

import java.io.IOException;
import java.io.OutputStream;

public class gh
        extends gc {
    private OutputStream a;
    private final byte[] b = new byte[12];

    gh(OutputStream paramOutputStream) {
        a(paramOutputStream);
    }

    gh a(OutputStream paramOutputStream) {
        if (paramOutputStream == null) {
            throw new NullPointerException("OutputStream cannot be null!");
        }
        this.a = paramOutputStream;
        return this;
    }

    public void a(double paramDouble)
            throws IOException {
        byte[] arrayOfByte = new byte[8];
        int i = ga.a(paramDouble, arrayOfByte, 0);
        this.a.write(arrayOfByte, 0, i);
    }

    public void a(float paramFloat)
            throws IOException {
        int i = ga.a(paramFloat, this.b, 0);
        this.a.write(this.b, 0, i);
    }

    public void a(boolean paramBoolean)
            throws IOException {
        OutputStream localOutputStream = this.a;
        if (paramBoolean) {
        }
        for (int i = 1; ; i = 0) {
            localOutputStream.write(i);
            return;
        }
    }

    public void b(long paramLong)
            throws IOException {
        long l = paramLong << 1 ^ paramLong >> 63;
        if ((0xFFFFFFFF80000000 & l) == 0L) {
            i = (int) l;
            while ((i & 0xFFFFFF80) != 0) {
                this.a.write((byte) ((i | 0x80) & 0xFF));
                i >>>= 7;
            }
            this.a.write((byte) i);
            return;
        }
        int i = ga.a(paramLong, this.b, 0);
        this.a.write(this.b, 0, i);
    }

    public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws IOException {
        this.a.write(paramArrayOfByte, paramInt1, paramInt2);
    }

    public void c(int paramInt)
            throws IOException {
        int i = paramInt << 1 ^ paramInt >> 31;
        if ((i & 0xFFFFFF80) == 0) {
            this.a.write(i);
            return;
        }
        if ((i & 0xC000) == 0) {
            this.a.write(i | 0x80);
            this.a.write(i >>> 7);
            return;
        }
        paramInt = ga.a(paramInt, this.b, 0);
        this.a.write(this.b, 0, paramInt);
    }

    public void flush()
            throws IOException {
        this.a.flush();
    }

    protected void g()
            throws IOException {
        this.a.write(0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/gh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */