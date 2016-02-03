package com.androidquery.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import java.lang.ref.WeakReference;

public class RatioDrawable
        extends BitmapDrawable {
    private boolean adjusted;
    private float anchor;
    private Matrix m;
    private float ratio;
    private WeakReference<ImageView> ref;
    private int w;

    public RatioDrawable(Resources paramResources, Bitmap paramBitmap, ImageView paramImageView, float paramFloat1, float paramFloat2) {
        super(paramResources, paramBitmap);
        this.ref = new WeakReference(paramImageView);
        this.ratio = paramFloat1;
        this.anchor = paramFloat2;
        paramImageView.setScaleType(ImageView.ScaleType.MATRIX);
        paramImageView.setImageMatrix(new Matrix());
        adjust(paramImageView, paramBitmap, false);
    }

    private void adjust(ImageView paramImageView, Bitmap paramBitmap, boolean paramBoolean) {
        int i = getWidth(paramImageView);
        if (i <= 0) {
        }
        do {
            do {
                return;
                i = targetHeight(paramBitmap.getWidth(), paramBitmap.getHeight(), i) + paramImageView.getPaddingTop() + paramImageView.getPaddingBottom();
                paramBitmap = paramImageView.getLayoutParams();
            } while (paramBitmap == null);
            if (i != paramBitmap.height) {
                paramBitmap.height = i;
                paramImageView.setLayoutParams(paramBitmap);
            }
        } while (!paramBoolean);
        this.adjusted = true;
    }

    private void draw(Canvas paramCanvas, ImageView paramImageView, Bitmap paramBitmap) {
        Matrix localMatrix = getMatrix(paramImageView, paramBitmap);
        if (localMatrix != null) {
            int i = paramImageView.getPaddingTop() + paramImageView.getPaddingBottom();
            int j = paramImageView.getPaddingLeft() + paramImageView.getPaddingRight();
            if ((i > 0) || (j > 0)) {
                paramCanvas.clipRect(0, 0, paramImageView.getWidth() - j, paramImageView.getHeight() - i);
            }
            paramCanvas.drawBitmap(paramBitmap, localMatrix, getPaint());
        }
        if (!this.adjusted) {
            adjust(paramImageView, paramBitmap, true);
        }
    }

    private Matrix getMatrix(ImageView paramImageView, Bitmap paramBitmap) {
        int i = paramBitmap.getWidth();
        if ((this.m != null) && (i == this.w)) {
            return this.m;
        }
        int j = paramBitmap.getHeight();
        int k = getWidth(paramImageView);
        int n = targetHeight(i, j, k);
        if ((i <= 0) || (j <= 0) || (k <= 0) || (n <= 0)) {
            return null;
        }
        float f1;
        float f2;
        float f3;
        if ((this.m == null) || (i != this.w)) {
            f1 = 0.0F;
            f2 = 0.0F;
            this.m = new Matrix();
            if (i * n < k * j) {
                break label175;
            }
            f3 = n / j;
            f1 = (k - i * f3) * 0.5F;
        }
        for (; ; ) {
            this.m.setScale(f3, f3);
            this.m.postTranslate(f1, f2);
            this.w = i;
            return this.m;
            label175:
            f3 = k / i;
            f2 = getYOffset(i, j);
            f2 = (n - j * f3) * f2;
        }
    }

    private int getWidth(ImageView paramImageView) {
        int j = 0;
        ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
        if (localLayoutParams != null) {
            j = localLayoutParams.width;
        }
        int i = j;
        if (j <= 0) {
            i = paramImageView.getWidth();
        }
        j = i;
        if (i > 0) {
            j = i - paramImageView.getPaddingLeft() - paramImageView.getPaddingRight();
        }
        return j;
    }

    private float getYOffset(int paramInt1, int paramInt2) {
        if (this.anchor != Float.MAX_VALUE) {
            return (1.0F - this.anchor) / 2.0F;
        }
        return 0.25F + (1.5F - Math.max(1.0F, Math.min(1.5F, paramInt2 / paramInt1))) / 2.0F;
    }

    private int targetHeight(int paramInt1, int paramInt2, int paramInt3) {
        float f = this.ratio;
        if (this.ratio == Float.MAX_VALUE) {
            f = paramInt2 / paramInt1;
        }
        return (int) (paramInt3 * f);
    }

    public void draw(Canvas paramCanvas) {
        ImageView localImageView = null;
        if (this.ref != null) {
            localImageView = (ImageView) this.ref.get();
        }
        if ((this.ratio == 0.0F) || (localImageView == null)) {
            super.draw(paramCanvas);
            return;
        }
        draw(paramCanvas, localImageView, getBitmap());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/androidquery/util/RatioDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */