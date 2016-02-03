package com.mopub.mobileads;

class HtmlBannerWebView$HtmlBannerWebViewListener
        implements HtmlWebViewListener {
    private final CustomEventBanner.CustomEventBannerListener mCustomEventBannerListener;

    public HtmlBannerWebView$HtmlBannerWebViewListener(CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener) {
        this.mCustomEventBannerListener = paramCustomEventBannerListener;
    }

    public void onClicked() {
        this.mCustomEventBannerListener.onBannerClicked();
    }

    public void onCollapsed() {
        this.mCustomEventBannerListener.onBannerCollapsed();
    }

    public void onFailed(MoPubErrorCode paramMoPubErrorCode) {
        this.mCustomEventBannerListener.onBannerFailed(paramMoPubErrorCode);
    }

    public void onLoaded(BaseHtmlWebView paramBaseHtmlWebView) {
        this.mCustomEventBannerListener.onBannerLoaded(paramBaseHtmlWebView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/HtmlBannerWebView$HtmlBannerWebViewListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */