package com.inneractive.api.ads.sdk;

final class n$1
        implements Runnable {
    n$1(n paramn) {
    }

    public final void run() {
        InneractiveAdView.Log.d("Inneractive_debug", "Loading timeout.");
        this.a.a(InneractiveAdView.InneractiveErrorCode.CONNECTION_TIMEOUT);
        this.a.k();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/n$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */