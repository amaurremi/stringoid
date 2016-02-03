package org.b.e;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.b.c.e;

class o
        extends n {
    private float a;

    o(float paramFloat) {
        this.a = paramFloat;
    }

    public StringBuilder a(StringBuilder paramStringBuilder) {
        return paramStringBuilder.append(Float.toString(this.a));
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
        if (paramObject == this) {
        }
        do {
            return true;
            if (!(paramObject instanceof ae)) {
                return false;
            }
            paramObject = (ae) paramObject;
            if (!((ae) paramObject).f()) {
                return false;
            }
        } while (this.a == ((ae) paramObject).k().o());
        return false;
    }

    public float floatValue() {
        return this.a;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.a);
    }

    public int intValue() {
        return (int) this.a;
    }

    public long longValue() {
        return this.a;
    }

    public float n() {
        return this.a;
    }

    public double o() {
        return this.a;
    }

    public BigInteger s() {
        return new BigDecimal(this.a).toBigInteger();
    }

    public short shortValue() {
        return (short) (int) this.a;
    }

    public String toString() {
        return Float.toString(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/e/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */