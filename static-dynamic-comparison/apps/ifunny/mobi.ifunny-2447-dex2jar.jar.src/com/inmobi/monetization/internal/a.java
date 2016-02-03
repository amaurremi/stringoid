package com.inmobi.monetization.internal;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import com.inmobi.commons.AnimationType;
import com.inmobi.monetization.internal.anim.Rotate3dAnimation;
import com.inmobi.monetization.internal.anim.Rotate3dAnimationVert;

class a {
    private BannerAd a;
    private Animation.AnimationListener b;

    public a(BannerAd paramBannerAd, Animation.AnimationListener paramAnimationListener) {
        this.a = paramBannerAd;
        this.b = paramAnimationListener;
    }

    public void a(AnimationType paramAnimationType) {
        Object localObject;
        if (paramAnimationType == AnimationType.ANIMATION_ALPHA) {
            paramAnimationType = new AlphaAnimation(0.0F, 0.5F);
            localObject = new AlphaAnimation(0.5F, 1.0F);
            paramAnimationType.setDuration(1000L);
            paramAnimationType.setFillAfter(false);
            paramAnimationType.setAnimationListener(this.b);
            paramAnimationType.setInterpolator(new DecelerateInterpolator());
            ((AlphaAnimation) localObject).setDuration(500L);
            ((AlphaAnimation) localObject).setFillAfter(false);
            ((AlphaAnimation) localObject).setAnimationListener(this.b);
            ((AlphaAnimation) localObject).setInterpolator(new DecelerateInterpolator());
            this.a.a(paramAnimationType);
            this.a.b((Animation) localObject);
        }
        for (; ; ) {
            this.a.c(this.a.a());
            return;
            if (paramAnimationType == AnimationType.ROTATE_HORIZONTAL_AXIS) {
                paramAnimationType = new Rotate3dAnimation(0.0F, 90.0F, this.a.b() / 2.0F, this.a.c() / 2.0F, 0.0F, true);
                localObject = new Rotate3dAnimation(270.0F, 360.0F, this.a.b() / 2.0F, this.a.c() / 2.0F, 0.0F, true);
                paramAnimationType.setDuration(500L);
                paramAnimationType.setFillAfter(false);
                paramAnimationType.setAnimationListener(this.b);
                paramAnimationType.setInterpolator(new AccelerateInterpolator());
                ((Rotate3dAnimation) localObject).setDuration(500L);
                ((Rotate3dAnimation) localObject).setFillAfter(false);
                ((Rotate3dAnimation) localObject).setAnimationListener(this.b);
                ((Rotate3dAnimation) localObject).setInterpolator(new DecelerateInterpolator());
                this.a.a(paramAnimationType);
                this.a.b((Animation) localObject);
            } else if (paramAnimationType == AnimationType.ROTATE_VERTICAL_AXIS) {
                paramAnimationType = new Rotate3dAnimationVert(0.0F, 90.0F, this.a.b() / 2.0F, this.a.c() / 2.0F, 0.0F, true);
                localObject = new Rotate3dAnimationVert(270.0F, 360.0F, this.a.b() / 2.0F, this.a.c() / 2.0F, 0.0F, true);
                paramAnimationType.setDuration(500L);
                paramAnimationType.setFillAfter(false);
                paramAnimationType.setAnimationListener(this.b);
                paramAnimationType.setInterpolator(new AccelerateInterpolator());
                ((Rotate3dAnimationVert) localObject).setDuration(500L);
                ((Rotate3dAnimationVert) localObject).setFillAfter(false);
                ((Rotate3dAnimationVert) localObject).setAnimationListener(this.b);
                ((Rotate3dAnimationVert) localObject).setInterpolator(new DecelerateInterpolator());
                this.a.a(paramAnimationType);
                this.a.b((Animation) localObject);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */