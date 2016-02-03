package com.flurry.sdk;

public final class rd<T> {
    final T a;
    final rd<T> b;

    public rd<T> a() {
        return this.b;
    }

    public T b() {
        return (T) this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/rd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */