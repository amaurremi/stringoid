package com.millennialmedia.a.a.b;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class v
        extends Number {
    private final String a;

    public v(String paramString) {
        this.a = paramString;
    }

    private Object writeReplace() {
        return new BigDecimal(this.a);
    }

    public double doubleValue() {
        return Double.parseDouble(this.a);
    }

    public float floatValue() {
        return Float.parseFloat(this.a);
    }

    public int intValue() {
        try {
            int i = Integer.parseInt(this.a);
            return i;
        } catch (NumberFormatException localNumberFormatException1) {
            try {
                long l = Long.parseLong(this.a);
                return (int) l;
            } catch (NumberFormatException localNumberFormatException2) {
            }
        }
        return new BigInteger(this.a).intValue();
    }

    public long longValue() {
        try {
            long l = Long.parseLong(this.a);
            return l;
        } catch (NumberFormatException localNumberFormatException) {
        }
        return new BigInteger(this.a).longValue();
    }

    public String toString() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */