package com.inneractive.api.ads.sdk;

final class InneractiveInterstitialAdActivity$3
        implements IAmraidWebView.d {
    InneractiveInterstitialAdActivity$3(InneractiveInterstitialAdActivity paramInneractiveInterstitialAdActivity) {
    }

    public final void onCloseButtonStateChange(IAmraidWebView paramIAmraidWebView, boolean paramBoolean) {
        if (paramBoolean) {
            this.this$0.displayInterstitialCloseBtn();
            return;
        }
        this.this$0.concealInterstitialCloseBtn();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/InneractiveInterstitialAdActivity$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */