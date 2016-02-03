package com.millennialmedia.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;

class AdViewOverlayView$CloseTopDrawable
        extends AdViewOverlayView.CloseDrawable {
    final float c;
    final float d;

    AdViewOverlayView$CloseTopDrawable(boolean paramBoolean, float paramFloat) {
        super(paramBoolean);
        this.c = paramFloat;
        this.d = (4.0F * paramFloat);
        this.b.setColor(-16777216);
    }

    public void draw(Canvas paramCanvas) {
        Rect localRect = copyBounds();
        float f1 = (localRect.right - localRect.left) / 10.0F;
        float f2 = localRect.right - this.c * 20.0F;
        float f3 = localRect.top + this.c * 20.0F;
        this.b.setStrokeWidth(f1);
        this.b.setColor(-16777216);
        this.b.setStyle(Paint.Style.STROKE);
        paramCanvas.drawCircle(f2, f3, 12.0F * this.c, this.b);
        this.b.setColor(-1);
        this.b.setStyle(Paint.Style.FILL_AND_STROKE);
        paramCanvas.drawCircle(f2, f3, this.c * 10.0F, this.b);
        this.b.setColor(-16777216);
        paramCanvas.drawCircle(f2, f3, 7.0F * this.c, this.b);
        this.b.setColor(-1);
        this.b.setStrokeWidth(f1 / 2.0F);
        this.b.setStyle(Paint.Style.STROKE);
        paramCanvas.drawLine(f2 - this.d, f3 - this.d, f2 + this.d, f3 + this.d, this.b);
        paramCanvas.drawLine(f2 + this.d, f3 - this.d, f2 - this.d, f3 + this.d, this.b);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/AdViewOverlayView$CloseTopDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */