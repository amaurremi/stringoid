package com.flurry.sdk;

import java.io.IOException;

public final class rn
        extends rz {
    public static final rn c = new rn();
    public static final rn d = new rn();

    public static rn s() {
        return c;
    }

    public static rn t() {
        return d;
    }

    public double a(double paramDouble) {
        if (this == c) {
            return 1.0D;
        }
        return 0.0D;
    }

    public final void a(hf paramhf, jw paramjw)
            throws IOException, hk {
        if (this == c) {
        }
        for (boolean bool = true; ; bool = false) {
            paramhf.a(bool);
            return;
        }
    }

    public boolean equals(Object paramObject) {
        return paramObject == this;
    }

    public boolean g() {
        return true;
    }

    public boolean j() {
        return this == c;
    }

    public String n() {
        if (this == c) {
            return "true";
        }
        return "false";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/rn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */