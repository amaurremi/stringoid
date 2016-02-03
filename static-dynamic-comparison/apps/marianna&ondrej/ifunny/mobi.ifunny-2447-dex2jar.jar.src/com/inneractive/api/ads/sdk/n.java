package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.os.Handler;
import android.view.View;

final class n
        implements a.a {
    public static int a = IAdefines.j;
    private final InneractiveInterstitialView b;
    private boolean c;
    private a d;
    private Context e;
    private IAresponseData f;
    private String g;
    private final Handler h = new Handler();
    private final Runnable i;

    public n(InneractiveInterstitialView paramInneractiveInterstitialView, IAresponseData paramIAresponseData) {
        this.b = paramInneractiveInterstitialView;
        this.e = paramInneractiveInterstitialView.l();
        this.i = new n .1 (this);
        this.g = e.a(this.b, paramIAresponseData.h);
        InneractiveAdView.Log.d("Inneractive_debug", "Try to load interstitial class: " + this.g + ".");
        try {
            this.d = b.a(this.g);
            this.f = paramIAresponseData;
            if (this.f != null) {
                paramInneractiveInterstitialView = paramInneractiveInterstitialView.n();
                if (paramInneractiveInterstitialView != null) {
                    this.f.i = paramInneractiveInterstitialView.m();
                }
            }
            return;
        } catch (Exception localException) {
            for (; ; ) {
                InneractiveAdView.Log.d("Inneractive_debug", "Couldn't load interstitial class: " + this.g + ".");
                this.b.a(InneractiveAdView.InneractiveErrorCode.SDK_INTERNAL_ERROR);
            }
        }
    }

    private void l() {
        this.h.removeCallbacks(this.i);
    }

    private int m() {
        if ((this.b == null) || (this.b.b() == null) || (this.b.b().intValue() < 0)) {
            return a;
        }
        return this.b.b().intValue();
    }

    public final void a() {
        if (this.c) {
        }
        while (this.b == null) {
            return;
        }
        this.b.o();
    }

    public final void a(View paramView) {
        if (this.c) {
        }
        do {
            return;
            l();
        } while (this.b == null);
        this.b.a(InneractiveInterstitialView.InterstitialState.a);
        this.b.d();
    }

    public final void a(InneractiveAdView.InneractiveErrorCode paramInneractiveErrorCode) {
        if (this.c) {
        }
        while (this.b == null) {
            return;
        }
        l();
        InneractiveAdView.InneractiveErrorCode localInneractiveErrorCode = paramInneractiveErrorCode;
        if (paramInneractiveErrorCode == null) {
            localInneractiveErrorCode = InneractiveAdView.InneractiveErrorCode.UNSPECIFIED;
        }
        this.b.a(localInneractiveErrorCode);
    }

    public final void b() {
        if (this.c) {
        }
        while (this.b == null) {
            return;
        }
        this.b.i();
    }

    public final void b(View paramView) {
        if (this.c) {
        }
        do {
            return;
            l();
        } while (this.b == null);
        this.b.a(InneractiveInterstitialView.InterstitialState.a);
        this.b.e();
    }

    public final void c() {
        if (this.c) {
        }
        while (this.b == null) {
            return;
        }
        this.b.j();
    }

    public final void d() {
        if (this.c) {
        }
        while (this.b == null) {
            return;
        }
        this.b.k();
    }

    public final void e() {
        if (this.c) {
        }
        while (this.b == null) {
            return;
        }
        this.b.p();
    }

    public final void f() {
    }

    public final void g() {
    }

    public final void h() {
    }

    final void i() {
        if ((this.c) || (this.d == null)) {
            return;
        }
        if (m() > 0) {
            this.h.postDelayed(this.i, m());
        }
        this.d.a(this.e, this, this.f);
    }

    final void j() {
        if ((this.c) || (this.d == null)) {
            return;
        }
        this.d.a();
    }

    final void k() {
        if (this.d != null) {
            this.d.b();
        }
        this.d = null;
        this.e = null;
        this.f = null;
        this.c = true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */