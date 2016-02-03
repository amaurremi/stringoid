package org.b.f;

import java.math.BigInteger;

final class d
        extends b {
    BigInteger a;

    d() {
        super("integer");
    }

    void a(byte paramByte) {
        this.a = BigInteger.valueOf(paramByte);
    }

    void a(int paramInt) {
        this.a = BigInteger.valueOf(paramInt);
    }

    void a(long paramLong) {
        this.a = BigInteger.valueOf(paramLong);
    }

    void a(short paramShort) {
        this.a = BigInteger.valueOf(paramShort);
    }

    void b(byte paramByte) {
        BigInteger.valueOf(paramByte & 0xFF);
    }

    void b(int paramInt) {
        if (paramInt < 0) {
            this.a = BigInteger.valueOf((0x7FFFFFFF & paramInt) + 2147483648L);
            return;
        }
        this.a = BigInteger.valueOf(paramInt);
    }

    void b(long paramLong) {
        if (paramLong < 0L) {
            this.a = BigInteger.valueOf(Long.MAX_VALUE + paramLong + 1L).setBit(63);
            return;
        }
        this.a = BigInteger.valueOf(paramLong);
    }

    void b(short paramShort) {
        BigInteger.valueOf(0xFFFF & paramShort);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */