package com.inmobi.re.container.mraidimpl;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class MRAIDInterstitialController$c
        implements Animation.AnimationListener {
    MRAIDInterstitialController$c(MRAIDInterstitialController paramMRAIDInterstitialController) {
    }

    public void onAnimationEnd(Animation paramAnimation) {
        this.a.dismissWebview();
    }

    public void onAnimationRepeat(Animation paramAnimation) {
    }

    public void onAnimationStart(Animation paramAnimation) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/mraidimpl/MRAIDInterstitialController$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */