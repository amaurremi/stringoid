package com.mopub.mobileads;

public class AdTypeTranslator {
    static String getAdNetworkType(String paramString1, String paramString2) {
        if ("interstitial".equals(paramString1)) {
        }
        while (paramString2 != null) {
            return paramString2;
            paramString2 = paramString1;
        }
        return "unknown";
    }

    static String getCustomEventNameForAdType(MoPubView paramMoPubView, String paramString1, String paramString2) {
        if (("html".equals(paramString1)) || ("mraid".equals(paramString1))) {
            if (isInterstitial(paramMoPubView)) {
                paramMoPubView = AdTypeTranslator.CustomEventType.access$000(paramString1 + "_interstitial");
            }
        }
        for (; ; ) {
            return paramMoPubView.toString();
            paramMoPubView = AdTypeTranslator.CustomEventType.access$000(paramString1 + "_banner");
            continue;
            if ("interstitial".equals(paramString1)) {
                paramMoPubView = AdTypeTranslator.CustomEventType.access$000(paramString2 + "_interstitial");
            } else {
                paramMoPubView = AdTypeTranslator.CustomEventType.access$000(paramString1 + "_banner");
            }
        }
    }

    private static boolean isInterstitial(MoPubView paramMoPubView) {
        return paramMoPubView instanceof MoPubInterstitial.MoPubInterstitialView;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/AdTypeTranslator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */