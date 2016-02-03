package com.flurry.sdk;

import java.lang.reflect.Member;

public abstract class mq
        extends mm {
    protected final mv b;

    protected mq(mv parammv) {
        this.b = parammv;
    }

    public abstract void a(Object paramObject1, Object paramObject2)
            throws UnsupportedOperationException, IllegalArgumentException;

    public abstract Class<?> h();

    public abstract Member i();

    protected mv j() {
        return this.b;
    }

    public final void k() {
        qy.a(i());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/mq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */