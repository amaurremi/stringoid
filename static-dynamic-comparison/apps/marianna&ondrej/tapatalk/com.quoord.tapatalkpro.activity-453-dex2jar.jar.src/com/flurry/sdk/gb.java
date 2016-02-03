package com.flurry.sdk;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class gb
        extends gf {
    private c a = null;
    private byte[] b = null;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private final gy f = new gy();

    protected gb() {
    }

    gb(InputStream paramInputStream, int paramInt) {
        a(paramInputStream, paramInt);
    }

    gb(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        a(paramArrayOfByte, paramInt1, paramInt2);
    }

    private void a(int paramInt, c paramc) {
        if (this.a != null) {
            this.a.a();
        }
        paramc.a(paramInt, this);
        this.a = paramc;
    }

    private long b(long paramLong)
            throws IOException {
        int i = this.b[this.d] & 0xFF;
        paramLong = (i & 0x7F) << 28 ^ paramLong;
        if (i > 127) {
            byte[] arrayOfByte = this.b;
            int j = this.d;
            i = 2;
            j = arrayOfByte[(1 + j)] & 0xFF;
            long l = paramLong ^ (j & 0x7F) << 35;
            paramLong = l;
            if (j > 127) {
                arrayOfByte = this.b;
                j = this.d;
                i = 3;
                j = arrayOfByte[(j + 2)] & 0xFF;
                l ^= (j & 0x7F) << 42;
                paramLong = l;
                if (j > 127) {
                    arrayOfByte = this.b;
                    j = this.d;
                    i = 4;
                    j = arrayOfByte[(j + 3)] & 0xFF;
                    l ^= (j & 0x7F) << 49;
                    paramLong = l;
                    if (j > 127) {
                        arrayOfByte = this.b;
                        j = this.d;
                        i = 5;
                        j = arrayOfByte[(j + 4)] & 0xFF;
                        l ^= (j & 0x7F) << 56;
                        paramLong = l;
                        if (j > 127) {
                            arrayOfByte = this.b;
                            j = this.d;
                            i = 6;
                            j = arrayOfByte[(j + 5)] & 0xFF;
                            paramLong = l ^ (j & 0x7F) << 63;
                            if (j > 127) {
                                throw new IOException("Invalid long encoding");
                            }
                        }
                    }
                }
            }
        } else {
            i = 1;
        }
        this.d = (i + this.d);
        return paramLong;
    }

    private void b(int paramInt)
            throws IOException {
        int i = this.e - this.d;
        if (i < paramInt) {
            this.a.a(this.b, this.d, this.c, i);
        }
    }

    private long t()
            throws IOException {
        for (long l = d(); l < 0L; l = d()) {
            a(e());
        }
        return l;
    }

    a a() {
        return new a(this, null);
    }

    gb a(InputStream paramInputStream, int paramInt) {
        a(paramInt, new d(paramInputStream, null));
        return this;
    }

    gb a(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        a(8192, new b(paramArrayOfByte, paramInt1, paramInt2, null));
        return this;
    }

    public gy a(gy paramgy)
            throws IOException {
        int i = d();
        if (paramgy != null) {
        }
        for (; ; ) {
            paramgy.a(i);
            if (i != 0) {
                c(paramgy.a(), 0, i);
            }
            return paramgy;
            paramgy = new gy();
        }
    }

    public ByteBuffer a(ByteBuffer paramByteBuffer)
            throws IOException {
        int i = d();
        if ((paramByteBuffer != null) && (i <= paramByteBuffer.capacity())) {
            paramByteBuffer.clear();
        }
        for (; ; ) {
            c(paramByteBuffer.array(), paramByteBuffer.position(), i);
            paramByteBuffer.limit(i);
            return paramByteBuffer;
            paramByteBuffer = ByteBuffer.allocate(i);
        }
    }

    public void a(int paramInt)
            throws IOException {
        a(paramInt);
    }

    protected void a(long paramLong)
            throws IOException {
        int i = this.e - this.d;
        if (paramLong <= i) {
            this.d = ((int) (this.d + paramLong));
            return;
        }
        this.d = 0;
        this.e = 0;
        long l = i;
        this.a.a(paramLong - l);
    }

    public void b()
            throws IOException {
    }

    public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws IOException {
        c(paramArrayOfByte, paramInt1, paramInt2);
    }

    protected void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws IOException {
        int i = this.e - this.d;
        if (paramInt2 <= i) {
            System.arraycopy(this.b, this.d, paramArrayOfByte, paramInt1, paramInt2);
            this.d += paramInt2;
            return;
        }
        System.arraycopy(this.b, this.d, paramArrayOfByte, paramInt1, i);
        this.d = this.e;
        this.a.a(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
    }

    public boolean c()
            throws IOException {
        if (this.e == this.d) {
            this.e = this.a.b(this.b, 0, this.b.length);
            this.d = 0;
            if (this.e == 0) {
                throw new EOFException();
            }
        }
        byte[] arrayOfByte = this.b;
        int i = this.d;
        this.d = (i + 1);
        return (arrayOfByte[i] & 0xFF) == 1;
    }

    public int d()
            throws IOException {
        int k = 5;
        b(5);
        int j = this.b[this.d] & 0xFF;
        int i = j & 0x7F;
        if (j > 127) {
            byte[] arrayOfByte = this.b;
            int m = this.d;
            j = 2;
            int n = arrayOfByte[(1 + m)] & 0xFF;
            m = i ^ (n & 0x7F) << 7;
            i = m;
            if (n > 127) {
                arrayOfByte = this.b;
                i = this.d;
                j = 3;
                n = arrayOfByte[(i + 2)] & 0xFF;
                m ^= (n & 0x7F) << 14;
                i = m;
                if (n > 127) {
                    arrayOfByte = this.b;
                    i = this.d;
                    j = 4;
                    n = arrayOfByte[(i + 3)] & 0xFF;
                    m ^= (n & 0x7F) << 21;
                    i = m;
                    if (n > 127) {
                        n = this.b[(this.d + 4)] & 0xFF;
                        i = m ^ (n & 0x7F) << 28;
                        j = k;
                        if (n > 127) {
                            throw new IOException("Invalid int encoding");
                        }
                    }
                }
            }
        }
        for (; ; ) {
            this.d = (j + this.d);
            if (this.d > this.e) {
                throw new EOFException();
            }
            return -(i & 0x1) ^ i >>> 1;
            j = 1;
        }
    }

    public long e()
            throws IOException {
        b(10);
        byte[] arrayOfByte = this.b;
        int i = this.d;
        this.d = (i + 1);
        int j = arrayOfByte[i] & 0xFF;
        i = j & 0x7F;
        long l;
        if (j > 127) {
            arrayOfByte = this.b;
            j = this.d;
            this.d = (j + 1);
            j = arrayOfByte[j] & 0xFF;
            i ^= (j & 0x7F) << 7;
            if (j > 127) {
                arrayOfByte = this.b;
                j = this.d;
                this.d = (j + 1);
                j = arrayOfByte[j] & 0xFF;
                i ^= (j & 0x7F) << 14;
                if (j > 127) {
                    arrayOfByte = this.b;
                    j = this.d;
                    this.d = (j + 1);
                    j = arrayOfByte[j] & 0xFF;
                    i ^= (j & 0x7F) << 21;
                    if (j > 127) {
                        l = b(i);
                    }
                }
            }
        }
        while (this.d > this.e) {
            throw new EOFException();
            l = i;
            continue;
            l = i;
            continue;
            l = i;
            continue;
            l = i;
        }
        return -(l & 1L) ^ l >>> 1;
    }

    public float f()
            throws IOException {
        b(4);
        int i = this.b[this.d];
        int j = this.b[(1 + this.d)];
        int k = this.b[(this.d + 2)];
        int m = this.b[(this.d + 3)];
        if (this.d + 4 > this.e) {
            throw new EOFException();
        }
        this.d += 4;
        return Float.intBitsToFloat((j & 0xFF) << 8 | i & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24);
    }

    public double g()
            throws IOException {
        b(8);
        int i = this.b[this.d];
        int j = this.b[(1 + this.d)];
        int k = this.b[(this.d + 2)];
        int m = this.b[(this.d + 3)];
        int n = this.b[(this.d + 4)];
        int i1 = this.b[(this.d + 5)];
        int i2 = this.b[(this.d + 6)];
        int i3 = this.b[(this.d + 7)];
        if (this.d + 8 > this.e) {
            throw new EOFException();
        }
        this.d += 8;
        long l = (j & 0xFF) << 8 | i & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24;
        return Double.longBitsToDouble((n & 0xFF | (i1 & 0xFF) << 8 | (i2 & 0xFF) << 16 | (i3 & 0xFF) << 24) << 32 | l & 0xFFFFFFFF);
    }

    public String h()
            throws IOException {
        return a(this.f).toString();
    }

    public void i()
            throws IOException {
        a(d());
    }

    public void j()
            throws IOException {
        a(d());
    }

    public int k()
            throws IOException {
        return d();
    }

    protected long l()
            throws IOException {
        long l2 = e();
        long l1 = l2;
        if (l2 < 0L) {
            e();
            l1 = -l2;
        }
        return l1;
    }

    public long m()
            throws IOException {
        return l();
    }

    public long n()
            throws IOException {
        return l();
    }

    public long o()
            throws IOException {
        return t();
    }

    public long p()
            throws IOException {
        return l();
    }

    public long q()
            throws IOException {
        return l();
    }

    public long r()
            throws IOException {
        return t();
    }

    public int s()
            throws IOException {
        return d();
    }

    static class a {
        boolean a = false;
        private final gb b;
        private byte[] c;
        private int d;
        private int e;

        private a(gb paramgb) {
            this.b = paramgb;
        }

        void a() {
            this.c = gb.a(this.b);
            this.d = gb.b(this.b);
            this.e = gb.c(this.b);
            this.a = true;
        }

        void a(int paramInt) {
            if (this.a) {
                this.d = paramInt;
                return;
            }
            gb.a(this.b, paramInt);
        }

        void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
            if (this.a) {
                this.c = paramArrayOfByte;
                this.e = (paramInt1 + paramInt2);
                this.d = paramInt1;
                return;
            }
            gb.a(this.b, paramArrayOfByte);
            gb.b(this.b, paramInt1 + paramInt2);
            gb.a(this.b, paramInt1);
            gb.c(this.b, paramInt1);
        }

        int b() {
            if (this.a) {
                return this.d;
            }
            return gb.b(this.b);
        }

        void b(int paramInt) {
            if (this.a) {
                this.e = paramInt;
                return;
            }
            gb.b(this.b, paramInt);
        }

        int c() {
            if (this.a) {
                return this.e;
            }
            return gb.c(this.b);
        }

        byte[] d() {
            if (this.a) {
                return this.c;
            }
            return gb.a(this.b);
        }
    }

    static class b
            extends gb.c {
        private byte[] b;
        private int c;
        private int d;
        private boolean e = false;

        private b(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
            if ((paramArrayOfByte.length < 16) || (paramInt2 < 16)) {
                this.b = new byte[16];
                System.arraycopy(paramArrayOfByte, paramInt1, this.b, 0, paramInt2);
                this.c = 0;
                this.d = paramInt2;
                return;
            }
            this.b = paramArrayOfByte;
            this.c = paramInt1;
            this.d = (paramInt1 + paramInt2);
        }

        protected void a(int paramInt, gb paramgb) {
            gb.a(paramgb, this.b);
            gb.a(paramgb, this.c);
            gb.c(paramgb, this.c);
            gb.b(paramgb, this.d);
            this.a = new gb.a(paramgb, null);
        }

        protected void a(long paramLong)
                throws IOException {
            if (b(paramLong) < paramLong) {
                throw new EOFException();
            }
        }

        protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
                throws IOException {
            if (b(paramArrayOfByte, paramInt1, paramInt2) < paramInt2) {
                throw new EOFException();
            }
        }

        protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
                throws IOException {
            if (!this.e) {
                byte[] arrayOfByte = new byte[paramInt3 + 16];
                System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt3);
                this.a.a(arrayOfByte, 0, paramInt3);
                this.e = true;
            }
        }

        protected int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
                throws IOException {
            return 0;
        }

        protected long b(long paramLong)
                throws IOException {
            this.d = this.a.c();
            this.c = this.a.b();
            long l = this.d - this.c;
            if (l >= paramLong) {
                this.c = ((int) (this.c + paramLong));
                this.a.a(this.c);
                return paramLong;
            }
            this.c = ((int) (this.c + l));
            this.a.a(this.c);
            return l;
        }

        public void close()
                throws IOException {
            this.a.a(this.a.c());
        }

        public int read()
                throws IOException {
            this.d = this.a.c();
            this.c = this.a.b();
            if (this.c >= this.d) {
                return -1;
            }
            byte[] arrayOfByte = this.a.d();
            int i = this.c;
            this.c = (i + 1);
            i = arrayOfByte[i];
            this.a.a(this.c);
            return i & 0xFF;
        }
    }

    static abstract class c
            extends InputStream {
        protected gb.a a;

        protected void a() {
            this.a.a();
        }

        protected void a(int paramInt, gb paramgb) {
            gb.a(paramgb, new byte[paramInt]);
            gb.a(paramgb, 0);
            gb.c(paramgb, 0);
            gb.b(paramgb, 0);
            this.a = new gb.a(paramgb, null);
        }

        protected abstract void a(long paramLong)
                throws IOException;

        protected abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
                throws IOException;

        protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
                throws IOException {
            System.arraycopy(paramArrayOfByte, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
            this.a.a(paramInt2);
            paramInt1 = b(paramArrayOfByte, paramInt2 + paramInt3, paramArrayOfByte.length - paramInt3);
            this.a.b(paramInt1 + paramInt3);
        }

        public int available()
                throws IOException {
            return this.a.c() - this.a.b();
        }

        protected abstract int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
                throws IOException;

        protected abstract long b(long paramLong)
                throws IOException;

        public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
                throws IOException {
            int j = this.a.c();
            int i = this.a.b();
            byte[] arrayOfByte = this.a.d();
            j -= i;
            if (j >= paramInt2) {
                System.arraycopy(arrayOfByte, i, paramArrayOfByte, paramInt1, paramInt2);
                this.a.a(i + paramInt2);
            }
            do {
                return paramInt2;
                System.arraycopy(arrayOfByte, i, paramArrayOfByte, paramInt1, j);
                this.a.a(i + j);
                paramInt1 = j + b(paramArrayOfByte, paramInt1 + j, paramInt2 - j);
                paramInt2 = paramInt1;
            } while (paramInt1 != 0);
            return -1;
        }

        public long skip(long paramLong)
                throws IOException {
            int i = this.a.c();
            int j = this.a.b();
            int k = i - j;
            if (k > paramLong) {
                i = (int) (j + paramLong);
                this.a.a(i);
                return paramLong;
            }
            this.a.a(i);
            return b(paramLong - k) + k;
        }
    }

    static class d
            extends gb.c {
        protected boolean b = false;
        private InputStream c;

        private d(InputStream paramInputStream) {
            this.c = paramInputStream;
        }

        protected void a(long paramLong)
                throws IOException {
            int i = 0;
            while (paramLong > 0L) {
                long l = this.c.skip(paramLong);
                if (l > 0L) {
                    paramLong -= l;
                } else if (l == 0L) {
                    if (i != 0) {
                        this.b = true;
                        throw new EOFException();
                    }
                    i = 1;
                } else {
                    this.b = true;
                    throw new EOFException();
                }
            }
        }

        protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
                throws IOException {
            while (paramInt2 > 0) {
                int i = this.c.read(paramArrayOfByte, paramInt1, paramInt2);
                if (i < 0) {
                    this.b = true;
                    throw new EOFException();
                }
                paramInt2 -= i;
                paramInt1 += i;
            }
        }

        protected int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
                throws IOException {
            int i = paramInt2;
            for (; ; ) {
                if (i > 0) {
                }
                try {
                    j = this.c.read(paramArrayOfByte, paramInt1, i);
                    if (j >= 0) {
                        break label36;
                    }
                    this.b = true;
                } catch (EOFException paramArrayOfByte) {
                    for (; ; ) {
                        int j;
                        this.b = true;
                    }
                }
                return paramInt2 - i;
                label36:
                i -= j;
                paramInt1 += j;
            }
        }

        protected long b(long paramLong)
                throws IOException {
            int i = 0;
            long l1 = paramLong;
            for (; ; ) {
                if (l1 > 0L) {
                    try {
                        long l2 = this.c.skip(paramLong);
                        if (l2 > 0L) {
                            l1 -= l2;
                            continue;
                        }
                        if (l2 == 0L) {
                            if (i == 0) {
                                break label78;
                            }
                            this.b = true;
                        } else {
                            this.b = true;
                        }
                    } catch (EOFException localEOFException) {
                        this.b = true;
                    }
                } else {
                    return paramLong - l1;
                    label78:
                    i = 1;
                }
            }
        }

        public void close()
                throws IOException {
            this.c.close();
        }

        public int read()
                throws IOException {
            if (this.a.c() - this.a.b() == 0) {
                return this.c.read();
            }
            int i = this.a.b();
            int j = this.a.d()[i];
            this.a.a(i + 1);
            return j & 0xFF;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/gb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */