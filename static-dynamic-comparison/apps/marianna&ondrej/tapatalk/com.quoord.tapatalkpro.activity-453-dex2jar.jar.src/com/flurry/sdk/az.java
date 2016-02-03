package com.flurry.sdk;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class az
        extends FilterInputStream {
    private final long a;
    private long b;

    public az(InputStream paramInputStream, long paramLong) {
        super(paramInputStream);
        this.a = paramLong;
    }

    private int a(int paramInt)
            throws IOException {
        this.b += paramInt;
        if (this.b > this.a) {
            throw new IOException("Size limit exceeded: " + this.a + " bytes, read " + this.b + " bytes!");
        }
        return paramInt;
    }

    public void close() {
        this.in = null;
    }

    public int read()
            throws IOException {
        return a(super.read());
    }

    public int read(byte[] paramArrayOfByte)
            throws IOException {
        return a(super.read(paramArrayOfByte));
    }

    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws IOException {
        return a(super.read(paramArrayOfByte, paramInt1, paramInt2));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */