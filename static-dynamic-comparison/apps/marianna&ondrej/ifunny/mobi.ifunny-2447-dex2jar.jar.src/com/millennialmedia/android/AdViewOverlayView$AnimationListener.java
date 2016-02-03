package com.millennialmedia.android;

import android.app.Activity;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;

import java.lang.ref.WeakReference;

class AdViewOverlayView$AnimationListener
        implements Animation.AnimationListener {
    private WeakReference<AdViewOverlayView> a;

    public AdViewOverlayView$AnimationListener(AdViewOverlayView paramAdViewOverlayView) {
        this.a = new WeakReference(paramAdViewOverlayView);
    }

    public void onAnimationEnd(Animation paramAnimation) {
        paramAnimation = (AdViewOverlayView) this.a.get();
        if (paramAnimation != null) {
            paramAnimation = (Activity) paramAnimation.getContext();
            MMLog.b("AdViewOverlayView", "Finishing overlay this is in w/ anim finishOverLayWithAnim()");
            paramAnimation.finish();
        }
    }

    public void onAnimationRepeat(Animation paramAnimation) {
    }

    public void onAnimationStart(Animation paramAnimation) {
        paramAnimation = (AdViewOverlayView) this.a.get();
        if ((paramAnimation != null) && (AdViewOverlayView.b(paramAnimation) != null)) {
            AdViewOverlayView.b(paramAnimation).setVisibility(8);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/AdViewOverlayView$AnimationListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */