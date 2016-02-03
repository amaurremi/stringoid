package com.inneractive.api.ads.sdk;

final class IAelementaryBanner$1
        extends V {
    IAelementaryBanner$1(IAelementaryBanner paramIAelementaryBanner) {
    }

    public final void onAdWillOpenExternalApp() {
        this.a.b.c();
    }

    public final void onClicked() {
        this.a.b.b();
    }

    public final void onClose(IAbaseWebView paramIAbaseWebView, IAbaseWebView.IAviewState paramIAviewState) {
        this.a.b.g();
    }

    public final void onExpand(IAbaseWebView paramIAbaseWebView) {
        this.a.b.f();
    }

    public final void onFailure(IAbaseWebView paramIAbaseWebView, InneractiveAdView.InneractiveErrorCode paramInneractiveErrorCode) {
        this.a.b.a(paramInneractiveErrorCode);
    }

    public final void onInternalBrowserDismissed() {
        this.a.b.d();
    }

    public final void onReady(IAbaseWebView paramIAbaseWebView) {
        if ("House Ad".equals(this.a.c)) {
            this.a.b.b(this.a.a);
            return;
        }
        this.a.b.a(this.a.a);
    }

    public final void onResize(IAbaseWebView paramIAbaseWebView) {
        this.a.b.h();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAelementaryBanner$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */