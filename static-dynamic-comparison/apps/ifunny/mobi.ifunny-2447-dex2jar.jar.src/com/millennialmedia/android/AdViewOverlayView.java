package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import java.lang.ref.WeakReference;

class AdViewOverlayView
        extends MMLayout {
    OverlaySettings a;
    WeakReference<AdViewOverlayActivity> b;
    AdViewOverlayView.CloseTopDrawable c;
    private Button d;
    private boolean e;
    private ProgressBar f;

    AdViewOverlayView(AdViewOverlayActivity paramAdViewOverlayActivity, OverlaySettings paramOverlaySettings) {
        super(paramAdViewOverlayActivity.c);
        this.b = new WeakReference(paramAdViewOverlayActivity);
        this.h = new AdViewOverlayView.AdViewOverlayViewMMAdImpl(this, paramAdViewOverlayActivity.c);
        setId(15062);
        this.h.f = "i";
        this.a = paramOverlaySettings;
        paramOverlaySettings = null;
        Object localObject;
        if ((paramAdViewOverlayActivity.c instanceof Activity)) {
            paramOverlaySettings = (AdViewOverlayView.NonConfigurationInstance) paramAdViewOverlayActivity.c.getLastNonConfigurationInstance();
            if (paramOverlaySettings != null) {
                this.e = paramOverlaySettings.a;
                this.h.k = paramOverlaySettings.b;
                this.a = paramOverlaySettings.c;
                if ((this.h != null) && (this.h.k != null) && (this.h.k.b != null)) {
                    addView(this.h.k.b);
                }
                MMLog.b("AdViewOverlayView", "Restoring configurationinstance w/ controller= " + paramOverlaySettings.b);
            }
        } else {
            float f1 = paramAdViewOverlayActivity.c.getResources().getDisplayMetrics().density;
            if ((this.a.e == 0) || (this.a.f == 0)) {
                break label545;
            }
            localObject = new RelativeLayout.LayoutParams((int) (this.a.f * f1), (int) (this.a.e * f1));
            label247:
            ((RelativeLayout.LayoutParams) localObject).addRule(13);
            setLayoutParams((ViewGroup.LayoutParams) localObject);
            localObject = Integer.valueOf((int) (0.0625F * f1 * this.a.b));
            setPadding(((Integer) localObject).intValue(), ((Integer) localObject).intValue(), ((Integer) localObject).intValue(), ((Integer) localObject).intValue());
            this.d = a(paramAdViewOverlayActivity.c, f1);
            if ((this.a.b()) && (!this.a.d())) {
                this.h.n = this.a.n;
            }
            MMAdImplController.b(this.h);
            if (this.d != null) {
                addView(this.d);
            }
            if ((!this.e) && (!this.a.b()) && (!this.a.c())) {
                s();
            }
            if (!this.a.i()) {
                break label559;
            }
            if ((this.h != null) && (this.h.k != null) && (this.h.k.b != null)) {
                this.h.k.b.setBackgroundColor(0);
            }
            setBackgroundColor(0);
        }
        for (; ; ) {
            if ((this.a.j()) && (this.h != null) && (this.h.k != null) && (this.h.k.b != null)) {
                this.h.k.b.c();
            }
            if (paramOverlaySettings == null) {
                t();
            }
            a(this.a.h());
            return;
            MMLog.b("AdViewOverlayView", "Null configurationinstance ");
            break;
            label545:
            localObject = new RelativeLayout.LayoutParams(-1, -1);
            break label247;
            label559:
            if ((this.h != null) && (this.h.k != null) && (this.h.k.b != null)) {
                this.h.k.b.setBackgroundColor(-1);
            }
            setBackgroundColor(-1);
        }
    }

    private Button a(Context paramContext, float paramFloat) {
        paramContext = new Button(paramContext);
        paramContext.setId(301);
        paramContext.setContentDescription("mraidCloseButton");
        this.c = new AdViewOverlayView.CloseTopDrawable(true, paramFloat);
        paramContext.setOnClickListener(new AdViewOverlayView .1 (this));
        RelativeLayout.LayoutParams localLayoutParams = a(paramFloat);
        paramContext.setLayoutParams(localLayoutParams);
        paramContext.post(new AdViewOverlayView.SetCloseButtonTouchDelegateRunnable(paramContext, localLayoutParams.topMargin, localLayoutParams.leftMargin, localLayoutParams.bottomMargin, localLayoutParams.rightMargin));
        return paramContext;
    }

    private RelativeLayout.LayoutParams a(float paramFloat) {
        int i = (int) (50.0F * paramFloat + 0.5F);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(10);
        return localLayoutParams;
    }

    private void s() {
        Object localObject = (AdViewOverlayActivity) this.b.get();
        if (localObject != null) {
            this.f = new ProgressBar(((AdViewOverlayActivity) localObject).c);
            this.f.setIndeterminate(true);
            this.f.setVisibility(0);
            localObject = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams) localObject).addRule(13);
            addView(this.f, (ViewGroup.LayoutParams) localObject);
        }
    }

    private void t() {
        Object localObject;
        if (this.a.g().equals("slideup")) {
            localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
            MMLog.a("AdViewOverlayView", "Translate up");
        }
        for (; ; ) {
            ((Animation) localObject).setDuration(this.a.f());
            startAnimation((Animation) localObject);
            do {
                return;
                if (this.a.g().equals("slidedown")) {
                    localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
                    MMLog.a("AdViewOverlayView", "Translate down");
                    break;
                }
            } while (!this.a.g().equals("explode"));
            localObject = new ScaleAnimation(1.1F, 0.9F, 0.1F, 0.9F, 1, 0.5F, 1, 0.5F);
            MMLog.a("AdViewOverlayView", "Explode");
        }
    }

    private void u() {
        if ((!this.e) && (this.f != null)) {
            this.e = true;
            this.f.setVisibility(8);
            removeView(this.f);
            this.f = null;
        }
    }

    Object a() {
        AdViewOverlayView.NonConfigurationInstance localNonConfigurationInstance = new AdViewOverlayView.NonConfigurationInstance(null);
        if (this.h != null) {
            MMLog.b("AdViewOverlayView", "Saving getNonConfigurationInstance for " + this.h);
            if ((this.h.k != null) && (this.h.k.b != null)) {
                this.h.k.b.v();
            }
            localNonConfigurationInstance.b = this.h.k;
        }
        localNonConfigurationInstance.a = this.e;
        localNonConfigurationInstance.c = this.a;
        return localNonConfigurationInstance;
    }

    void a(String paramString) {
        new AdViewOverlayView.FetchWebViewContentTask(this, paramString).execute(new Void[0]);
    }

    void a(boolean paramBoolean) {
        this.a.a(paramBoolean);
        Button localButton = this.d;
        if (paramBoolean) {
        }
        for (Object localObject = null; ; localObject = this.c) {
            localButton.setBackgroundDrawable((Drawable) localObject);
            return;
        }
    }

    void b() {
        post(new AdViewOverlayView .2 (this));
    }

    void c() {
        MMLog.b("AdViewOverlayView", "Ad overlay closed");
        if ((Activity) getContext() == null) {
            return;
        }
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        localAlphaAnimation.setAnimationListener(new AdViewOverlayView.AnimationListener(this));
        localAlphaAnimation.setFillEnabled(true);
        localAlphaAnimation.setFillBefore(true);
        localAlphaAnimation.setFillAfter(true);
        localAlphaAnimation.setDuration(400L);
        startAnimation(localAlphaAnimation);
    }

    boolean d() {
        return (this.h != null) && (this.h.n != 0L) && (MMAdImplController.c(this.h));
    }

    void e() {
        super.e();
        f();
    }

    void f() {
        if (this.d != null) {
            this.d.bringToFront();
        }
    }

    void g() {
        removeView(this.l);
        addView(this.l, this.m.getCustomLayoutParams());
        f();
    }

    void h() {
        removeView(this.l);
        addView(this.l, new RelativeLayout.LayoutParams(-1, -1));
        f();
    }

    void i() {
        if ((this.m != null) && (this.l != null)) {
            this.l.setLayoutParams(this.m.getCustomLayoutParams());
            f();
        }
    }

    void j() {
        removeAllViews();
        ViewParent localViewParent = getParent();
        if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
            ((ViewGroup) localViewParent).removeView(this);
        }
    }

    void k() {
        BridgeMMSpeechkit.a();
        if ((this.h != null) && (this.h.k != null) && (this.h.k.b != null)) {
            this.h.k.b.clearFocus();
            this.h.k.b.p();
            if (this.h.f == "i") {
                this.h.k.b.o();
            }
            this.h.k.b.onPauseWebView();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/AdViewOverlayView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */