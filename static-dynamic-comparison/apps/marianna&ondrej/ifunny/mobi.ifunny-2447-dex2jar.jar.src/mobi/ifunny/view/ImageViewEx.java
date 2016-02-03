package mobi.ifunny.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import mobi.ifunny.gallery.view.f;
import mobi.ifunny.gallery.view.g;
import mobi.ifunny.j;

public class ImageViewEx
        extends ImageView {
    private int a = 0;
    private Drawable b;
    private m c = new m(this, null);
    private boolean d;
    private float e;
    private float f;
    private float g = -1.0F;
    private int h;
    private int i;
    private int j;
    private int k;
    private f l;
    private g m;

    public ImageViewEx(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, j.mobi_ifunny_view_ImageViewEx);
        setForegroundDrawable(paramAttributeSet.getDrawable(4));
        this.d = paramAttributeSet.getBoolean(5, false);
        this.e = paramAttributeSet.getFloat(6, 1.0F);
        this.f = paramAttributeSet.getFloat(7, 2.0F);
        this.a = paramAttributeSet.getInt(8, 0);
        this.h = paramAttributeSet.getDimensionPixelSize(1, 0);
        this.i = paramAttributeSet.getDimensionPixelSize(2, 0);
        this.j = paramAttributeSet.getDimensionPixelSize(3, 0);
        this.k = paramAttributeSet.getDimensionPixelSize(0, 0);
        paramAttributeSet.recycle();
        if (this.d) {
            setScaleType(ImageView.ScaleType.FIT_XY);
        }
        this.m = new g(paramContext, new n(this, null));
    }

    private int a(int paramInt1, int paramInt2, int paramInt3) {
        switch (this.a) {
        }
        do {
            for (; ; ) {
                int n = paramInt3;
                switch (paramInt2) {
                    default:
                        n = paramInt1;
                    case 1073741824:
                        return n;
                    paramInt1 = (int) (paramInt1 * this.e);
                    continue;
                    paramInt1 = (int) (paramInt1 * this.f);
                }
            }
        } while (paramInt3 <= 0);
        for (; ; ) {
            paramInt1 = paramInt3;
        }
        return paramInt1;
        return Math.min(paramInt1, paramInt3);
    }

    private void a() {
        if (this.b == null) {
            return;
        }
        this.b.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if ((this.b != null) && (this.b.isStateful())) {
            this.b.setState(getDrawableState());
            invalidate();
        }
    }

    public Drawable getForegroundDrawable() {
        return this.b;
    }

    public void getHitRect(Rect paramRect) {
        super.getHitRect(paramRect);
        paramRect.set(paramRect.left - this.h, paramRect.top - this.j, paramRect.right + this.i, paramRect.bottom + this.k);
    }

    public float getScale() {
        return this.g;
    }

    public float getUpscaleRatioLimit() {
        return this.f;
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.b != null) {
            this.b.jumpToCurrentState();
        }
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        if (this.b != null) {
            this.b.draw(paramCanvas);
        }
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        int i1 = 1;
        Drawable localDrawable = getDrawable();
        int n;
        int i2;
        int i3;
        float f1;
        float f4;
        float f2;
        label122:
        float f3;
        if ((this.d) && (localDrawable != null)) {
            n = View.MeasureSpec.getMode(paramInt1);
            int i6 = View.MeasureSpec.getSize(paramInt1);
            int i4 = View.MeasureSpec.getMode(paramInt2);
            int i5 = View.MeasureSpec.getSize(paramInt2);
            i2 = localDrawable.getIntrinsicWidth();
            i3 = localDrawable.getIntrinsicHeight();
            f1 = a((int) (i2 * this.e), n, i6);
            if (n != 1073741824) {
                n = 1;
                f4 = f1 / i2;
                f2 = a((int) (i3 * this.e), i4, i5);
                if (i4 == 1073741824) {
                    break label194;
                }
                f3 = f2 / i3;
                if (f3 > f4) {
                    break label247;
                }
                if (n == 0) {
                    break label200;
                }
                f1 = i2;
                this.g = f3;
                f3 = f1 * f3;
                f1 = f2;
                f2 = f3;
                label166:
                setMeasuredDimension(resolveSize((int) f2, paramInt1), resolveSize((int) f1, paramInt2));
            }
        }
        for (; ; ) {
            a();
            return;
            n = 0;
            break;
            label194:
            i1 = 0;
            break label122;
            label200:
            if (i1 != 0) {
                f3 = i3 * f4;
                this.g = f4;
                f2 = f1;
                f1 = f3;
                break label166;
            }
            this.g = -1.0F;
            f3 = f1;
            f1 = f2;
            f2 = f3;
            break label166;
            label247:
            if (f3 > f4) {
                if (i1 != 0) {
                    f3 = i3 * f4;
                    this.g = f4;
                    f2 = f1;
                    f1 = f3;
                    break label166;
                }
                if (n != 0) {
                    f1 = i2;
                    this.g = f3;
                    f3 = f1 * f3;
                    f1 = f2;
                    f2 = f3;
                    break label166;
                }
                this.g = -1.0F;
            }
            f3 = f1;
            f1 = f2;
            f2 = f3;
            break label166;
            super.onMeasure(paramInt1, paramInt2);
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        boolean bool = this.m.a(paramMotionEvent);
        return (super.onTouchEvent(paramMotionEvent)) || (bool);
    }

    public void setFixedUpscaleRatio(float paramFloat) {
        this.e = paramFloat;
    }

    public void setForegroundDrawable(Drawable paramDrawable) {
        if (this.b == paramDrawable) {
        }
        do {
            return;
            if (this.b != null) {
                this.b.setCallback(null);
                unscheduleDrawable(this.b);
            }
            this.b = paramDrawable;
        } while (this.b == null);
        this.b.setCallback(this.c);
        if (this.b.isStateful()) {
            this.b.setState(getDrawableState());
        }
        paramDrawable = this.b;
        if (getVisibility() == 0) {
        }
        for (boolean bool = true; ; bool = false) {
            paramDrawable.setVisible(bool, false);
            a();
            return;
        }
    }

    public void setScaleType(ImageView.ScaleType paramScaleType) {
        if (this.d) {
            paramScaleType = ImageView.ScaleType.FIT_XY;
        }
        super.setScaleType(paramScaleType);
    }

    public void setTapListener(f paramf) {
        this.l = paramf;
    }

    public void setUpscaleRatioLimit(float paramFloat) {
        this.f = paramFloat;
    }

    public void setVisibility(int paramInt) {
        super.setVisibility(paramInt);
        Drawable localDrawable;
        if (this.b != null) {
            localDrawable = this.b;
            if (paramInt != 0) {
                break label31;
            }
        }
        label31:
        for (boolean bool = true; ; bool = false) {
            localDrawable.setVisible(bool, false);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/ImageViewEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */