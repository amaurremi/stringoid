package com.mopub.mobileads;

class HtmlInterstitialWebView$1
        implements HtmlInterstitialWebView.MoPubUriJavascriptFireFinishLoadListener {
    HtmlInterstitialWebView$1(HtmlInterstitialWebView paramHtmlInterstitialWebView, CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener) {
    }

    public void onInterstitialLoaded() {
        if (!this.this$0.mIsDestroyed) {
            this.val$customEventInterstitialListener.onInterstitialLoaded();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/HtmlInterstitialWebView$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */