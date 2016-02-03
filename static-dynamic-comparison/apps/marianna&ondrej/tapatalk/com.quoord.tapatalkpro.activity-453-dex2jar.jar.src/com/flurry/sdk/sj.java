package com.flurry.sdk;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

public final class sj
        extends OutputStream {
    private static final byte[] a = new byte[0];
    private final si b;
    private final LinkedList<byte[]> c = new LinkedList();
    private int d;
    private byte[] e;
    private int f;

    public sj() {
        this(null);
    }

    public sj(int paramInt) {
        this(null, paramInt);
    }

    public sj(si paramsi) {
        this(paramsi, 500);
    }

    public sj(si paramsi, int paramInt) {
        this.b = paramsi;
        if (paramsi == null) {
            this.e = new byte[paramInt];
            return;
        }
        this.e = paramsi.a(si.a.c);
    }

    private void g() {
        int i = 262144;
        this.d += this.e.length;
        int j = Math.max(this.d >> 1, 1000);
        if (j > 262144) {
        }
        for (; ; ) {
            this.c.add(this.e);
            this.e = new byte[i];
            this.f = 0;
            return;
            i = j;
        }
    }

    public void a() {
        this.d = 0;
        this.f = 0;
        if (!this.c.isEmpty()) {
            this.c.clear();
        }
    }

    public void a(int paramInt) {
        if (this.f >= this.e.length) {
            g();
        }
        byte[] arrayOfByte = this.e;
        int i = this.f;
        this.f = (i + 1);
        arrayOfByte[i] = ((byte) paramInt);
    }

    public void b(int paramInt) {
        if (this.f + 1 < this.e.length) {
            byte[] arrayOfByte = this.e;
            int i = this.f;
            this.f = (i + 1);
            arrayOfByte[i] = ((byte) (paramInt >> 8));
            arrayOfByte = this.e;
            i = this.f;
            this.f = (i + 1);
            arrayOfByte[i] = ((byte) paramInt);
            return;
        }
        a(paramInt >> 8);
        a(paramInt);
    }

    public byte[] b() {
        int j = this.d + this.f;
        if (j == 0) {
            return a;
        }
        byte[] arrayOfByte1 = new byte[j];
        Iterator localIterator = this.c.iterator();
        int i = 0;
        while (localIterator.hasNext()) {
            byte[] arrayOfByte2 = (byte[]) localIterator.next();
            int k = arrayOfByte2.length;
            System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, k);
            i += k;
        }
        System.arraycopy(this.e, 0, arrayOfByte1, i, this.f);
        i = this.f + i;
        if (i != j) {
            throw new RuntimeException("Internal error: total len assumed to be " + j + ", copied " + i + " bytes");
        }
        if (!this.c.isEmpty()) {
            a();
        }
        return arrayOfByte1;
    }

    public void c(int paramInt) {
        if (this.f + 2 < this.e.length) {
            byte[] arrayOfByte = this.e;
            int i = this.f;
            this.f = (i + 1);
            arrayOfByte[i] = ((byte) (paramInt >> 16));
            arrayOfByte = this.e;
            i = this.f;
            this.f = (i + 1);
            arrayOfByte[i] = ((byte) (paramInt >> 8));
            arrayOfByte = this.e;
            i = this.f;
            this.f = (i + 1);
            arrayOfByte[i] = ((byte) paramInt);
            return;
        }
        a(paramInt >> 16);
        a(paramInt >> 8);
        a(paramInt);
    }

    public byte[] c() {
        a();
        return this.e;
    }

    public void close() {
    }

    public byte[] d() {
        g();
        return this.e;
    }

    public byte[] d(int paramInt) {
        this.f = paramInt;
        return b();
    }

    public void e(int paramInt) {
        this.f = paramInt;
    }

    public byte[] e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public void flush() {
    }

    public void write(int paramInt) {
        a(paramInt);
    }

    public void write(byte[] paramArrayOfByte) {
        write(paramArrayOfByte, 0, paramArrayOfByte.length);
    }

    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        int i = paramInt1;
        for (; ; ) {
            int k = Math.min(this.e.length - this.f, paramInt2);
            int j = i;
            paramInt1 = paramInt2;
            if (k > 0) {
                System.arraycopy(paramArrayOfByte, i, this.e, this.f, k);
                j = i + k;
                this.f += k;
                paramInt1 = paramInt2 - k;
            }
            if (paramInt1 <= 0) {
                return;
            }
            g();
            i = j;
            paramInt2 = paramInt1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/sj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */