package org.b.e;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.b.c.e;

class l
        extends n {
    private double a;

    l(double paramDouble) {
        this.a = paramDouble;
    }

    public StringBuilder a(StringBuilder paramStringBuilder) {
        return paramStringBuilder.append(Double.toString(this.a));
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
        return (float) this.a;
    }

    public int hashCode() {
        long l = Double.doubleToLongBits(this.a);
        return (int) (l ^ l >>> 32);
    }

    public int intValue() {
        return (int) this.a;
    }

    public long longValue() {
        return this.a;
    }

    public float n() {
        return (float) this.a;
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
        return Double.toString(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/e/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */