package com.flurry.sdk;

import java.io.IOException;

public final class rt
        extends rv {
    final long c;

    public rt(long paramLong) {
        this.c = paramLong;
    }

    public static rt a(long paramLong) {
        return new rt(paramLong);
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
        } while (((rt) paramObject).c == this.c);
        return false;
    }

    public int hashCode() {
        return (int) this.c ^ (int) (this.c >> 32);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/rt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */