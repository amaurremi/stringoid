package com.flurry.sdk;

import java.io.IOException;

@kb
public class ps<T>
        extends pw<T> {
    public ps(Class<?> paramClass) {
        super(paramClass, false);
    }

    public void a(T paramT, hf paramhf, jw paramjw)
            throws IOException, he {
        paramhf.d(paramT.toString());
    }

    public void a(T paramT, hf paramhf, jw paramjw, jz paramjz)
            throws IOException, hk {
        paramjz.a(paramT, paramhf);
        a(paramT, paramhf, paramjw);
        paramjz.d(paramT, paramhf);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */