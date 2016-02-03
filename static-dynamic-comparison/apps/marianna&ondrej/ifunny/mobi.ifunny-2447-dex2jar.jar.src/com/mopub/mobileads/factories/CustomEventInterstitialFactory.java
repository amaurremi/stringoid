package com.mopub.mobileads.factories;

import com.mopub.mobileads.CustomEventInterstitial;

import java.lang.reflect.Constructor;

public class CustomEventInterstitialFactory {
    private static CustomEventInterstitialFactory a = new CustomEventInterstitialFactory();

    public static CustomEventInterstitial create(String paramString) {
        return a.a(paramString);
    }

    @Deprecated
    public static void setInstance(CustomEventInterstitialFactory paramCustomEventInterstitialFactory) {
        a = paramCustomEventInterstitialFactory;
    }

    protected CustomEventInterstitial a(String paramString) {
        paramString = Class.forName(paramString).asSubclass(CustomEventInterstitial.class).getDeclaredConstructor((Class[]) null);
        paramString.setAccessible(true);
        return (CustomEventInterstitial) paramString.newInstance(new Object[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/factories/CustomEventInterstitialFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */