package com.flurry.sdk;

import java.io.IOException;

public class oj
        extends pc {
    public oj(sh paramsh, oi[] paramArrayOfoi1, oi[] paramArrayOfoi2, of paramof, Object paramObject) {
        super(paramsh, paramArrayOfoi1, paramArrayOfoi2, paramof, paramObject);
    }

    public oj(Class<?> paramClass, oi[] paramArrayOfoi1, oi[] paramArrayOfoi2, of paramof, Object paramObject) {
        super(paramClass, paramArrayOfoi1, paramArrayOfoi2, paramof, paramObject);
    }

    public static oj a(Class<?> paramClass) {
        return new oj(paramClass, a, null, null, null);
    }

    public jk<Object> a() {
        return new pa(this);
    }

    public final void a(Object paramObject, hf paramhf, jw paramjw)
            throws IOException, he {
        paramhf.d();
        if (this.e != null) {
            c(paramObject, paramhf, paramjw);
        }
        for (; ; ) {
            paramhf.e();
            return;
            b(paramObject, paramhf, paramjw);
        }
    }

    public String toString() {
        return "BeanSerializer for " + c().getName();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/oj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */