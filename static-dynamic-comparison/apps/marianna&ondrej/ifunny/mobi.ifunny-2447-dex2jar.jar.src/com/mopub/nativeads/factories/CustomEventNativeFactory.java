package com.mopub.nativeads.factories;

import com.mopub.nativeads.CustomEventNative;
import com.mopub.nativeads.MoPubCustomEventNative;

import java.lang.reflect.Constructor;

public class CustomEventNativeFactory {
    protected static CustomEventNativeFactory a = new CustomEventNativeFactory();

    public static CustomEventNative create(String paramString) {
        if (paramString != null) {
            paramString = Class.forName(paramString).asSubclass(CustomEventNative.class);
            return a.a(paramString);
        }
        return new MoPubCustomEventNative();
    }

    @Deprecated
    public static void setInstance(CustomEventNativeFactory paramCustomEventNativeFactory) {
        a = paramCustomEventNativeFactory;
    }

    protected CustomEventNative a(Class<? extends CustomEventNative> paramClass) {
        paramClass = paramClass.getDeclaredConstructor((Class[]) null);
        paramClass.setAccessible(true);
        return (CustomEventNative) paramClass.newInstance(new Object[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/factories/CustomEventNativeFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */