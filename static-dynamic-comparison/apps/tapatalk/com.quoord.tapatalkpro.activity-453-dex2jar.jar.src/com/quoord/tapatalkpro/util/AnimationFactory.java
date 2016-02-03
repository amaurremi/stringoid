package com.quoord.tapatalkpro.util;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewPropertyAnimator;

@TargetApi(12)
public class AnimationFactory {
    public static void doCards(View paramView, int paramInt1, int paramInt2) {
        paramView.setScaleX(0.5F);
        if (paramInt1 > paramInt2) {
            paramView.setRotationX(90.0F);
        }
        for (; ; ) {
            paramView.animate().rotationX(0.0F).scaleX(1.0F).start();
            return;
            paramView.setRotationX(-90.0F);
        }
    }

    public static void doCurl(View paramView, int paramInt1, int paramInt2, int paramInt3) {
        paramView.setScaleX(0.5F);
        if (paramInt1 > paramInt2) {
            paramView.setRotation(90.0F);
            paramView.setX(-paramInt3);
        }
        for (; ; ) {
            paramView.animate().rotation(0.0F).x(0.0F).scaleX(1.0F).start();
            return;
            paramView.setRotation(-90.0F);
            paramView.setX(paramInt3);
        }
    }

    public static void doFade(View paramView) {
        paramView.setAlpha(0.0F);
        paramView.animate().alpha(1.0F).start();
    }

    public static void doFlip(View paramView, int paramInt1, int paramInt2) {
        paramView.setScaleX(0.5F);
        if (paramInt1 > paramInt2) {
            paramView.setRotationX(-90.0F);
        }
        for (; ; ) {
            paramView.animate().rotationX(0.0F).scaleX(1.0F).start();
            return;
            paramView.setRotationX(90.0F);
        }
    }

    public static void doFly(View paramView, int paramInt1, int paramInt2) {
        paramView.setScaleX(0.5F);
        if (paramInt1 > paramInt2) {
            paramView.setRotationX(-180.0F);
        }
        for (; ; ) {
            paramView.animate().rotationX(0.0F).scaleX(1.0F).start();
            return;
            paramView.setRotationX(180.0F);
        }
    }

    public static void doGrow(View paramView) {
        paramView.setScaleY(0.0F);
        paramView.setScaleX(0.0F);
        paramView.animate().scaleY(1.0F).scaleX(1.0F).start();
    }

    public static void doReverseFly(View paramView, int paramInt1, int paramInt2) {
        paramView.setScaleX(0.5F);
        if (paramInt1 > paramInt2) {
            paramView.setRotationX(180.0F);
        }
        for (; ; ) {
            paramView.animate().rotationX(0.0F).scaleX(1.0F).start();
            return;
            paramView.setRotationX(-180.0F);
        }
    }

    public static void doTwirl(View paramView, int paramInt1, int paramInt2) {
        paramView.setScaleX(0.5F);
        if (paramInt1 > paramInt2) {
            paramView.setRotationX(-90.0F);
            paramView.setRotationY(-90.0F);
        }
        for (; ; ) {
            paramView.animate().rotationX(0.0F).rotationY(0.0F).scaleX(1.0F).start();
            return;
            paramView.setRotationX(90.0F);
            paramView.setRotationY(-90.0F);
        }
    }

    public static void doWave(View paramView, int paramInt) {
        paramView.setX(-paramInt);
        paramView.animate().x(0.0F).start();
    }

    public static void doZipper(View paramView, int paramInt1, int paramInt2) {
        paramView.setScaleX(0.5F);
        if (paramInt1 % 2 == 0) {
            paramView.setX(-paramInt2);
        }
        for (; ; ) {
            paramView.animate().x(0.0F).scaleX(1.0F).start();
            return;
            paramView.setX(paramInt2);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/AnimationFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */