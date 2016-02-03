package com.flurry.sdk;

public abstract class gw
        implements gv, Comparable<gv> {
    public int a(gv paramgv) {
        return gs.b().a(this, paramgv, a());
    }

    public abstract fn a();

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            return true;
            if (!(paramObject instanceof gv)) {
                return false;
            }
            if (getClass() != paramObject.getClass()) {
                return false;
            }
        } while (a((gv) paramObject) == 0);
        return false;
    }

    public int hashCode() {
        return gs.b().b(this, a());
    }

    public String toString() {
        return gs.b().a(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/gw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */