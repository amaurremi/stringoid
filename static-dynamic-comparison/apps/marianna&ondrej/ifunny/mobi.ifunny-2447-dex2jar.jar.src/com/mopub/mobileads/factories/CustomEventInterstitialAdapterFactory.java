package com.mopub.mobileads.factories;

import com.mopub.mobileads.CustomEventInterstitialAdapter;
import com.mopub.mobileads.MoPubInterstitial;

public class CustomEventInterstitialAdapterFactory {
    protected static CustomEventInterstitialAdapterFactory a = new CustomEventInterstitialAdapterFactory();

    public static CustomEventInterstitialAdapter create(MoPubInterstitial paramMoPubInterstitial, String paramString1, String paramString2) {
        return a.a(paramMoPubInterstitial, paramString1, paramString2);
    }

    @Deprecated
    public static void setInstance(CustomEventInterstitialAdapterFactory paramCustomEventInterstitialAdapterFactory) {
        a = paramCustomEventInterstitialAdapterFactory;
    }

    protected CustomEventInterstitialAdapter a(MoPubInterstitial paramMoPubInterstitial, String paramString1, String paramString2) {
        return new CustomEventInterstitialAdapter(paramMoPubInterstitial, paramString1, paramString2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/factories/CustomEventInterstitialAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */