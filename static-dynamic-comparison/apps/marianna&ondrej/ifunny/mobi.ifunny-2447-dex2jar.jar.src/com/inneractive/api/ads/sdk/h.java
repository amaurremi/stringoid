package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class h
        implements a.a {
    static int a = IAdefines.i;
    Animation b;
    Animation c;
    private boolean d;
    private InneractiveAdView e;
    private Context f;
    private a g;
    private String h;
    private IAresponseData i;
    private final Handler j = new h
    .1(this);
    private final Runnable k;
    private Animation.AnimationListener l;

    h(InneractiveAdView paramInneractiveAdView, IAresponseData paramIAresponseData) {
        this.e = paramInneractiveAdView;
        this.f = paramInneractiveAdView.getContext();
        this.k = new h .2 (this);
        this.h = e.a(this.e, paramIAresponseData.h);
        InneractiveAdView.Log.v("Inneractive_verbose", "Try to load banner class: " + this.h + ".");
        try {
            this.g = b.a(this.h);
            this.i = paramIAresponseData;
            if ((this.i != null) && (this.e.n() != null)) {
                this.i.i = this.e.n().m();
            }
            this.b = new AlphaAnimation(1.0F, 0.0F);
            this.c = new AlphaAnimation(0.0F, 1.0F);
            this.l = new h .3 (this);
            this.c.setAnimationListener(this.l);
            this.b.setAnimationListener(this.l);
            return;
        } catch (Exception paramInneractiveAdView) {
            InneractiveAdView.Log.d("Inneractive_debug", "Couldn't load banner class: " + this.h + ".");
            this.e.a(InneractiveAdView.InneractiveErrorCode.SDK_INTERNAL_ERROR);
        }
    }

    private void k() {
        this.j.removeCallbacks(this.k);
    }

    private int l() {
        if ((this.e == null) || (this.e.b() == null) || (this.e.b().intValue() < 0)) {
            return a;
        }
        return this.e.b().intValue();
    }

    public final void a() {
    }

    public final void a(View paramView) {
        if (this.d) {
        }
        do {
            return;
            k();
        } while ((paramView == null) || (this.e == null));
        this.e.a(paramView);
        this.e.d();
    }

    final void a(Animation paramAnimation) {
        if ((paramAnimation != null) && (this.e != null)) {
            paramAnimation.setDuration(1000L);
            InneractiveAdView.Log.v("Inneractive_verbose", "startCustomAnimation()!!!");
            this.e.startAnimation(paramAnimation);
            return;
        }
        InneractiveAdView.Log.d("Inneractive_debug", "startCustomAnimation(): animation or the view is null!!!");
    }

    public final void a(InneractiveAdView.InneractiveErrorCode paramInneractiveErrorCode) {
        if (this.d) {
        }
        while (this.e == null) {
            return;
        }
        k();
        InneractiveAdView.InneractiveErrorCode localInneractiveErrorCode = paramInneractiveErrorCode;
        if (paramInneractiveErrorCode == null) {
            localInneractiveErrorCode = InneractiveAdView.InneractiveErrorCode.UNSPECIFIED;
        }
        this.e.a(localInneractiveErrorCode);
    }

    public final void b() {
        if (this.d) {
        }
        while (this.e == null) {
            return;
        }
        this.e.i();
    }

    public final void b(View paramView) {
        if (this.d) {
        }
        do {
            return;
            k();
        } while ((paramView == null) || (this.e == null));
        this.e.a(paramView);
        this.e.e();
    }

    public final void c() {
        if (this.d) {
        }
        while (this.e == null) {
            return;
        }
        this.e.j();
    }

    public final void d() {
        if (this.d) {
        }
        while (this.e == null) {
            return;
        }
        this.e.k();
    }

    public final void e() {
    }

    public final void f() {
        if (this.d) {
            return;
        }
        this.e.m();
        this.e.f();
    }

    public final void g() {
        if (this.d) {
            return;
        }
        this.e.g();
    }

    public final void h() {
        if (this.d) {
            return;
        }
        this.e.h();
    }

    final void i() {
        InneractiveAdView.Log.d("Inneractive_debug", "loadAd Called");
        if ((this.d) || (this.g == null)) {
            return;
        }
        if (l() > 0) {
            this.j.postDelayed(this.k, l());
        }
        this.g.a(this.f, this, this.i);
    }

    final void j() {
        if (this.g != null) {
            this.g.b();
        }
        this.f = null;
        this.g = null;
        this.i = null;
        this.d = true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */