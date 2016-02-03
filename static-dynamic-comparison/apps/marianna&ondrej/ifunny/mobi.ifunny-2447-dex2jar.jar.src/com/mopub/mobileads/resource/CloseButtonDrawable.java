package com.mopub.mobileads.resource;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Point;

public class CloseButtonDrawable
        extends CircleDrawable {
    private Point a;
    private Point b;
    private Point c;
    private Point d;
    private Point e;
    private final Paint f = new Paint(a());
    private int g;

    public CloseButtonDrawable() {
        this.f.setStrokeWidth(4.5F);
        this.f.setStrokeCap(Paint.Cap.ROUND);
    }

    public void draw(Canvas paramCanvas) {
        super.draw(paramCanvas);
        this.g = ((int) (0.5F * d() / (float) Math.sqrt(2.0D)));
        this.a = new Point(b(), c());
        this.b = new Point(this.a);
        this.b.offset(-this.g, this.g);
        this.c = new Point(this.a);
        this.c.offset(-this.g, -this.g);
        this.d = new Point(this.a);
        this.d.offset(this.g, -this.g);
        this.e = new Point(this.a);
        this.e.offset(this.g, this.g);
        paramCanvas.drawLine(this.b.x, this.b.y, this.d.x, this.d.y, this.f);
        paramCanvas.drawLine(this.c.x, this.c.y, this.e.x, this.e.y, this.f);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/resource/CloseButtonDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */