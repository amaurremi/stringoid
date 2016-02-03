package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As;

public class nl
        extends nj {
    protected final String a;

    public nl(sh paramsh, nh paramnh, is paramis, Class<?> paramClass, String paramString) {
        super(paramsh, paramnh, paramis, paramClass);
        this.a = paramString;
    }

    public JsonTypeInfo.As a() {
        return JsonTypeInfo.As.EXTERNAL_PROPERTY;
    }

    public String b() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/nl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */