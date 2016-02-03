package com.flurry.sdk;

import java.util.HashMap;

public class ob
        implements jm {
    protected HashMap<qj, jl> a = null;

    public jl a(sh paramsh, iy paramiy, ir paramir, is paramis) {
        if (this.a == null) {
            return null;
        }
        return (jl) this.a.get(new qj(paramsh.p()));
    }

    public ob a(Class<?> paramClass, jl paramjl) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(new qj(paramClass), paramjl);
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */