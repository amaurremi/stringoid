package com.flurry.sdk;

import java.util.HashMap;

public class oe
        extends ky.a {
    protected HashMap<qj, kx> a;

    public kx a(iy paramiy, ir paramir, kx paramkx) {
        paramiy = (kx) this.a.get(new qj(paramir.b()));
        if (paramiy == null) {
            return paramkx;
        }
        return paramiy;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/oe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */