package com.makeramen;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class RoundedImageView
        extends ImageView {
    private static final ImageView.ScaleType[] b;
    private float c = 0.0F;
    private float d = 0.0F;
    private ColorStateList e = ColorStateList.valueOf(-16777216);
    private boolean f = false;
    private boolean g = false;
    private int h;
    private Drawable i;
    private Drawable j;
    private ImageView.ScaleType k;

    static {
        if (!RoundedImageView.class.desiredAssertionStatus()) {
        }
        for (boolean bool = true; ; bool = false) {
            a = bool;
            b = new ImageView.ScaleType[]{ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
            return;
        }
    }

    public RoundedImageView(Context paramContext) {
        super(paramContext);
    }

    public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.RoundedImageView, paramInt, 0);
        paramInt = paramContext.getInt(b.RoundedImageView_android_scaleType, -1);
        if (paramInt >= 0) {
            setScaleType(b[paramInt]);
        }
        for (; ; ) {
            this.c = paramContext.getDimensionPixelSize(b.RoundedImageView_corner_radius, -1);
            this.d = paramContext.getDimensionPixelSize(b.RoundedImageView_border_width, -1);
            if (this.c < 0.0F) {
                this.c = 0.0F;
            }
            if (this.d < 0.0F) {
                this.d = 0.0F;
            }
            this.e = paramContext.getColorStateList(b.RoundedImageView_border_color);
            if (this.e == null) {
                this.e = ColorStateList.valueOf(-16777216);
            }
            this.g = paramContext.getBoolean(b.RoundedImageView_mutate_background, false);
            this.f = paramContext.getBoolean(b.RoundedImageView_oval, false);
            b();
            a(true);
            paramContext.recycle();
            return;
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    private Drawable a() {
        Object localObject3 = null;
        Resources localResources = getResources();
        if (localResources == null) {
            return null;
        }
        Object localObject1 = localObject3;
        if (this.h != 0) {
        }
        try {
            localObject1 = localResources.getDrawable(this.h);
            return c.a((Drawable) localObject1);
        } catch (Exception localException) {
            for (; ; ) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.h, localException);
                this.h = 0;
                Object localObject2 = localObject3;
            }
        }
    }

    private void a(Drawable paramDrawable) {
        if (paramDrawable == null) {
        }
        for (; ; ) {
            return;
            if ((paramDrawable instanceof c)) {
                ((c) paramDrawable).a(this.k).a(this.c).b(this.d).a(this.e).a(this.f);
                return;
            }
            if ((paramDrawable instanceof LayerDrawable)) {
                paramDrawable = (LayerDrawable) paramDrawable;
                int m = 0;
                int n = paramDrawable.getNumberOfLayers();
                while (m < n) {
                    a(paramDrawable.getDrawable(m));
                    m += 1;
                }
            }
        }
    }

    private void a(boolean paramBoolean) {
        if (this.g) {
            if (paramBoolean) {
                this.j = c.a(this.j);
            }
            a(this.j);
        }
    }

    private void b() {
        a(this.i);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public int getBorderColor() {
        return this.e.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.e;
    }

    public float getBorderWidth() {
        return this.d;
    }

    public float getCornerRadius() {
        return this.c;
    }

    public ImageView.ScaleType getScaleType() {
        return this.k;
    }

    public void setBackground(Drawable paramDrawable) {
        setBackgroundDrawable(paramDrawable);
    }

    @Deprecated
    public void setBackgroundDrawable(Drawable paramDrawable) {
        this.j = paramDrawable;
        a(true);
        super.setBackgroundDrawable(this.j);
    }

    public void setBorderColor(int paramInt) {
        setBorderColor(ColorStateList.valueOf(paramInt));
    }

    public void setBorderColor(ColorStateList paramColorStateList) {
        if (this.e.equals(paramColorStateList)) {
            return;
        }
        if (paramColorStateList != null) {
        }
        for (; ; ) {
            this.e = paramColorStateList;
            b();
            a(false);
            if (this.d <= 0.0F) {
                break;
            }
            invalidate();
            return;
            paramColorStateList = ColorStateList.valueOf(-16777216);
        }
    }

    public void setBorderWidth(float paramFloat) {
        if (this.d == paramFloat) {
            return;
        }
        this.d = paramFloat;
        b();
        a(false);
        invalidate();
    }

    public void setBorderWidth(int paramInt) {
        setBorderWidth(getResources().getDimension(paramInt));
    }

    public void setCornerRadius(float paramFloat) {
        if (this.c == paramFloat) {
            return;
        }
        this.c = paramFloat;
        b();
        a(false);
    }

    public void setCornerRadius(int paramInt) {
        setCornerRadius(getResources().getDimension(paramInt));
    }

    public void setImageBitmap(Bitmap paramBitmap) {
        this.h = 0;
        this.i = c.a(paramBitmap);
        b();
        super.setImageDrawable(this.i);
    }

    public void setImageDrawable(Drawable paramDrawable) {
        this.h = 0;
        this.i = c.a(paramDrawable);
        b();
        super.setImageDrawable(this.i);
    }

    public void setImageResource(int paramInt) {
        if (this.h != paramInt) {
            this.h = paramInt;
            this.i = a();
            b();
            super.setImageDrawable(this.i);
        }
    }

    public void setImageURI(Uri paramUri) {
        super.setImageURI(paramUri);
        setImageDrawable(getDrawable());
    }

    public void setMutateBackground(boolean paramBoolean) {
        if (this.g == paramBoolean) {
            return;
        }
        this.g = paramBoolean;
        a(true);
        invalidate();
    }

    public void setOval(boolean paramBoolean) {
        this.f = paramBoolean;
        b();
        a(false);
        invalidate();
    }

    public void setScaleType(ImageView.ScaleType paramScaleType) {
        if ((!a) && (paramScaleType == null)) {
            throw new AssertionError();
        }
        if (this.k != paramScaleType) {
            this.k = paramScaleType;
            switch (e.a[paramScaleType.ordinal()]) {
                default:
                    super.setScaleType(paramScaleType);
            }
        }
        for (; ; ) {
            b();
            a(false);
            invalidate();
            return;
            super.setScaleType(ImageView.ScaleType.FIT_XY);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/makeramen/RoundedImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */