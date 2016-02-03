package com.makeramen;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView.ScaleType;

public class c
        extends Drawable {
    private final RectF a = new RectF();
    private final RectF b = new RectF();
    private final RectF c = new RectF();
    private final BitmapShader d;
    private final Paint e;
    private final int f;
    private final int g;
    private final RectF h = new RectF();
    private final Paint i;
    private final Matrix j = new Matrix();
    private float k = 0.0F;
    private boolean l = false;
    private float m = 0.0F;
    private ColorStateList n = ColorStateList.valueOf(-16777216);
    private ImageView.ScaleType o = ImageView.ScaleType.FIT_CENTER;

    public c(Bitmap paramBitmap) {
        this.f = paramBitmap.getWidth();
        this.g = paramBitmap.getHeight();
        this.c.set(0.0F, 0.0F, this.f, this.g);
        this.d = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.d.setLocalMatrix(this.j);
        this.e = new Paint();
        this.e.setStyle(Paint.Style.FILL);
        this.e.setAntiAlias(true);
        this.e.setShader(this.d);
        this.i = new Paint();
        this.i.setStyle(Paint.Style.STROKE);
        this.i.setAntiAlias(true);
        this.i.setColor(this.n.getColorForState(getState(), -16777216));
        this.i.setStrokeWidth(this.m);
    }

    public static Drawable a(Drawable paramDrawable) {
        Object localObject = paramDrawable;
        if (paramDrawable != null) {
            if ((paramDrawable instanceof c)) {
                localObject = paramDrawable;
            }
        } else {
            return (Drawable) localObject;
        }
        if ((paramDrawable instanceof LayerDrawable)) {
            paramDrawable = (LayerDrawable) paramDrawable;
            int i2 = paramDrawable.getNumberOfLayers();
            int i1 = 0;
            for (; ; ) {
                localObject = paramDrawable;
                if (i1 >= i2) {
                    break;
                }
                localObject = paramDrawable.getDrawable(i1);
                paramDrawable.setDrawableByLayerId(paramDrawable.getId(i1), a((Drawable) localObject));
                i1 += 1;
            }
        }
        localObject = b(paramDrawable);
        if (localObject != null) {
            return new c((Bitmap) localObject);
        }
        Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
        return paramDrawable;
    }

    public static c a(Bitmap paramBitmap) {
        if (paramBitmap != null) {
            return new c(paramBitmap);
        }
        return null;
    }

    private void a() {
        float f1 = 0.0F;
        switch (d.a[this.o.ordinal()]) {
            case 4:
            default:
                this.h.set(this.c);
                this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.CENTER);
                this.j.mapRect(this.h);
                this.h.inset(this.m / 2.0F, this.m / 2.0F);
                this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
        }
        for (; ; ) {
            this.b.set(this.h);
            this.d.setLocalMatrix(this.j);
            return;
            this.h.set(this.a);
            this.h.inset(this.m / 2.0F, this.m / 2.0F);
            this.j.reset();
            this.j.setTranslate((int) ((this.h.width() - this.f) * 0.5F + 0.5F), (int) ((this.h.height() - this.g) * 0.5F + 0.5F));
            continue;
            this.h.set(this.a);
            this.h.inset(this.m / 2.0F, this.m / 2.0F);
            this.j.reset();
            float f3;
            float f2;
            if (this.f * this.h.height() > this.h.width() * this.g) {
                f3 = this.h.height() / this.g;
                f2 = (this.h.width() - this.f * f3) * 0.5F;
            }
            for (; ; ) {
                this.j.setScale(f3, f3);
                this.j.postTranslate((int) (f2 + 0.5F) + this.m, (int) (f1 + 0.5F) + this.m);
                break;
                f3 = this.h.width() / this.f;
                f1 = this.h.height();
                float f4 = this.g;
                f2 = 0.0F;
                f1 = (f1 - f4 * f3) * 0.5F;
            }
            this.j.reset();
            if ((this.f <= this.a.width()) && (this.g <= this.a.height())) {
            }
            for (f1 = 1.0F; ; f1 = Math.min(this.a.width() / this.f, this.a.height() / this.g)) {
                f2 = (int) ((this.a.width() - this.f * f1) * 0.5F + 0.5F);
                f3 = (int) ((this.a.height() - this.g * f1) * 0.5F + 0.5F);
                this.j.setScale(f1, f1);
                this.j.postTranslate(f2, f3);
                this.h.set(this.c);
                this.j.mapRect(this.h);
                this.h.inset(this.m / 2.0F, this.m / 2.0F);
                this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
                break;
            }
            this.h.set(this.c);
            this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.END);
            this.j.mapRect(this.h);
            this.h.inset(this.m / 2.0F, this.m / 2.0F);
            this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
            continue;
            this.h.set(this.c);
            this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.START);
            this.j.mapRect(this.h);
            this.h.inset(this.m / 2.0F, this.m / 2.0F);
            this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
            continue;
            this.h.set(this.a);
            this.h.inset(this.m / 2.0F, this.m / 2.0F);
            this.j.reset();
            this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
        }
    }

    public static Bitmap b(Drawable paramDrawable) {
        if ((paramDrawable instanceof BitmapDrawable)) {
            return ((BitmapDrawable) paramDrawable).getBitmap();
        }
        int i1 = Math.max(paramDrawable.getIntrinsicWidth(), 1);
        int i2 = Math.max(paramDrawable.getIntrinsicHeight(), 1);
        try {
            Bitmap localBitmap = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
            Canvas localCanvas = new Canvas(localBitmap);
            paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
            paramDrawable.draw(localCanvas);
            return localBitmap;
        } catch (Exception paramDrawable) {
            paramDrawable.printStackTrace();
        }
        return null;
    }

    public c a(float paramFloat) {
        this.k = paramFloat;
        return this;
    }

    public c a(ColorStateList paramColorStateList) {
        if (paramColorStateList != null) {
        }
        for (; ; ) {
            this.n = paramColorStateList;
            this.i.setColor(this.n.getColorForState(getState(), -16777216));
            return this;
            paramColorStateList = ColorStateList.valueOf(0);
        }
    }

    public c a(ImageView.ScaleType paramScaleType) {
        ImageView.ScaleType localScaleType = paramScaleType;
        if (paramScaleType == null) {
            localScaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.o != localScaleType) {
            this.o = localScaleType;
            a();
        }
        return this;
    }

    public c a(boolean paramBoolean) {
        this.l = paramBoolean;
        return this;
    }

    public c b(float paramFloat) {
        this.m = paramFloat;
        this.i.setStrokeWidth(this.m);
        return this;
    }

    public void draw(Canvas paramCanvas) {
        if (this.l) {
            if (this.m > 0.0F) {
                paramCanvas.drawOval(this.b, this.e);
                paramCanvas.drawOval(this.h, this.i);
                return;
            }
            paramCanvas.drawOval(this.b, this.e);
            return;
        }
        if (this.m > 0.0F) {
            paramCanvas.drawRoundRect(this.b, Math.max(this.k, 0.0F), Math.max(this.k, 0.0F), this.e);
            paramCanvas.drawRoundRect(this.h, this.k, this.k, this.i);
            return;
        }
        paramCanvas.drawRoundRect(this.b, this.k, this.k, this.e);
    }

    public int getIntrinsicHeight() {
        return this.g;
    }

    public int getIntrinsicWidth() {
        return this.f;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isStateful() {
        return this.n.isStateful();
    }

    protected void onBoundsChange(Rect paramRect) {
        super.onBoundsChange(paramRect);
        this.a.set(paramRect);
        a();
    }

    protected boolean onStateChange(int[] paramArrayOfInt) {
        int i1 = this.n.getColorForState(paramArrayOfInt, 0);
        if (this.i.getColor() != i1) {
            this.i.setColor(i1);
            return true;
        }
        return super.onStateChange(paramArrayOfInt);
    }

    public void setAlpha(int paramInt) {
        this.e.setAlpha(paramInt);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter paramColorFilter) {
        this.e.setColorFilter(paramColorFilter);
        invalidateSelf();
    }

    public void setDither(boolean paramBoolean) {
        this.e.setDither(paramBoolean);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean paramBoolean) {
        this.e.setFilterBitmap(paramBoolean);
        invalidateSelf();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/makeramen/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */