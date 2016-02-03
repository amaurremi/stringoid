package com.flurry.sdk;

import java.lang.reflect.Method;
import java.util.Map;

public class of {
    protected final Method a;
    protected final po b;

    public of(mr parammr, po parampo) {
        this.a = parammr.e();
        this.b = parampo;
    }

    public void a(jw paramjw)
            throws jh {
        this.b.a(paramjw);
    }

    public void a(Object paramObject, hf paramhf, jw paramjw)
            throws Exception {
        paramObject = this.a.invoke(paramObject, new Object[0]);
        if (paramObject == null) {
            return;
        }
        if (!(paramObject instanceof Map)) {
            throw new jh("Value returned by 'any-getter' (" + this.a.getName() + "()) not java.util.Map but " + paramObject.getClass().getName());
        }
        this.b.b((Map) paramObject, paramhf, paramjw);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/of.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */