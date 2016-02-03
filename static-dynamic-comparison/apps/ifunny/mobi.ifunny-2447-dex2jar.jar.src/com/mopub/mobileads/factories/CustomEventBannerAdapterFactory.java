package com.mopub.mobileads.factories;

import com.mopub.mobileads.CustomEventBannerAdapter;
import com.mopub.mobileads.MoPubView;

public class CustomEventBannerAdapterFactory {
    protected static CustomEventBannerAdapterFactory a = new CustomEventBannerAdapterFactory();

    public static CustomEventBannerAdapter create(MoPubView paramMoPubView, String paramString1, String paramString2) {
        return a.a(paramMoPubView, paramString1, paramString2);
    }

    @Deprecated
    public static void setInstance(CustomEventBannerAdapterFactory paramCustomEventBannerAdapterFactory) {
        a = paramCustomEventBannerAdapterFactory;
    }

    protected CustomEventBannerAdapter a(MoPubView paramMoPubView, String paramString1, String paramString2) {
        return new CustomEventBannerAdapter(paramMoPubView, paramString1, paramString2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/factories/CustomEventBannerAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */