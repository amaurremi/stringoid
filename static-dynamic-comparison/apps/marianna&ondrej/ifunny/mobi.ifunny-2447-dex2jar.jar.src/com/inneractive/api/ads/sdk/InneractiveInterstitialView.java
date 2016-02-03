package com.inneractive.api.ads.sdk;

import android.content.Context;

public class InneractiveInterstitialView
        extends InneractiveAdView {
    private n d;
    private InneractiveInterstitialView.InneractiveInterstitialAdListener e;
    private InneractiveInterstitialView.InterstitialState f;
    private boolean g;

    public InneractiveInterstitialView(Context paramContext, String paramString) {
        super(paramContext, paramString, InneractiveAdView.InternalAdType.c);
        a(false);
        this.f = InneractiveInterstitialView.InterstitialState.b;
    }

    final void a() {
        this.f = InneractiveInterstitialView.InterstitialState.b;
        if (this.d != null) {
            this.d.k();
            this.d = null;
        }
        this.g = false;
        super.a();
    }

    final void a(IAresponseData paramIAresponseData) {
        if (this.a == null) {
            return;
        }
        if (paramIAresponseData == null) {
            InneractiveAdView.Log.d("Inneractive_debug", "failed to load the adapter.");
            a(InneractiveAdView.InneractiveErrorCode.SDK_INTERNAL_ERROR);
            return;
        }
        if (this.d != null) {
            this.d.k();
        }
        InneractiveAdView.Log.d("Inneractive_debug", "Loading adapter for interstitial.");
        this.d = o.a(this, paramIAresponseData);
        this.d.i();
    }

    protected final void a(InneractiveInterstitialView.InterstitialState paramInterstitialState) {
        this.f = paramInterstitialState;
    }

    final Integer b() {
        return super.b();
    }

    protected final void b(InneractiveAdView.InneractiveErrorCode paramInneractiveErrorCode) {
        if (this.g) {
        }
        do {
            return;
            InneractiveAdView.Log.v("Inneractive_verbose", "inneractive Interstitial Ad Faild");
        } while (this.e == null);
        this.e.inneractiveInterstitialFailed(this, paramInneractiveErrorCode);
    }

    protected final void d() {
        if (this.g) {
        }
        do {
            return;
            InneractiveAdView.Log.v("Inneractive_verbose", "inneractive Interstitial Ad Loaded");
        } while (this.e == null);
        this.e.inneractiveInterstitialLoaded(this);
    }

    public void destroy() {
        this.g = true;
        if (this.d != null) {
            this.d.k();
            this.d = null;
        }
        super.setBannerAdListener(null);
        super.destroy();
    }

    protected final void e() {
        if (this.g) {
        }
        do {
            return;
            InneractiveAdView.Log.v("Inneractive_verbose", "inneractive Default Interstitial Ad Loaded");
        } while (this.e == null);
        this.e.inneractiveDefaultInterstitialLoaded(this);
    }

    public InneractiveInterstitialView.InneractiveInterstitialAdListener getInterstitialAdListener() {
        return this.e;
    }

    public String getKeywords() {
        return super.getKeywords();
    }

    protected final void i() {
        if (this.g) {
        }
        do {
            return;
            InneractiveAdView.Log.v("Inneractive_verbose", "inneractive Interstitial Ad Clicked");
            if ((n() != null) && (n().m() != null)) {
                String str = n().m().E();
                if ((str != null) && (!"".equals(str)) && (!"IA".equals(str))) {
                    a(IAdefines.IAIntegratedSdksTrackingAction.b);
                }
            }
        } while (this.e == null);
        this.e.inneractiveInterstitialClicked(this);
    }

    public boolean isReady() {
        return this.f != InneractiveInterstitialView.InterstitialState.b;
    }

    protected final void j() {
        InneractiveAdView.Log.v("Inneractive_verbose", "app is in the background");
        if (this.e != null) {
            this.e.inneractiveAdWillOpenExternalApp(this);
        }
    }

    protected final void k() {
        InneractiveAdView.Log.v("Inneractive_verbose", "intenal Browser Dissmissed");
        if (this.e != null) {
            this.e.inneractiveInternalBrowserDismissed(this);
        }
    }

    final void o() {
        if (this.g) {
            return;
        }
        InneractiveAdView.Log.v("Inneractive_verbose", "inneractive Interstitial Ad Shown");
        c();
        if ((n() != null) && (n().m() != null)) {
            String str = n().m().D();
            if ((str != null) && (!"".equals(str))) {
                a(IAdefines.IAIntegratedSdksTrackingAction.a);
            }
        }
        if (this.e != null) {
            this.e.inneractiveInterstitialShown(this);
        }
        this.f = InneractiveInterstitialView.InterstitialState.b;
    }

    final void p() {
        if (this.g) {
        }
        do {
            return;
            InneractiveAdView.Log.v("Inneractive_verbose", "inneractive Interstitial Ad Dismissed");
            this.f = InneractiveInterstitialView.InterstitialState.b;
        } while (this.e == null);
        this.e.inneractiveInterstitialDismissed(this);
    }

    public void setInterstitialAdListener(InneractiveInterstitialView.InneractiveInterstitialAdListener paramInneractiveInterstitialAdListener) {
        this.e = paramInneractiveInterstitialAdListener;
    }

    public void setKeywords(String paramString) {
        super.setKeywords(paramString);
    }

    public boolean showAd() {
        switch (InneractiveInterstitialView .1.a[this.f.ordinal()])
        {
            default:
                return false;
        }
        if (this.d != null) {
            this.d.j();
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/InneractiveInterstitialView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */