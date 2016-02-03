package com.inneractive.api.ads.sdk;

import java.util.HashMap;
import java.util.Map;

final class e {
    private static Map a;

    static {
        HashMap localHashMap = new HashMap();
        a = localHashMap;
        localHashMap.put("inneractive_html_banner", "com.inneractive.api.ads.sdk.IAhtmlBanner");
        a.put("inneractive_html_interstitial", "com.inneractive.api.ads.sdk.IAhtmlInterstitial");
        a.put("inneractive_mraid_banner", "com.inneractive.api.ads.sdk.IAelementaryBanner");
        a.put("inneractive_mraid_interstitial", "com.inneractive.api.ads.sdk.IAelementaryInterstitial");
        a.put("millennial_banner", "com.inneractive.api.ads.sdk.IAmillennialBanner");
        a.put("millennial_interstitial", "com.inneractive.api.ads.sdk.IAmillennialInterstitial");
    }

    static String a(InneractiveAdView paramInneractiveAdView, String paramString) {
        if ((paramInneractiveAdView instanceof InneractiveInterstitialView)) {
            return (String) a.get(paramString + "_interstitial");
        }
        return (String) a.get(paramString + "_banner");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */