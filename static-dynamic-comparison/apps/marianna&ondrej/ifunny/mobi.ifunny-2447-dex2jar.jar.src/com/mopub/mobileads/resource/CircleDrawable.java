package com.mopub.mobileads.resource;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public abstract class CircleDrawable
        extends Drawable {
    private final Paint a = new Paint();

    public CircleDrawable() {
        this.a.setAntiAlias(true);
        this.a.setStrokeWidth(3.0F);
        this.a.setColor(-1);
        this.a.setStyle(Paint.Style.STROKE);
    }

    protected Paint a() {
        return this.a;
    }

    protected int b() {
        return getBounds().width() / 2;
    }

    protected int c() {
        return getBounds().height() / 2;
    }

    protected int d() {
        return Math.min(b(), c());
    }

    public void draw(Canvas paramCanvas) {
        paramCanvas.drawCircle(b(), c(), d(), this.a);
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int paramInt) {
    }

    public void setColorFilter(ColorFilter paramColorFilter) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/resource/CircleDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */