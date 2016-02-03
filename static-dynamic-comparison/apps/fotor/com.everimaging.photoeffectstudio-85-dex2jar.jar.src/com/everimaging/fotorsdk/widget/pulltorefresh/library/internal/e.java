package com.everimaging.fotorsdk.widget.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.everimaging.fotorsdk.R.drawable;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.PullToRefreshBase.Mode;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.PullToRefreshBase.Orientation;

public class e
        extends d {
    private final Animation f;
    private final Matrix g;
    private float h;
    private float i;
    private final boolean j;

    public e(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray) {
        super(paramContext, paramMode, paramOrientation, paramTypedArray);
        this.j = paramTypedArray.getBoolean(15, true);
        this.b.setScaleType(ImageView.ScaleType.MATRIX);
        this.g = new Matrix();
        this.b.setImageMatrix(this.g);
        this.f = new RotateAnimation(0.0F, 720.0F, 1, 0.5F, 1, 0.5F);
        this.f.setInterpolator(a);
        this.f.setDuration(1200L);
        this.f.setRepeatCount(-1);
        this.f.setRepeatMode(1);
    }

    private void k() {
        if (this.g != null) {
            this.g.reset();
            this.b.setImageMatrix(this.g);
        }
    }

    protected void a() {
    }

    protected void a(float paramFloat) {
        if (this.j) {
        }
        for (paramFloat = 90.0F * paramFloat; ; paramFloat = Math.max(0.0F, Math.min(180.0F, 360.0F * paramFloat - 180.0F))) {
            this.g.setRotate(paramFloat, this.h, this.i);
            this.b.setImageMatrix(this.g);
            return;
        }
    }

    public void a(Drawable paramDrawable) {
        if (paramDrawable != null) {
            this.h = (paramDrawable.getIntrinsicWidth() / 2.0F);
            this.i = (paramDrawable.getIntrinsicHeight() / 2.0F);
        }
    }

    protected void b() {
        this.b.startAnimation(this.f);
    }

    protected void c() {
    }

    protected void d() {
        this.b.clearAnimation();
        k();
    }

    protected int getDefaultDrawableResId() {
        return R.drawable.fotor_ptr_default_ptr_rotate;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/pulltorefresh/library/internal/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */