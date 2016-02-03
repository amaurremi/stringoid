package com.millennialmedia.android;

import android.content.Context;

class AdViewOverlayView$AdViewOverlayViewMMAdImpl
        extends MMLayout.MMLayoutMMAdImpl {
    public AdViewOverlayView$AdViewOverlayViewMMAdImpl(AdViewOverlayView paramAdViewOverlayView, Context paramContext) {
        super(paramAdViewOverlayView, paramContext);
        this.m = new AdViewOverlayView.OverlayWebViewClientListener(this);
    }

    void a() {
        AdViewOverlayView.a(this.a);
    }

    boolean b() {
        return (this.a.a.d()) && (!this.a.a.e());
    }

    MMWebViewClient c() {
        MMLog.b("AdViewOverlayView", "Returning a client for user: OverlayWebViewClient, adimpl=" + this.a.h);
        if ((this.a.h.n != 0L) || (this.a.a.d())) {
            localObject = new BannerExpandedWebViewClient(this.m, new AdViewOverlayView.OverlayRedirectionListenerImpl(this));
            this.l = ((MMWebViewClient) localObject);
            return (MMWebViewClient) localObject;
        }
        Object localObject = new InterstitialWebViewClient(this.m, new AdViewOverlayView.OverlayRedirectionListenerImpl(this));
        this.l = ((MMWebViewClient) localObject);
        return (MMWebViewClient) localObject;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/AdViewOverlayView$AdViewOverlayViewMMAdImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */