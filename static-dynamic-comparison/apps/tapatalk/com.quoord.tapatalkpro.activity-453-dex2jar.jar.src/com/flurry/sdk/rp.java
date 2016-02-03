package com.flurry.sdk;

import java.io.IOException;
import java.math.BigDecimal;

public final class rp
        extends rv {
    protected final BigDecimal c;

    public rp(BigDecimal paramBigDecimal) {
        this.c = paramBigDecimal;
    }

    public static rp a(BigDecimal paramBigDecimal) {
        return new rp(paramBigDecimal);
    }

    public final void a(hf paramhf, jw paramjw)
            throws IOException, hk {
        paramhf.a(this.c);
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
            } while (paramObject == null);
            bool1 = bool2;
        } while (paramObject.getClass() != getClass());
        return ((rp) paramObject).c.equals(this.c);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public int k() {
        return this.c.intValue();
    }

    public long l() {
        return this.c.longValue();
    }

    public double m() {
        return this.c.doubleValue();
    }

    public String n() {
        return this.c.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/rp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */