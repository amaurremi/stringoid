package com.flurry.sdk;

import java.io.IOException;

public final class rx
        extends rz {
    protected final Object c;

    public rx(Object paramObject) {
        this.c = paramObject;
    }

    public double a(double paramDouble) {
        if ((this.c instanceof Number)) {
            paramDouble = ((Number) this.c).doubleValue();
        }
        return paramDouble;
    }

    public final void a(hf paramhf, jw paramjw)
            throws IOException, hk {
        if (this.c == null) {
            paramhf.f();
            return;
        }
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
            paramObject = (rx) paramObject;
            if (this.c != null) {
                break;
            }
        } while (((rx) paramObject).c == null);
        return false;
        return this.c.equals(((rx) paramObject).c);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String n() {
        if (this.c == null) {
            return "null";
        }
        return this.c.toString();
    }

    public String toString() {
        return String.valueOf(this.c);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/rx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */