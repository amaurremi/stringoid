package com.inmobi.re.container;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.view.View;

public class CustomView
        extends View {
    private float a;
    private float b;
    private float c;
    private float d;
    private float e;
    private CustomView.SwitchIconType f;
    private int g;
    private Paint h;
    private Path i;
    private RectF j;

    private CustomView(Context paramContext) {
        super(paramContext);
    }

    public CustomView(Context paramContext, float paramFloat, CustomView.SwitchIconType paramSwitchIconType) {
        this(paramContext);
        this.f = paramSwitchIconType;
        this.a = paramFloat;
        this.g = 15;
        this.b = (50.0F * this.a / 2.0F);
        this.c = (30.0F * this.a / 2.0F);
        this.d = (this.b - this.c / 3.0F);
        this.e = (this.b + this.c / 3.0F);
        this.h = new Paint(1);
        this.j = new RectF();
        this.i = new Path();
    }

    public void disableView(boolean paramBoolean) {
        if (paramBoolean) {
            setClickable(false);
            setEnabled(false);
            return;
        }
        setClickable(true);
        setEnabled(true);
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        this.h.reset();
        switch (CustomView.a.a[this.f.ordinal()]) {
            default:
                return;
            case 1:
                this.h.setAntiAlias(true);
                this.h.setColor(-16777216);
                this.h.setStrokeWidth(3.0F);
                this.h.setStyle(Paint.Style.FILL_AND_STROKE);
                paramCanvas.drawCircle(this.b, this.b, this.c, this.h);
                this.h.setColor(-1);
                this.h.setStyle(Paint.Style.STROKE);
                paramCanvas.drawLine(this.d, this.d, this.e, this.e, this.h);
                paramCanvas.drawLine(this.d, this.e, this.e, this.d, this.h);
                paramCanvas.drawCircle(this.b, this.b, this.c, this.h);
                return;
            case 2:
                this.h.setAntiAlias(true);
                this.h.setColor(0);
                this.h.setStrokeWidth(3.0F);
                this.h.setStyle(Paint.Style.FILL_AND_STROKE);
                paramCanvas.drawCircle(this.b, this.b, this.b, this.h);
                return;
            case 3:
                this.i.reset();
                this.i.setFillType(Path.FillType.EVEN_ODD);
                this.i.moveTo(getWidth() / 2 - this.g * this.a / 2.0F, getHeight() / 2 - this.g * this.a / 2.0F);
                this.i.lineTo(getWidth() / 2 + this.g * this.a / 2.0F, getHeight() / 2);
                this.i.lineTo(getWidth() / 2 - this.g * this.a / 2.0F, getHeight() / 2 + this.g * this.a / 2.0F);
                this.i.lineTo(getWidth() / 2 - this.g * this.a / 2.0F, getHeight() / 2 - this.g * this.a / 2.0F);
                this.i.close();
                this.h.setAntiAlias(true);
                this.h.setColor(-16777216);
                this.h.setStrokeWidth(3.0F);
                this.h.setStyle(Paint.Style.FILL_AND_STROKE);
                paramCanvas.drawPath(this.i, this.h);
                return;
            case 4:
                this.i.reset();
                this.i.setFillType(Path.FillType.EVEN_ODD);
                this.i.moveTo(getWidth() / 2 - this.g * this.a / 2.0F, getHeight() / 2 - this.g * this.a / 2.0F);
                this.i.lineTo(getWidth() / 2 + this.g * this.a / 2.0F, getHeight() / 2);
                this.i.lineTo(getWidth() / 2 - this.g * this.a / 2.0F, getHeight() / 2 + this.g * this.a / 2.0F);
                this.i.lineTo(getWidth() / 2 - this.g * this.a / 2.0F, getHeight() / 2 - this.g * this.a / 2.0F);
                this.i.close();
                this.h.setAntiAlias(true);
                this.h.setColor(-12303292);
                this.h.setStrokeWidth(3.0F);
                this.h.setStyle(Paint.Style.FILL_AND_STROKE);
                paramCanvas.drawPath(this.i, this.h);
                return;
            case 5:
                this.i.reset();
                this.i.setFillType(Path.FillType.EVEN_ODD);
                this.i.moveTo(getWidth() / 2 - this.g * this.a / 2.0F, getHeight() / 2);
                this.i.lineTo(getWidth() / 2 + this.g * this.a / 2.0F, getHeight() / 2 - this.g * this.a / 2.0F);
                this.i.lineTo(getWidth() / 2 + this.g * this.a / 2.0F, getHeight() / 2 + this.g * this.a / 2.0F);
                this.i.lineTo(getWidth() / 2 - this.g * this.a / 2.0F, getHeight() / 2);
                this.i.close();
                this.h.setAntiAlias(true);
                this.h.setColor(-16777216);
                this.h.setStrokeWidth(3.0F);
                this.h.setStyle(Paint.Style.FILL_AND_STROKE);
                paramCanvas.drawPath(this.i, this.h);
                return;
            case 6:
                this.i.reset();
                this.h.setAntiAlias(true);
                this.h.setColor(-16777216);
                this.h.setStrokeWidth(5.0F);
                this.h.setStyle(Paint.Style.STROKE);
                this.j.set(getWidth() / 2 - this.g * this.a / 2.0F, getHeight() / 2 - this.g * this.a / 2.0F, getWidth() / 2 + this.g * this.a / 2.0F, getHeight() / 2 + this.g * this.a / 2.0F);
                paramCanvas.drawArc(this.j, 0.0F, 270.0F, false, this.h);
                this.i.setFillType(Path.FillType.EVEN_ODD);
                this.i.moveTo(getWidth() / 2 + this.g * this.a / 2.0F, getHeight() / 2 - this.a * 2.0F);
                this.i.lineTo(getWidth() / 2 + this.g * this.a / 2.0F - this.a * 2.0F, getHeight() / 2);
                this.i.lineTo(getWidth() / 2 + this.g * this.a / 2.0F + this.a * 2.0F, getHeight() / 2);
                this.i.lineTo(getWidth() / 2 + this.g * this.a / 2.0F, getHeight() / 2 - this.a * 2.0F);
                this.i.close();
                this.h.setStyle(Paint.Style.FILL_AND_STROKE);
                paramCanvas.drawPath(this.i, this.h);
                return;
        }
        this.h.setAntiAlias(true);
        this.h.setColor(-16777216);
        this.h.setStrokeWidth(5.0F);
        this.h.setStyle(Paint.Style.STROKE);
        float f1 = getWidth() / 2;
        float f2 = this.g * this.a / 2.0F;
        float f3 = getHeight() / 2;
        float f4 = this.g * this.a / 2.0F;
        float f5 = getWidth() / 2;
        float f6 = this.g * this.a / 2.0F;
        float f7 = getHeight() / 2;
        paramCanvas.drawLine(f1 - f2, f3 - f4, f6 + f5, this.g * this.a / 2.0F + f7, this.h);
        f1 = getWidth() / 2;
        f2 = this.g * this.a / 2.0F;
        f3 = getHeight() / 2;
        f4 = this.g * this.a / 2.0F;
        f5 = getWidth() / 2;
        paramCanvas.drawLine(f1 - f2, f4 + f3, this.g * this.a / 2.0F + f5, getHeight() / 2 - this.g * this.a / 2.0F, this.h);
    }

    public void setSwitchInt(CustomView.SwitchIconType paramSwitchIconType) {
        this.f = paramSwitchIconType;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/CustomView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */