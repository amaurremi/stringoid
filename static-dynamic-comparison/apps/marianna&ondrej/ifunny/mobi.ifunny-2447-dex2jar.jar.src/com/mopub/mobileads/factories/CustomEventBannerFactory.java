package com.mopub.mobileads.factories;

import com.mopub.mobileads.CustomEventBanner;

import java.lang.reflect.Constructor;

public class CustomEventBannerFactory {
    private static CustomEventBannerFactory a = new CustomEventBannerFactory();

    public static CustomEventBanner create(String paramString) {
        return a.a(paramString);
    }

    @Deprecated
    public static void setInstance(CustomEventBannerFactory paramCustomEventBannerFactory) {
        a = paramCustomEventBannerFactory;
    }

    protected CustomEventBanner a(String paramString) {
        paramString = Class.forName(paramString).asSubclass(CustomEventBanner.class).getDeclaredConstructor((Class[]) null);
        paramString.setAccessible(true);
        return (CustomEventBanner) paramString.newInstance(new Object[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/factories/CustomEventBannerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */