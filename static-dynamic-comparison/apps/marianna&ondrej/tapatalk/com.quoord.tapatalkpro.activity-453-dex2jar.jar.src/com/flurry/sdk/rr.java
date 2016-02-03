package com.flurry.sdk;

import java.io.IOException;

public final class rr
        extends rv {
    private static final rr[] d = new rr[12];
    final int c;

    static {
        int i = 0;
        while (i < 12) {
            d[i] = new rr(i - 1);
            i += 1;
        }
    }

    public rr(int paramInt) {
        this.c = paramInt;
    }

    public static rr a(int paramInt) {
        if ((paramInt > 10) || (paramInt < -1)) {
            return new rr(paramInt);
        }
        return d[(paramInt + 1)];
    }

    public final void a(hf paramhf, jw paramjw)
            throws IOException, hk {
        paramhf.b(this.c);
    }

    public boolean e() {
        return true;
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
        } while (((rr) paramObject).c == this.c);
        return false;
    }

    public int hashCode() {
        return this.c;
    }

    public int k() {
        return this.c;
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/rr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */