package com.inneractive.api.ads.sdk;

public class InneractiveInterstitialView$Timeout
        extends InneractiveAdView.Timeout {
    public static int getLoadingTimeout() {
        return n.a;
    }

    public static void setLoadingTimeout(int paramInt) {
        if (paramInt < IAdefines.j) {
            h.a = IAdefines.j;
            InneractiveInterstitialView.Log.i("Inneractive_info", "Cannot set " + paramInt + " milliseconds as a loading timeout. Minimum timeout value is " + IAdefines.j + " milliseconds. Using the minimum timeout(" + IAdefines.j + " milliseconds).");
            return;
        }
        if (paramInt > IAdefines.k) {
            h.a = IAdefines.k;
            InneractiveInterstitialView.Log.i("Inneractive_info", "Cannot set " + paramInt + " milliseconds as a loading timeout. Maximum timeout value is " + IAdefines.k + " milliseconds. Using the maximum timeout (" + IAdefines.k + " milliseconds).");
            return;
        }
        n.a = paramInt;
        InneractiveInterstitialView.Log.i("Inneractive_info", "Loading timeout configured to be " + paramInt + " milliseconds.");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/InneractiveInterstitialView$Timeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */