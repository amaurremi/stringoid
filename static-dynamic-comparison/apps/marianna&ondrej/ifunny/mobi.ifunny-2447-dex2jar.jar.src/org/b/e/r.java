package org.b.e;

import java.math.BigInteger;

import org.b.c;
import org.b.c.e;

class r
        extends q {
    private static long b = 127L;
    private static long c = 32767L;
    private static long d = 2147483647L;
    private static long e = -128L;
    private static long f = -32768L;
    private static long g = -2147483648L;
    private long a;

    r(long paramLong) {
        this.a = paramLong;
    }

    public StringBuilder a(StringBuilder paramStringBuilder) {
        return paramStringBuilder.append(Long.toString(this.a));
    }

    public void a(e parame) {
        parame.a(this.a);
    }

    public byte byteValue() {
        return (byte) (int) this.a;
    }

    public double doubleValue() {
        return this.a;
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = true;
        boolean bool3 = false;
        boolean bool1;
        if (paramObject == this) {
            bool1 = true;
        }
        do {
            do {
                return bool1;
                bool1 = bool3;
            } while (!(paramObject instanceof ae));
            paramObject = (ae) paramObject;
            bool1 = bool3;
        } while (!((ae) paramObject).e());
        try {
            long l1 = this.a;
            long l2 = ((ae) paramObject).j().q();
            if (l1 == l2) {
            }
            for (bool1 = bool2; ; bool1 = false) {
                return bool1;
            }
            return false;
        } catch (c paramObject) {
        }
    }

    public float floatValue() {
        return (float) this.a;
    }

    public int hashCode() {
        if ((g <= this.a) && (this.a <= d)) {
            return (int) this.a;
        }
        return (int) (this.a ^ this.a >>> 32);
    }

    public int intValue() {
        return (int) this.a;
    }

    public long longValue() {
        return this.a;
    }

    public byte n() {
        if ((this.a > b) || (this.a < e)) {
            throw new c();
        }
        return (byte) (int) this.a;
    }

    public short o() {
        if ((this.a > c) || (this.a < f)) {
            throw new c();
        }
        return (short) (int) this.a;
    }

    public int p() {
        if ((this.a > d) || (this.a < g)) {
            throw new c();
        }
        return (int) this.a;
    }

    public long q() {
        return this.a;
    }

    public BigInteger r() {
        return BigInteger.valueOf(this.a);
    }

    public BigInteger s() {
        return BigInteger.valueOf(this.a);
    }

    public short shortValue() {
        return (short) (int) this.a;
    }

    public String toString() {
        return Long.toString(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/e/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */