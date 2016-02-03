package com.flurry.sdk;

import java.io.IOException;

public class oy
        extends pw<Object> {
    public oy() {
        super(Object.class);
    }

    protected void a(Object paramObject)
            throws jh {
        throw new jh("No serializer found for class " + paramObject.getClass().getName() + " and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS) )");
    }

    public void a(Object paramObject, hf paramhf, jw paramjw)
            throws IOException, jh {
        if (paramjw.a(ju.a.m)) {
            a(paramObject);
        }
        paramhf.d();
        paramhf.e();
    }

    public final void a(Object paramObject, hf paramhf, jw paramjw, jz paramjz)
            throws IOException, he {
        if (paramjw.a(ju.a.m)) {
            a(paramObject);
        }
        paramjz.b(paramObject, paramhf);
        paramjz.e(paramObject, paramhf);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/oy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */