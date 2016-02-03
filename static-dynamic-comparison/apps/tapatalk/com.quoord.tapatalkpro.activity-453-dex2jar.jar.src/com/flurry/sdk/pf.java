package com.flurry.sdk;

public abstract class pf<T>
        extends pw<T> {
    protected pf(Class<T> paramClass) {
        super(paramClass);
    }

    protected pf(Class<?> paramClass, boolean paramBoolean) {
        super(paramClass, paramBoolean);
    }

    public abstract pf<?> a(jz paramjz);

    public pf<?> b(jz paramjz) {
        if (paramjz == null) {
            return this;
        }
        return a(paramjz);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/pf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */