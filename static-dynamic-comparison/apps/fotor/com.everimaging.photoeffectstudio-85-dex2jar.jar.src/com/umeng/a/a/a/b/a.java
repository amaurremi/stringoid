package com.umeng.a.a.a.b;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class a
        extends h {
    protected static final int a = -65536;
    protected static final int b = -2147418112;
    private static final m h = new m();
    protected boolean c = false;
    protected boolean d = true;
    protected int e;
    protected boolean f = false;
    private byte[] i = new byte[1];
    private byte[] j = new byte[2];
    private byte[] k = new byte[4];
    private byte[] l = new byte[8];
    private byte[] m = new byte[1];
    private byte[] n = new byte[2];
    private byte[] o = new byte[4];
    private byte[] p = new byte[8];

    public a(com.umeng.a.a.a.d.c paramc) {
        this(paramc, false, true);
    }

    public a(com.umeng.a.a.a.d.c paramc, boolean paramBoolean1, boolean paramBoolean2) {
        super(paramc);
        this.c = paramBoolean1;
        this.d = paramBoolean2;
    }

    private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws com.umeng.a.a.a.j {
        d(paramInt2);
        return this.g.d(paramArrayOfByte, paramInt1, paramInt2);
    }

    public ByteBuffer A()
            throws com.umeng.a.a.a.j {
        int i1 = w();
        d(i1);
        if (this.g.h() >= i1) {
            localObject = ByteBuffer.wrap(this.g.f(), this.g.g(), i1);
            this.g.a(i1);
            return (ByteBuffer) localObject;
        }
        Object localObject = new byte[i1];
        this.g.d((byte[]) localObject, 0, i1);
        return ByteBuffer.wrap((byte[]) localObject);
    }

    public void a() {
    }

    public void a(byte paramByte)
            throws com.umeng.a.a.a.j {
        this.i[0] = paramByte;
        this.g.b(this.i, 0, 1);
    }

    public void a(double paramDouble)
            throws com.umeng.a.a.a.j {
        a(Double.doubleToLongBits(paramDouble));
    }

    public void a(int paramInt)
            throws com.umeng.a.a.a.j {
        this.k[0] = ((byte) (paramInt >> 24 & 0xFF));
        this.k[1] = ((byte) (paramInt >> 16 & 0xFF));
        this.k[2] = ((byte) (paramInt >> 8 & 0xFF));
        this.k[3] = ((byte) (paramInt & 0xFF));
        this.g.b(this.k, 0, 4);
    }

    public void a(long paramLong)
            throws com.umeng.a.a.a.j {
        this.l[0] = ((byte) (int) (paramLong >> 56 & 0xFF));
        this.l[1] = ((byte) (int) (paramLong >> 48 & 0xFF));
        this.l[2] = ((byte) (int) (paramLong >> 40 & 0xFF));
        this.l[3] = ((byte) (int) (paramLong >> 32 & 0xFF));
        this.l[4] = ((byte) (int) (paramLong >> 24 & 0xFF));
        this.l[5] = ((byte) (int) (paramLong >> 16 & 0xFF));
        this.l[6] = ((byte) (int) (paramLong >> 8 & 0xFF));
        this.l[7] = ((byte) (int) (0xFF & paramLong));
        this.g.b(this.l, 0, 8);
    }

    public void a(c paramc)
            throws com.umeng.a.a.a.j {
        a(paramc.b);
        a(paramc.c);
    }

    public void a(d paramd)
            throws com.umeng.a.a.a.j {
        a(paramd.a);
        a(paramd.b);
    }

    public void a(e parame)
            throws com.umeng.a.a.a.j {
        a(parame.a);
        a(parame.b);
        a(parame.c);
    }

    public void a(f paramf)
            throws com.umeng.a.a.a.j {
        if (this.d) {
            a(0x80010000 | paramf.b);
            a(paramf.a);
            a(paramf.c);
            return;
        }
        a(paramf.a);
        a(paramf.b);
        a(paramf.c);
    }

    public void a(l paraml)
            throws com.umeng.a.a.a.j {
        a(paraml.a);
        a(paraml.b);
    }

    public void a(m paramm) {
    }

    public void a(String paramString)
            throws com.umeng.a.a.a.j {
        try {
            paramString = paramString.getBytes("UTF-8");
            a(paramString.length);
            this.g.b(paramString, 0, paramString.length);
            return;
        } catch (UnsupportedEncodingException paramString) {
            throw new com.umeng.a.a.a.j("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void a(ByteBuffer paramByteBuffer)
            throws com.umeng.a.a.a.j {
        int i1 = paramByteBuffer.limit() - paramByteBuffer.position();
        a(i1);
        this.g.b(paramByteBuffer.array(), paramByteBuffer.position() + paramByteBuffer.arrayOffset(), i1);
    }

    public void a(short paramShort)
            throws com.umeng.a.a.a.j {
        this.j[0] = ((byte) (paramShort >> 8 & 0xFF));
        this.j[1] = ((byte) (paramShort & 0xFF));
        this.g.b(this.j, 0, 2);
    }

    public void a(boolean paramBoolean)
            throws com.umeng.a.a.a.j {
        if (paramBoolean) {
        }
        for (byte b1 = 1; ; b1 = 0) {
            a(b1);
            return;
        }
    }

    public String b(int paramInt)
            throws com.umeng.a.a.a.j {
        try {
            d(paramInt);
            Object localObject = new byte[paramInt];
            this.g.d((byte[]) localObject, 0, paramInt);
            localObject = new String((byte[]) localObject, "UTF-8");
            return (String) localObject;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            throw new com.umeng.a.a.a.j("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void b() {
    }

    public void c() {
    }

    public void c(int paramInt) {
        this.e = paramInt;
        this.f = true;
    }

    public void d()
            throws com.umeng.a.a.a.j {
        a((byte) 0);
    }

    protected void d(int paramInt)
            throws com.umeng.a.a.a.j {
        if (paramInt < 0) {
            throw new i("Negative length: " + paramInt);
        }
        if (this.f) {
            this.e -= paramInt;
            if (this.e < 0) {
                throw new i("Message length exceeded: " + paramInt);
            }
        }
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }

    public f h()
            throws com.umeng.a.a.a.j {
        int i1 = w();
        if (i1 < 0) {
            if ((0xFFFF0000 & i1) != -2147418112) {
                throw new i(4, "Bad version in readMessageBegin");
            }
            return new f(z(), (byte) (i1 & 0xFF), w());
        }
        if (this.c) {
            throw new i(4, "Missing version in readMessageBegin, old client?");
        }
        return new f(b(i1), u(), w());
    }

    public void i() {
    }

    public m j() {
        return h;
    }

    public void k() {
    }

    public c l()
            throws com.umeng.a.a.a.j {
        byte b1 = u();
        if (b1 == 0) {
        }
        for (short s = 0; ; s = v()) {
            return new c("", b1, s);
        }
    }

    public void m() {
    }

    public e n()
            throws com.umeng.a.a.a.j {
        return new e(u(), u(), w());
    }

    public void o() {
    }

    public d p()
            throws com.umeng.a.a.a.j {
        return new d(u(), w());
    }

    public void q() {
    }

    public l r()
            throws com.umeng.a.a.a.j {
        return new l(u(), w());
    }

    public void s() {
    }

    public boolean t()
            throws com.umeng.a.a.a.j {
        return u() == 1;
    }

    public byte u()
            throws com.umeng.a.a.a.j {
        if (this.g.h() >= 1) {
            byte b1 = this.g.f()[this.g.g()];
            this.g.a(1);
            return b1;
        }
        a(this.m, 0, 1);
        return this.m[0];
    }

    public short v()
            throws com.umeng.a.a.a.j {
        int i1 = 0;
        byte[] arrayOfByte = this.n;
        if (this.g.h() >= 2) {
            arrayOfByte = this.g.f();
            i1 = this.g.g();
            this.g.a(2);
        }
        for (; ; ) {
            int i2 = arrayOfByte[i1];
            return (short) (arrayOfByte[(i1 + 1)] & 0xFF | (i2 & 0xFF) << 8);
            a(this.n, 0, 2);
        }
    }

    public int w()
            throws com.umeng.a.a.a.j {
        int i1 = 0;
        byte[] arrayOfByte = this.o;
        if (this.g.h() >= 4) {
            arrayOfByte = this.g.f();
            i1 = this.g.g();
            this.g.a(4);
        }
        for (; ; ) {
            int i2 = arrayOfByte[i1];
            int i3 = arrayOfByte[(i1 + 1)];
            int i4 = arrayOfByte[(i1 + 2)];
            return arrayOfByte[(i1 + 3)] & 0xFF | (i2 & 0xFF) << 24 | (i3 & 0xFF) << 16 | (i4 & 0xFF) << 8;
            a(this.o, 0, 4);
        }
    }

    public long x()
            throws com.umeng.a.a.a.j {
        int i1 = 0;
        byte[] arrayOfByte = this.p;
        if (this.g.h() >= 8) {
            arrayOfByte = this.g.f();
            i1 = this.g.g();
            this.g.a(8);
        }
        for (; ; ) {
            long l1 = arrayOfByte[i1] & 0xFF;
            long l2 = arrayOfByte[(i1 + 1)] & 0xFF;
            long l3 = arrayOfByte[(i1 + 2)] & 0xFF;
            long l4 = arrayOfByte[(i1 + 3)] & 0xFF;
            long l5 = arrayOfByte[(i1 + 4)] & 0xFF;
            long l6 = arrayOfByte[(i1 + 5)] & 0xFF;
            long l7 = arrayOfByte[(i1 + 6)] & 0xFF;
            return arrayOfByte[(i1 + 7)] & 0xFF | l1 << 56 | l2 << 48 | l3 << 40 | l4 << 32 | l5 << 24 | l6 << 16 | l7 << 8;
            a(this.p, 0, 8);
        }
    }

    public double y()
            throws com.umeng.a.a.a.j {
        return Double.longBitsToDouble(x());
    }

    public String z()
            throws com.umeng.a.a.a.j {
        int i1 = w();
        if (this.g.h() >= i1) {
            try {
                String str = new String(this.g.f(), this.g.g(), i1, "UTF-8");
                this.g.a(i1);
                return str;
            } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
                throw new com.umeng.a.a.a.j("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return b(i1);
    }

    public static class a
            implements j {
        protected boolean a = false;
        protected boolean b = true;
        protected int c;

        public a() {
            this(false, true);
        }

        public a(boolean paramBoolean1, boolean paramBoolean2) {
            this(paramBoolean1, paramBoolean2, 0);
        }

        public a(boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
            this.a = paramBoolean1;
            this.b = paramBoolean2;
            this.c = paramInt;
        }

        public h a(com.umeng.a.a.a.d.c paramc) {
            paramc = new a(paramc, this.a, this.b);
            if (this.c != 0) {
                paramc.c(this.c);
            }
            return paramc;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/a/a/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */