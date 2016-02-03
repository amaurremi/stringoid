package com.flurry.sdk;

import java.io.IOException;
import java.math.BigInteger;

public final class rl
        extends rv {
    protected final BigInteger c;

    public rl(BigInteger paramBigInteger) {
        this.c = paramBigInteger;
    }

    public static rl a(BigInteger paramBigInteger) {
        return new rl(paramBigInteger);
    }

    public final void a(hf paramhf, jw paramjw)
            throws IOException, hk {
        paramhf.a(this.c);
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            return true;
            if (paramObject == null) {
                return false;
            }
            if (paramObject.getClass() != getClass()) {
                return false;
            }
        } while (((rl) paramObject).c == this.c);
        return false;
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/rl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */