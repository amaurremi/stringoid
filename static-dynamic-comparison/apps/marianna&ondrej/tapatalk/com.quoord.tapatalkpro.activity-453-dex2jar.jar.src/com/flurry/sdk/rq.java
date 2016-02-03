package com.flurry.sdk;

import java.io.IOException;

public final class rq
        extends rv {
    protected final double c;

    public rq(double paramDouble) {
        this.c = paramDouble;
    }

    public static rq b(double paramDouble) {
        return new rq(paramDouble);
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
        } while (((rq) paramObject).c == this.c);
        return false;
    }

    public int hashCode() {
        long l = Double.doubleToLongBits(this.c);
        int i = (int) l;
        return (int) (l >> 32) ^ i;
    }

    public int k() {
        return (int) this.c;
    }

    public long l() {
        return this.c;
    }

    public double m() {
        return this.c;
    }

    public String n() {
        return ij.a(this.c);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/rq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */