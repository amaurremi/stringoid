package com.everimaging.fotorsdk.widget.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.everimaging.fotorsdk.R.anim;
import com.everimaging.fotorsdk.R.dimen;
import com.everimaging.fotorsdk.R.drawable;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.PullToRefreshBase.Mode;

@SuppressLint({"ViewConstructor"})
public class c
        extends FrameLayout
        implements Animation.AnimationListener {
    private Animation a;
    private Animation b;
    private ImageView c;
    private final Animation d;
    private final Animation e;

    public c(Context paramContext, PullToRefreshBase.Mode paramMode) {
        super(paramContext);
        this.c = new ImageView(paramContext);
        Drawable localDrawable = getResources().getDrawable(R.drawable.fotor_ptr_indicator_arrow);
        this.c.setImageDrawable(localDrawable);
        int i = getResources().getDimensionPixelSize(R.dimen.fotor_ptr_indicator_internal_padding);
        this.c.setPadding(i, i, i, i);
        addView(this.c);
        int j;
        switch (1. a[paramMode.ordinal()])
        {
            default:
                j = R.anim.fotor_ptr_slide_in_from_top;
                i = R.anim.fotor_ptr_slide_out_to_top;
                setBackgroundResource(R.drawable.fotor_ptr_indicator_bg_top);
        }
        for (; ; ) {
            this.a = AnimationUtils.loadAnimation(paramContext, j);
            this.a.setAnimationListener(this);
            this.b = AnimationUtils.loadAnimation(paramContext, i);
            this.b.setAnimationListener(this);
            paramContext = new LinearInterpolator();
            this.d = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
            this.d.setInterpolator(paramContext);
            this.d.setDuration(150L);
            this.d.setFillAfter(true);
            this.e = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
            this.e.setInterpolator(paramContext);
            this.e.setDuration(150L);
            this.e.setFillAfter(true);
            return;
            j = R.anim.fotor_ptr_slide_in_from_bottom;
            i = R.anim.fotor_ptr_slide_out_to_bottom;
            setBackgroundResource(R.drawable.fotor_ptr_indicator_bg_bottom);
            this.c.setScaleType(ImageView.ScaleType.MATRIX);
            paramMode = new Matrix();
            paramMode.setRotate(180.0F, localDrawable.getIntrinsicWidth() / 2.0F, localDrawable.getIntrinsicHeight() / 2.0F);
            this.c.setImageMatrix(paramMode);
        }
    }

    public final boolean a() {
        Animation localAnimation = getAnimation();
        if (localAnimation != null) {
            if (this.a != localAnimation) {
            }
        }
        while (getVisibility() == 0) {
            return true;
            return false;
        }
        return false;
    }

    public void b() {
        startAnimation(this.b);
    }

    public void c() {
        this.c.clearAnimation();
        startAnimation(this.a);
    }

    public void d() {
        this.c.startAnimation(this.d);
    }

    public void e() {
        this.c.startAnimation(this.e);
    }

    public void onAnimationEnd(Animation paramAnimation) {
        if (paramAnimation == this.b) {
            this.c.clearAnimation();
            setVisibility(8);
        }
        for (; ; ) {
            clearAnimation();
            return;
            if (paramAnimation == this.a) {
                setVisibility(0);
            }
        }
    }

    public void onAnimationRepeat(Animation paramAnimation) {
    }

    public void onAnimationStart(Animation paramAnimation) {
        setVisibility(0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/pulltorefresh/library/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */