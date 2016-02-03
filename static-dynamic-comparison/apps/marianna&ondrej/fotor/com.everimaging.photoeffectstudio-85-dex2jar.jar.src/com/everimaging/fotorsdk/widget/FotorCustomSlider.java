package com.everimaging.fotorsdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;
import com.everimaging.fotorsdk.R.attr;
import com.everimaging.fotorsdk.R.styleable;
import com.everimaging.fotorsdk.utils.DeviceUtils;

public class FotorCustomSlider
        extends SeekBar {
    private float a;
    private float b;
    private float c;
    private int d;
    private int e;
    private int f;

    public FotorCustomSlider(Context paramContext) {
        super(paramContext);
        setAdjustYDistance(0);
        a();
    }

    public FotorCustomSlider(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, R.attr.fotorDefaultSliderStyle);
    }

    public FotorCustomSlider(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FotorCustomSlider, paramInt, 0);
        setAdjustYDistance(paramContext.getInt(0, 0));
        paramContext.recycle();
        a();
    }

    private void a() {
    }

    public void invalidate(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        invalidate();
    }

    public void invalidate(Rect paramRect) {
        invalidate();
    }

    protected void onDraw(Canvas paramCanvas) {
        try {
            Object localObject = getProgressDrawable();
            if ((localObject instanceof LayerDrawable)) {
                localObject = (LayerDrawable) localObject;
                Drawable localDrawable = ((LayerDrawable) localObject).findDrawableByLayerId(16908301);
                ((LayerDrawable) localObject).setBounds(0, 0, this.e, this.f);
                localDrawable.setBounds(0, 0, this.e, this.f);
            }
            super.onDraw(paramCanvas);
            return;
        } finally {
        }
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        this.e = (getWidth() - getPaddingRight() - getPaddingLeft());
        this.f = (getHeight() - getPaddingBottom() - getPaddingTop());
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        switch (paramMotionEvent.getAction()) {
        }
        for (; ; ) {
            return super.onTouchEvent(paramMotionEvent);
            this.b = paramMotionEvent.getRawX();
            this.a = this.b;
            this.c = paramMotionEvent.getRawY();
            continue;
            float f3 = paramMotionEvent.getRawX();
            float f2 = Math.abs(paramMotionEvent.getRawY() - this.c);
            float f1 = f2;
            if (f2 > this.d) {
                f1 = this.d;
            }
            f2 = 1.0F - f1 / this.d;
            f1 = f2;
            if (f2 < 0.1F) {
                f1 = 0.1F;
            }
            this.a = (f1 * (f3 - this.b) + this.a);
            this.b = f3;
            paramMotionEvent.offsetLocation(this.a - this.b, 0.0F);
        }
    }

    public void setAdjustYDistance(int paramInt) {
        int i = paramInt;
        if (paramInt == 0) {
            i = DeviceUtils.getScreenHeight();
        }
        this.d = i;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/FotorCustomSlider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */