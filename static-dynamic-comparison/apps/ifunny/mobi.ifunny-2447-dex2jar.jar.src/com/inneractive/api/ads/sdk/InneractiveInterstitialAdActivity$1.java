package com.inneractive.api.ads.sdk;

final class InneractiveInterstitialAdActivity$1
        extends V {
    public final void onFailure(IAbaseWebView paramIAbaseWebView, InneractiveAdView.InneractiveErrorCode paramInneractiveErrorCode) {
        InneractiveInterstitialAdActivity.mAdInterfaceListener.a(paramInneractiveErrorCode);
    }

    public final void onReady(IAbaseWebView paramIAbaseWebView) {
        if ((InneractiveInterstitialAdActivity.adConfiguration != null) && ("House Ad".equals(InneractiveInterstitialAdActivity.adConfiguration.y()))) {
            InneractiveInterstitialAdActivity.mAdInterfaceListener.b(paramIAbaseWebView);
            return;
        }
        InneractiveInterstitialAdActivity.mAdInterfaceListener.a(paramIAbaseWebView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/InneractiveInterstitialAdActivity$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */