package com.inneractive.api.ads.sdk;

final class h$2
        implements Runnable {
    h$2(h paramh) {
    }

    public final void run() {
        InneractiveAdView.Log.v("Inneractive_verbose", "Loading timeout.");
        this.a.a(InneractiveAdView.InneractiveErrorCode.CONNECTION_TIMEOUT);
        this.a.j();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/h$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */