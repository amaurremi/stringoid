package com.everimaging.fotorsdk.brush;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

public abstract class Brush {
    private RectF a = null;

    public static Rect a(RectF paramRectF) {
        Rect localRect = new Rect();
        localRect.left = ((int) Math.floor(paramRectF.left));
        localRect.top = ((int) Math.floor(paramRectF.top));
        localRect.right = ((int) Math.ceil(paramRectF.right));
        localRect.bottom = ((int) Math.ceil(paramRectF.bottom));
        return localRect;
    }

    public RectF a() {
        return this.a;
    }

    public abstract void a(Canvas paramCanvas);

    public void b(RectF paramRectF) {
        this.a = new RectF();
        this.a.left = ((float) Math.floor(paramRectF.left));
        this.a.top = ((float) Math.floor(paramRectF.top));
        this.a.right = ((float) Math.ceil(paramRectF.right));
        this.a.bottom = ((float) Math.ceil(paramRectF.bottom));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/brush/Brush.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */