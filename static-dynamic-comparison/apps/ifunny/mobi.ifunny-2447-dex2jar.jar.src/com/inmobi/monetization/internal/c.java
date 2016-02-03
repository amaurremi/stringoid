package com.inmobi.monetization.internal;

import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.IMWebView.IMWebViewListener;
import com.inmobi.re.container.mraidimpl.ResizeDimensions;

import java.util.Map;

class c
        implements IMWebView.IMWebViewListener {
    c(InterstitialAd paramInterstitialAd) {
    }

    public void onDismissAdScreen() {
        if (this.a.mAdListener != null) {
            this.a.mAdListener.onDismissAdScreen();
        }
    }

    public void onDisplayFailed() {
        InterstitialAd.f(this.a);
    }

    public void onError() {
        Log.debug("[InMobi]-[Monetization]", "Error loading the interstitial ad ");
        InterstitialAd.e(this.a).removeMessages(301);
        InterstitialAd.a(this.a, null);
        if (this.a.mAdListener != null) {
            this.a.mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
        }
    }

    public void onExpand() {
    }

    public void onExpandClose() {
    }

    public void onIncentCompleted(Map<Object, Object> paramMap) {
        if (this.a.mAdListener != null) {
            this.a.mAdListener.onIncentCompleted(paramMap);
        }
    }

    public void onLeaveApplication() {
        if (this.a.mAdListener != null) {
            this.a.mAdListener.onLeaveApplication();
        }
    }

    public void onResize(ResizeDimensions paramResizeDimensions) {
    }

    public void onResizeClose() {
    }

    public void onShowAdScreen() {
        if (this.a.mAdListener != null) {
            this.a.mAdListener.onShowAdScreen();
        }
    }

    public void onUserInteraction(Map<String, String> paramMap) {
        if (this.a.mAdListener != null) {
            this.a.mAdListener.onAdInteraction(paramMap);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */