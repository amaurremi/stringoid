package com.mopub.common.factories;

import com.mopub.common.util.Reflection.MethodBuilder;

public class MethodBuilderFactory {
    protected static MethodBuilderFactory a = new MethodBuilderFactory();

    public static Reflection.MethodBuilder create(Object paramObject, String paramString) {
        return a.a(paramObject, paramString);
    }

    @Deprecated
    public static void setInstance(MethodBuilderFactory paramMethodBuilderFactory) {
        a = paramMethodBuilderFactory;
    }

    protected Reflection.MethodBuilder a(Object paramObject, String paramString) {
        return new Reflection.MethodBuilder(paramObject, paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/factories/MethodBuilderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */