package com.everimaging.fotorsdk.uil.core.assist;

import java.io.IOException;
import java.io.InputStream;

public class a
        extends InputStream {
    private final InputStream a;
    private final long b;
    private long c;

    public a(InputStream paramInputStream, long paramLong) {
        this.a = paramInputStream;
        this.b = paramLong;
    }

    public int available() {
        try {
            long l1 = this.b;
            long l2 = this.c;
            int i = (int) (l1 - l2);
            return i;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void close()
            throws IOException {
        this.a.close();
    }

    public void mark(int paramInt) {
        this.c = paramInt;
        this.a.mark(paramInt);
    }

    public int read()
            throws IOException {
        this.c += 1L;
        return this.a.read();
    }

    public int read(byte[] paramArrayOfByte)
            throws IOException {
        return read(paramArrayOfByte, 0, paramArrayOfByte.length);
    }

    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws IOException {
        this.c += paramInt2;
        return this.a.read(paramArrayOfByte, paramInt1, paramInt2);
    }

    public void reset()
            throws IOException {
        try {
            this.c = 0L;
            this.a.reset();
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public long skip(long paramLong)
            throws IOException {
        this.c += paramLong;
        return this.a.skip(paramLong);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/core/assist/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */