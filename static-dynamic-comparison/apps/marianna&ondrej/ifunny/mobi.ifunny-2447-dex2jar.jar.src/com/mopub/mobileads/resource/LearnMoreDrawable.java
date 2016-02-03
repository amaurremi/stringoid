package com.mopub.mobileads.resource;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Point;

public class LearnMoreDrawable
        extends CircleDrawable {
    private final Paint a = new Paint(a());
    private Point b;
    private Point c;
    private Point d;
    private Point e;
    private Point f;
    private int g;
    private int h;

    public LearnMoreDrawable() {
        this.a.setStrokeWidth(4.5F);
        this.a.setStrokeCap(Paint.Cap.ROUND);
    }

    public void draw(Canvas paramCanvas) {
        super.draw(paramCanvas);
        this.g = ((int) (0.5F * d() / Math.sqrt(2.0D)));
        this.h = ((int) (1.5F * this.g));
        this.b = new Point(b(), c());
        this.c = new Point(this.b);
        this.c.offset(-this.g, this.g);
        this.d = new Point(this.b);
        this.d.offset(this.g, -this.g);
        this.e = new Point(this.d);
        this.e.offset(-this.h, 0);
        this.f = new Point(this.d);
        this.f.offset(0, this.h);
        paramCanvas.drawLine(this.c.x, this.c.y, this.d.x, this.d.y, this.a);
        paramCanvas.drawLine(this.d.x, this.d.y, this.e.x, this.e.y, this.a);
        paramCanvas.drawLine(this.d.x, this.d.y, this.f.x, this.f.y, this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/resource/LearnMoreDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */