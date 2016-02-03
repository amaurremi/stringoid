package com.inmobi.monetization.internal;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class e
        implements Animation.AnimationListener {
    e(BannerAd paramBannerAd) {
    }

    public void onAnimationEnd(Animation paramAnimation) {
        BannerAd.g(this.a);
    }

    public void onAnimationRepeat(Animation paramAnimation) {
    }

    public void onAnimationStart(Animation paramAnimation) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */