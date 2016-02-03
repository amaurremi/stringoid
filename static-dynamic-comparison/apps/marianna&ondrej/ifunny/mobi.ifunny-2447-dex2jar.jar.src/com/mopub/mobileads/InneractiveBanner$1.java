package com.mopub.mobileads;

import com.inneractive.api.ads.sdk.InneractiveAdView;
import com.inneractive.api.ads.sdk.InneractiveAdView.InneractiveBannerAdListener;
import com.inneractive.api.ads.sdk.InneractiveAdView.InneractiveErrorCode;
import mobi.ifunny.d;

class InneractiveBanner$1
        implements InneractiveAdView.InneractiveBannerAdListener {
    InneractiveBanner$1(InneractiveBanner paramInneractiveBanner, CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener) {
    }

    public void inneractiveAdWillOpenExternalApp(InneractiveAdView paramInneractiveAdView) {
        d.b(InneractiveBanner.access$000(), "inneractiveAdWillOpenExternalApp");
        this.val$bannerListener.onLeaveApplication();
    }

    public void inneractiveBannerClicked(InneractiveAdView paramInneractiveAdView) {
        d.b(InneractiveBanner.access$000(), "inneractiveBannerClicked");
        this.val$bannerListener.onBannerClicked();
    }

    public void inneractiveBannerCollapsed(InneractiveAdView paramInneractiveAdView) {
        d.b(InneractiveBanner.access$000(), "inneractiveBannerCollapsed");
        this.val$bannerListener.onBannerCollapsed();
    }

    public void inneractiveBannerExpanded(InneractiveAdView paramInneractiveAdView) {
        d.b(InneractiveBanner.access$000(), "inneractiveBannerExpanded");
        this.val$bannerListener.onBannerExpanded();
    }

    public void inneractiveBannerFailed(InneractiveAdView paramInneractiveAdView, InneractiveAdView.InneractiveErrorCode paramInneractiveErrorCode) {
        d.b(InneractiveBanner.access$000(), "inneractiveBannerFailed " + paramInneractiveErrorCode);
        switch (InneractiveBanner
        .2.$SwitchMap$com$inneractive$api$ads$sdk$InneractiveAdView$InneractiveErrorCode[paramInneractiveErrorCode.ordinal()])
        {
            default:
                paramInneractiveAdView = MoPubErrorCode.UNSPECIFIED;
        }
        for (; ; ) {
            this.val$bannerListener.onBannerFailed(paramInneractiveAdView);
            return;
            paramInneractiveAdView = MoPubErrorCode.NETWORK_NO_FILL;
            continue;
            paramInneractiveAdView = MoPubErrorCode.NETWORK_INVALID_STATE;
            continue;
            paramInneractiveAdView = MoPubErrorCode.NETWORK_TIMEOUT;
            continue;
            paramInneractiveAdView = MoPubErrorCode.CANCELLED;
            continue;
            paramInneractiveAdView = MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
        }
    }

    public void inneractiveBannerLoaded(InneractiveAdView paramInneractiveAdView) {
        d.b(InneractiveBanner.access$000(), "inneractiveBannerLoaded");
        this.val$bannerListener.onBannerLoaded(paramInneractiveAdView);
    }

    public void inneractiveBannerResized(InneractiveAdView paramInneractiveAdView) {
        d.b(InneractiveBanner.access$000(), "inneractiveBannerResized");
    }

    public void inneractiveDefaultBannerLoaded(InneractiveAdView paramInneractiveAdView) {
        d.b(InneractiveBanner.access$000(), "inneractiveDefaultBannerLoaded");
        this.val$bannerListener.onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
    }

    public void inneractiveInternalBrowserDismissed(InneractiveAdView paramInneractiveAdView) {
        d.b(InneractiveBanner.access$000(), "inneractiveInternalBrowserDismissed");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/InneractiveBanner$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */