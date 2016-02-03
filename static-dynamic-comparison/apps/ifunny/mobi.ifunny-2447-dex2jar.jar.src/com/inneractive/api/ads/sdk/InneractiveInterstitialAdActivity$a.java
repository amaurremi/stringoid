package com.inneractive.api.ads.sdk;

import android.webkit.JavascriptInterface;

final class InneractiveInterstitialAdActivity$a {
    InneractiveInterstitialAdActivity$a(InneractiveInterstitialAdActivity paramInneractiveInterstitialAdActivity) {
    }

    @JavascriptInterface
    public final void closeVastAdActivity(String paramString) {
        if (InneractiveInterstitialAdActivity.isVastCompleted) {
            InneractiveAdView.Log.v("Inneractive_verbose", "finish activity!");
            this.this$0.finish();
        }
    }

    @JavascriptInterface
    public final void videoCompleted() {
        InneractiveInterstitialAdActivity.isVastCompleted = true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/InneractiveInterstitialAdActivity$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */