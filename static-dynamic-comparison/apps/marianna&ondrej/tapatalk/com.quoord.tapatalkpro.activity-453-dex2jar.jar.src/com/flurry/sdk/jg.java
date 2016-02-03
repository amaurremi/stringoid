package com.flurry.sdk;

import java.io.IOException;

public abstract class jg<T> {
    public jg<T> a() {
        return this;
    }

    public abstract T a(hj paramhj, iz paramiz)
            throws IOException, hk;

    public Object a(hj paramhj, iz paramiz, jy paramjy)
            throws IOException, hk {
        return paramjy.d(paramhj, paramiz);
    }

    public T a(hj paramhj, iz paramiz, T paramT)
            throws IOException, hk {
        throw new UnsupportedOperationException();
    }

    public T b() {
        return null;
    }

    public T c() {
        return (T) b();
    }

    public static abstract class a
            extends jg<Object> {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/jg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */