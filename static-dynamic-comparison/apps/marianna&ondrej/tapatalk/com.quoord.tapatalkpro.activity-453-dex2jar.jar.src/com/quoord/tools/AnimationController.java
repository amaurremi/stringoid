package com.quoord.tools;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class AnimationController {
    public final int Accelerate = 1;
    public final int AccelerateDecelerate = 3;
    public final int Anticipate = 6;
    public final int AnticipateOvershoot = 7;
    public final int Bounce = 4;
    public final int Decelerate = 2;
    public final int Default = -1;
    public final int Linear = 0;
    public final int Overshoot = 5;
    public final int rela1 = 1;
    public final int rela2 = 2;

    private void baseIn(View paramView, Animation paramAnimation, long paramLong1, long paramLong2) {
        setEffect(paramAnimation, -1, paramLong1, paramLong2);
        paramView.setVisibility(0);
        paramView.startAnimation(paramAnimation);
    }

    private void baseOut(View paramView, Animation paramAnimation, long paramLong1, long paramLong2) {
        setEffect(paramAnimation, -1, paramLong1, paramLong2);
        paramAnimation.setAnimationListener(new MyAnimationListener(paramView));
        paramView.startAnimation(paramAnimation);
    }

    private void setEffect(Animation paramAnimation, int paramInt, long paramLong1, long paramLong2) {
        switch (paramInt) {
        }
        for (; ; ) {
            paramAnimation.setDuration(paramLong1);
            paramAnimation.setStartOffset(paramLong2);
            return;
            paramAnimation.setInterpolator(new LinearInterpolator());
            continue;
            paramAnimation.setInterpolator(new AccelerateInterpolator());
            continue;
            paramAnimation.setInterpolator(new DecelerateInterpolator());
            continue;
            paramAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            continue;
            paramAnimation.setInterpolator(new BounceInterpolator());
            continue;
            paramAnimation.setInterpolator(new OvershootInterpolator());
            continue;
            paramAnimation.setInterpolator(new AnticipateInterpolator());
            continue;
            paramAnimation.setInterpolator(new AnticipateOvershootInterpolator());
        }
    }

    public void fadeIn(View paramView, long paramLong1, long paramLong2) {
        baseIn(paramView, new AlphaAnimation(0.0F, 1.0F), paramLong1, paramLong2);
    }

    public void fadeOut(View paramView, long paramLong1, long paramLong2) {
        baseOut(paramView, new AlphaAnimation(1.0F, 0.0F), paramLong1, paramLong2);
    }

    public void hide(View paramView) {
        paramView.setVisibility(8);
    }

    public void rotateIn(View paramView, long paramLong1, long paramLong2) {
        baseIn(paramView, new RotateAnimation(-90.0F, 0.0F, 1, 0.0F, 1, 1.0F), paramLong1, paramLong2);
    }

    public void rotateOut(View paramView, long paramLong1, long paramLong2) {
        baseOut(paramView, new RotateAnimation(0.0F, 90.0F, 1, 0.0F, 1, 1.0F), paramLong1, paramLong2);
    }

    public void scaleIn(View paramView, long paramLong1, long paramLong2) {
        baseIn(paramView, new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 2, 0.5F, 2, 0.5F), paramLong1, paramLong2);
    }

    public void scaleOut(View paramView, long paramLong1, long paramLong2) {
        baseOut(paramView, new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 2, 0.5F, 2, 0.5F), paramLong1, paramLong2);
    }

    public void scaleRotateIn(View paramView, long paramLong1, long paramLong2) {
        ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
        RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
        AnimationSet localAnimationSet = new AnimationSet(false);
        localAnimationSet.addAnimation(localScaleAnimation);
        localAnimationSet.addAnimation(localRotateAnimation);
        baseIn(paramView, localAnimationSet, paramLong1, paramLong2);
    }

    public void scaleRotateOut(View paramView, long paramLong1, long paramLong2) {
        ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
        RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
        AnimationSet localAnimationSet = new AnimationSet(false);
        localAnimationSet.addAnimation(localScaleAnimation);
        localAnimationSet.addAnimation(localRotateAnimation);
        baseOut(paramView, localAnimationSet, paramLong1, paramLong2);
    }

    public void show(View paramView) {
        paramView.setVisibility(0);
    }

    public void slideFadeIn(View paramView, long paramLong1, long paramLong2) {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        AnimationSet localAnimationSet = new AnimationSet(false);
        localAnimationSet.addAnimation(localTranslateAnimation);
        localAnimationSet.addAnimation(localAlphaAnimation);
        baseIn(paramView, localAnimationSet, paramLong1, paramLong2);
    }

    public void slideFadeOut(View paramView, long paramLong1, long paramLong2) {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, -1.0F, 2, 0.0F, 2, 0.0F);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        AnimationSet localAnimationSet = new AnimationSet(false);
        localAnimationSet.addAnimation(localTranslateAnimation);
        localAnimationSet.addAnimation(localAlphaAnimation);
        baseOut(paramView, localAnimationSet, paramLong1, paramLong2);
    }

    public void slideIn(View paramView, long paramLong1, long paramLong2) {
        baseIn(paramView, new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F), paramLong1, paramLong2);
    }

    public void slideOut(View paramView, long paramLong1, long paramLong2) {
        baseOut(paramView, new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 0.0F, 2, 1.0F), paramLong1, paramLong2);
    }

    public void transparent(View paramView) {
        paramView.setVisibility(4);
    }

    private class MyAnimationListener
            implements Animation.AnimationListener {
        private View view;

        public MyAnimationListener(View paramView) {
            this.view = paramView;
        }

        public void onAnimationEnd(Animation paramAnimation) {
            this.view.setVisibility(8);
        }

        public void onAnimationRepeat(Animation paramAnimation) {
        }

        public void onAnimationStart(Animation paramAnimation) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/AnimationController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */