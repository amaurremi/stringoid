package com.flurry.sdk;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class lj
        extends mc<AtomicReference<?>>
        implements js {
    protected final sh a;
    protected final is b;
    protected jg<?> c;

    public lj(sh paramsh, is paramis) {
        super(AtomicReference.class);
        this.a = paramsh;
        this.b = paramis;
    }

    public void a(iy paramiy, jc paramjc)
            throws jh {
        this.c = paramjc.a(paramiy, this.a, this.b);
    }

    public AtomicReference<?> b(hj paramhj, iz paramiz)
            throws IOException, hk {
        return new AtomicReference(this.c.a(paramhj, paramiz));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/lj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */