package com.inneractive.api.ads.sdk;

public class InneractiveAdView$Timeout {
    public static int getConnectionTimeout() {
        return IAnetworkFetcher.a;
    }

    public static int getLoadingTimeout() {
        return h.a;
    }

    public static int getSocketTimeout() {
        return IAnetworkFetcher.b;
    }

    public static void setConnectionTimeout(int paramInt) {
        if (paramInt < IAdefines.h) {
            IAnetworkFetcher.a = IAdefines.h;
            InneractiveAdView.Log.i("Inneractive_info", "Cannot set " + Integer.toString(paramInt) + " milliseconds as a connection timeout. Minimum timeout value is " + Integer.toString(IAdefines.h) + " milliseconds. Using the minimum timeout(" + Integer.toString(IAdefines.h) + " milliseconds).");
            return;
        }
        if (paramInt > IAdefines.m) {
            IAnetworkFetcher.a = IAdefines.m;
            InneractiveAdView.Log.i("Inneractive_info", "Cannot set " + paramInt + " milliseconds as a connection timeout. Maximum timeout value is " + IAdefines.m + " milliseconds. Using the maximum timeout (" + IAdefines.m + " milliseconds).");
            return;
        }
        IAnetworkFetcher.a = paramInt;
        InneractiveAdView.Log.i("Inneractive_info", "Connection timeout configured to be " + paramInt + " milliseconds.");
    }

    public static void setLoadingTimeout(int paramInt) {
        if (paramInt < IAdefines.i) {
            h.a = IAdefines.i;
            InneractiveAdView.Log.i("Inneractive_info", "Cannot set " + paramInt + " milliseconds as a loading timeout. Minimum timeout value is " + IAdefines.i + " milliseconds. Using the minimum timeout(" + IAdefines.i + " milliseconds).");
            return;
        }
        if (paramInt > IAdefines.k) {
            h.a = IAdefines.k;
            InneractiveAdView.Log.i("Inneractive_info", "Cannot set " + paramInt + " milliseconds as a loading timeout. Maximum timeout value is " + IAdefines.k + " milliseconds. Using the maximum timeout (" + IAdefines.k + " milliseconds).");
            return;
        }
        h.a = paramInt;
        InneractiveAdView.Log.i("Inneractive_info", "Loading timeout configured to be " + paramInt + " milliseconds.");
    }

    public static void setSocketTimeout(int paramInt) {
        if (paramInt < IAdefines.g) {
            IAnetworkFetcher.b = IAdefines.g;
            InneractiveAdView.Log.i("Inneractive_info", "Cannot set " + paramInt + " milliseconds as a socket timeout. Minimum timeout value is " + IAdefines.g + " milliseconds. Using the minimum timeout(" + IAdefines.g + " milliseconds).");
            return;
        }
        if (paramInt > IAdefines.l) {
            IAnetworkFetcher.b = IAdefines.l;
            InneractiveAdView.Log.i("Inneractive_info", "Cannot set " + Integer.toString(paramInt) + " milliseconds as a socket timeout. Maximum timeout value is " + IAdefines.l + " milliseconds. Using the maximum timeout (" + IAdefines.l + " milliseconds).");
            return;
        }
        IAnetworkFetcher.b = paramInt;
        InneractiveAdView.Log.i("Inneractive_info", "Socket timeout configured to be " + paramInt + " milliseconds.");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/InneractiveAdView$Timeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */