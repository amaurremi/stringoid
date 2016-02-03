package com.a.a;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class e
        implements Animation.AnimationListener {
    private final a a;

    private e(a parama) {
        this.a = parama;
    }

    public void onAnimationEnd(Animation paramAnimation) {
        paramAnimation = this.a.e();
        if (this.a.h()) {
            ViewGroup localViewGroup = (ViewGroup) paramAnimation.getParent();
            if (localViewGroup != null) {
                localViewGroup.post(new f(this, localViewGroup, paramAnimation));
            }
            return;
        }
        paramAnimation.setVisibility(8);
    }

    public void onAnimationRepeat(Animation paramAnimation) {
    }

    public void onAnimationStart(Animation paramAnimation) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */