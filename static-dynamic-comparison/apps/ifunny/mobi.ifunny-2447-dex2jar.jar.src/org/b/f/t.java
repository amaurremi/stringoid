package org.b.f;

import java.math.BigInteger;
import java.nio.ByteBuffer;

import org.b.c.g;
import org.b.e.af;

final class t
        extends b {
    private g a = null;

    t() {
        super(null);
    }

    void a() {
        this.a.a(af.b());
    }

    void a(byte paramByte) {
        this.a.a(af.a(paramByte));
    }

    void a(double paramDouble) {
        this.a.a(af.a(paramDouble));
    }

    void a(float paramFloat) {
        this.a.a(af.a(paramFloat));
    }

    void a(int paramInt) {
        this.a.a(af.a(paramInt));
    }

    void a(long paramLong) {
        this.a.a(af.a(paramLong));
    }

    public void a(ByteBuffer paramByteBuffer, boolean paramBoolean) {
        byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
        paramByteBuffer.get(arrayOfByte);
        this.a.a(af.a(arrayOfByte, true));
    }

    void a(g paramg) {
        this.a = paramg;
    }

    void a(short paramShort) {
        this.a.a(af.a(paramShort));
    }

    void a(boolean paramBoolean) {
        this.a.a(af.a(paramBoolean));
    }

    void a(byte[] paramArrayOfByte) {
        this.a.a(af.a(paramArrayOfByte));
    }

    void b() {
        this.a.a(af.a());
    }

    void b(byte paramByte) {
        this.a.a(af.a(paramByte & 0xFF));
    }

    void b(int paramInt) {
        if (paramInt < 0) {
            long l = 0x7FFFFFFF & paramInt;
            this.a.a(af.a(l + 2147483648L));
            return;
        }
        this.a.a(af.a(paramInt));
    }

    void b(long paramLong) {
        if (paramLong < 0L) {
            BigInteger localBigInteger = BigInteger.valueOf(Long.MAX_VALUE + paramLong + 1L).setBit(63);
            this.a.a(af.a(localBigInteger));
            return;
        }
        this.a.a(af.a(paramLong));
    }

    void b(short paramShort) {
        this.a.a(af.a(0xFFFF & paramShort));
    }

    void c(int paramInt) {
        this.a.c(paramInt);
    }

    void d(int paramInt) {
        this.a.d(paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/f/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */