package com.flurry.sdk;

import java.io.IOException;

public abstract class pt<T>
        extends pw<T> {
    protected pt(Class<T> paramClass) {
        super(paramClass);
    }

    protected pt(Class<?> paramClass, boolean paramBoolean) {
        super(paramClass);
    }

    public void a(T paramT, hf paramhf, jw paramjw, jz paramjz)
            throws IOException, he {
        paramjz.a(paramT, paramhf);
        a(paramT, paramhf, paramjw);
        paramjz.d(paramT, paramhf);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/pt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */