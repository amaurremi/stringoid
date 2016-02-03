package com.inmobi.monetization.internal;

import com.inmobi.re.container.IMWebView.IMWebViewListener;
import com.inmobi.re.container.mraidimpl.ResizeDimensions;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

class d
        implements IMWebView.IMWebViewListener {
    d(BannerAd paramBannerAd) {
    }

    public void onDismissAdScreen() {
        if (this.a.mAdListener != null) {
            this.a.mAdListener.onDismissAdScreen();
        }
        BannerAd.b(this.a).set(false);
    }

    public void onDisplayFailed() {
    }

    public void onError() {
        if (this.a.mAdListener != null) {
            this.a.mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
        }
    }

    public void onExpand() {
        if (this.a.mAdListener != null) {
            this.a.mAdListener.onShowAdScreen();
        }
    }

    public void onExpandClose() {
        if (this.a.mAdListener != null) {
            this.a.mAdListener.onDismissAdScreen();
        }
    }

    public void onIncentCompleted(Map<Object, Object> paramMap) {
    }

    public void onLeaveApplication() {
        if (this.a.mAdListener != null) {
            this.a.mAdListener.onLeaveApplication();
        }
    }

    public void onResize(ResizeDimensions paramResizeDimensions) {
        if (this.a.mAdListener != null) {
            this.a.mAdListener.onShowAdScreen();
        }
    }

    public void onResizeClose() {
        if (this.a.mAdListener != null) {
            this.a.mAdListener.onDismissAdScreen();
        }
    }

    public void onShowAdScreen() {
        if (this.a.mAdListener != null) {
            this.a.mAdListener.onShowAdScreen();
        }
        BannerAd.b(this.a).set(true);
    }

    public void onUserInteraction(Map<String, String> paramMap) {
        if (this.a.mAdListener != null) {
            this.a.mAdListener.onAdInteraction(paramMap);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */