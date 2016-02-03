package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.Id;

import java.util.Collection;

public abstract interface ni<T extends ni<T>> {
    public abstract jy a(iy paramiy, sh paramsh, Collection<nf> paramCollection, is paramis);

    public abstract jz a(ju paramju, sh paramsh, Collection<nf> paramCollection, is paramis);

    public abstract T a(JsonTypeInfo.As paramAs);

    public abstract T a(JsonTypeInfo.Id paramId, nh paramnh);

    public abstract T a(Class<?> paramClass);

    public abstract T a(String paramString);

    public abstract Class<?> a();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */