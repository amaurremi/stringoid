package org.b.e;

import java.math.BigInteger;

import org.b.c;
import org.b.c.e;

class h
        extends q {
    private static BigInteger b = BigInteger.valueOf(127L);
    private static BigInteger c = BigInteger.valueOf(32767L);
    private static BigInteger d = BigInteger.valueOf(2147483647L);
    private static BigInteger e = BigInteger.valueOf(Long.MAX_VALUE);
    private static BigInteger f = BigInteger.valueOf(-128L);
    private static BigInteger g = BigInteger.valueOf(-32768L);
    private static BigInteger h = BigInteger.valueOf(-2147483648L);
    private static BigInteger i = BigInteger.valueOf(Long.MIN_VALUE);
    private BigInteger a;

    h(BigInteger paramBigInteger) {
        this.a = paramBigInteger;
    }

    public StringBuilder a(StringBuilder paramStringBuilder) {
        return paramStringBuilder.append(this.a.toString());
    }

    public void a(e parame) {
        parame.a(this.a);
    }

    public byte byteValue() {
        return this.a.byteValue();
    }

    public double doubleValue() {
        return this.a.doubleValue();
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1;
        if (paramObject == this) {
            bool1 = true;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (!(paramObject instanceof ae));
            paramObject = (ae) paramObject;
            bool1 = bool2;
        } while (!((ae) paramObject).e());
        return this.a.equals(((ae) paramObject).j().s());
    }

    public float floatValue() {
        return this.a.floatValue();
    }

    public int hashCode() {
        if ((h.compareTo(this.a) <= 0) && (this.a.compareTo(d) <= 0)) {
            return (int) this.a.longValue();
        }
        if ((i.compareTo(this.a) <= 0) && (this.a.compareTo(e) <= 0)) {
            long l = this.a.longValue();
            return (int) (l ^ l >>> 32);
        }
        return this.a.hashCode();
    }

    public int intValue() {
        return this.a.intValue();
    }

    public long longValue() {
        return this.a.longValue();
    }

    public byte n() {
        if ((this.a.compareTo(b) > 0) || (this.a.compareTo(f) < 0)) {
            throw new c();
        }
        return this.a.byteValue();
    }

    public short o() {
        if ((this.a.compareTo(c) > 0) || (this.a.compareTo(g) < 0)) {
            throw new c();
        }
        return this.a.shortValue();
    }

    public int p() {
        if ((this.a.compareTo(d) > 0) || (this.a.compareTo(h) < 0)) {
            throw new c();
        }
        return this.a.intValue();
    }

    public long q() {
        if ((this.a.compareTo(e) > 0) || (this.a.compareTo(i) < 0)) {
            throw new c();
        }
        return this.a.longValue();
    }

    public BigInteger r() {
        return this.a;
    }

    public BigInteger s() {
        return this.a;
    }

    public short shortValue() {
        return this.a.shortValue();
    }

    public String toString() {
        return this.a.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/e/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */