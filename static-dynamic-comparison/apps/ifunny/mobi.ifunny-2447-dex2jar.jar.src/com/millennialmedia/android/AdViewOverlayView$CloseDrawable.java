package com.millennialmedia.android;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

class AdViewOverlayView$CloseDrawable
        extends Drawable {
    protected boolean a = true;
    protected final Paint b;

    AdViewOverlayView$CloseDrawable(boolean paramBoolean) {
        this.a = paramBoolean;
        this.b = new Paint();
        this.b.setAntiAlias(true);
        this.b.setStyle(Paint.Style.STROKE);
    }

    public void draw(Canvas paramCanvas) {
        Rect localRect = copyBounds();
        int j = localRect.right - localRect.left;
        int k = localRect.bottom - localRect.top;
        float f = j / 6.0F;
        this.b.setStrokeWidth(f);
        if (this.a) {
        }
        for (int i = 255; ; i = 80) {
            this.b.setARGB(255, i, i, i);
            paramCanvas.drawLine(f / 2.0F, f / 2.0F, j - f / 2.0F, k - f / 2.0F, this.b);
            paramCanvas.drawLine(j - f / 2.0F, f / 2.0F, f / 2.0F, k - f / 2.0F, this.b);
            return;
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int paramInt) {
    }

    public void setColorFilter(ColorFilter paramColorFilter) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/AdViewOverlayView$CloseDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */