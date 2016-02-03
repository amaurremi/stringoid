package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;

public final class ih
        extends InputStream {
    protected final ie a;
    final InputStream b;
    byte[] c;
    int d;
    final int e;

    public ih(ie paramie, InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        this.a = paramie;
        this.b = paramInputStream;
        this.c = paramArrayOfByte;
        this.d = paramInt1;
        this.e = paramInt2;
    }

    private void a() {
        byte[] arrayOfByte = this.c;
        if (arrayOfByte != null) {
            this.c = null;
            if (this.a != null) {
                this.a.a(arrayOfByte);
            }
        }
    }

    public int available()
            throws IOException {
        if (this.c != null) {
            return this.e - this.d;
        }
        return this.b.available();
    }

    public void close()
            throws IOException {
        a();
        this.b.close();
    }

    public void mark(int paramInt) {
        if (this.c == null) {
            this.b.mark(paramInt);
        }
    }

    public boolean markSupported() {
        return (this.c == null) && (this.b.markSupported());
    }

    public int read()
            throws IOException {
        if (this.c != null) {
            byte[] arrayOfByte = this.c;
            int i = this.d;
            this.d = (i + 1);
            i = arrayOfByte[i];
            if (this.d >= this.e) {
                a();
            }
            return i & 0xFF;
        }
        return this.b.read();
    }

    public int read(byte[] paramArrayOfByte)
            throws IOException {
        return read(paramArrayOfByte, 0, paramArrayOfByte.length);
    }

    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws IOException {
        if (this.c != null) {
            int j = this.e - this.d;
            int i = paramInt2;
            if (paramInt2 > j) {
                i = j;
            }
            System.arraycopy(this.c, this.d, paramArrayOfByte, paramInt1, i);
            this.d += i;
            if (this.d >= this.e) {
                a();
            }
            return i;
        }
        return this.b.read(paramArrayOfByte, paramInt1, paramInt2);
    }

    public void reset()
            throws IOException {
        if (this.c == null) {
            this.b.reset();
        }
    }

    public long skip(long paramLong)
            throws IOException {
        long l1;
        if (this.c != null) {
            int i = this.e - this.d;
            if (i > paramLong) {
                this.d += (int) paramLong;
                return paramLong;
            }
            a();
            l1 = i + 0L;
            paramLong -= i;
        }
        for (; ; ) {
            long l2 = l1;
            if (paramLong > 0L) {
                l2 = l1 + this.b.skip(paramLong);
            }
            return l2;
            l1 = 0L;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */