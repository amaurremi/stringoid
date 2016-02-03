package org.b.f;

import org.b.c;

final class i
        extends b {
    int a;

    i() {
        super("integer");
    }

    void a(byte paramByte) {
        this.a = paramByte;
    }

    void a(int paramInt) {
        this.a = paramInt;
    }

    void a(long paramLong) {
        if ((paramLong < -2147483648L) || (paramLong > 2147483647L)) {
            throw new c();
        }
        this.a = ((int) paramLong);
    }

    void a(short paramShort) {
        this.a = paramShort;
    }

    void b(byte paramByte) {
        this.a = (paramByte & 0xFF);
    }

    void b(int paramInt) {
        if (paramInt < 0) {
            throw new c();
        }
        this.a = paramInt;
    }

    void b(long paramLong) {
        if ((paramLong < 0L) || (paramLong > 2147483647L)) {
            throw new c();
        }
        this.a = ((int) paramLong);
    }

    void b(short paramShort) {
        this.a = (0xFFFF & paramShort);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/f/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */