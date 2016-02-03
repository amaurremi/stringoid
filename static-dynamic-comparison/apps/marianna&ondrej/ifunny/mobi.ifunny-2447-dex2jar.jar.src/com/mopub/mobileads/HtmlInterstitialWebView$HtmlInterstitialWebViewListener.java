package com.mopub.mobileads;

class HtmlInterstitialWebView$HtmlInterstitialWebViewListener
        implements HtmlWebViewListener {
    private final CustomEventInterstitial.CustomEventInterstitialListener mCustomEventInterstitialListener;

    public HtmlInterstitialWebView$HtmlInterstitialWebViewListener(CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener) {
        this.mCustomEventInterstitialListener = paramCustomEventInterstitialListener;
    }

    public void onClicked() {
        this.mCustomEventInterstitialListener.onInterstitialClicked();
    }

    public void onCollapsed() {
    }

    public void onFailed(MoPubErrorCode paramMoPubErrorCode) {
        this.mCustomEventInterstitialListener.onInterstitialFailed(paramMoPubErrorCode);
    }

    public void onLoaded(BaseHtmlWebView paramBaseHtmlWebView) {
        this.mCustomEventInterstitialListener.onInterstitialLoaded();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/HtmlInterstitialWebView$HtmlInterstitialWebViewListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */