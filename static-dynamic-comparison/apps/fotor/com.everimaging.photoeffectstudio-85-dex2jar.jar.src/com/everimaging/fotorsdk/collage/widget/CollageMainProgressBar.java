package com.everimaging.fotorsdk.collage.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import com.everimaging.fotorsdk.collage.R.attr;
import com.everimaging.fotorsdk.collage.R.styleable;

public class CollageMainProgressBar
        extends View {
    private int a = 0;
    private int b = 100;
    private float c;
    private float d;
    private int e;
    private int f;
    private Paint g;
    private Paint h;
    private RectF i;
    private RectF j;

    public CollageMainProgressBar(Context paramContext) {
        this(paramContext, null);
    }

    public CollageMainProgressBar(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, R.attr.fotorCollageMainProgressStyle);
    }

    public CollageMainProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FotorCollageMainProgress, paramInt, 0);
        float f1 = paramContext.getDimension(0, 3.0F);
        float f2 = paramContext.getDimension(1, 3.0F);
        paramInt = paramContext.getColor(2, -1);
        int k = paramContext.getColor(3, -1);
        setStrokeWidth(f1);
        setInnerPadding(f2);
        setStrokeColor(paramInt);
        setProgressColor(k);
        paramContext.recycle();
        a();
    }

    private void a() {
        this.g = new Paint();
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setAntiAlias(true);
        this.h = new Paint();
        this.h.setStyle(Paint.Style.FILL);
        this.h.setAntiAlias(true);
        this.i = new RectF();
        this.j = new RectF();
    }

    public float getInnerPadding() {
        return this.c;
    }

    public int getProgress() {
        return this.a;
    }

    public int getProgressColor() {
        return this.f;
    }

    public int getStrokeColor() {
        return this.e;
    }

    public float getStrokeWidth() {
        return this.d;
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        if ((getWidth() > 0) && (getHeight() > 0)) {
            this.g.setColor(this.e);
            this.g.setStrokeWidth(this.d);
            this.h.setColor(this.f);
            this.i.left = 0.0F;
            this.i.top = 0.0F;
            this.i.right = getWidth();
            this.i.bottom = getHeight();
            this.i.inset(this.d, this.d);
            float f1 = this.i.height() / 2.0F;
            paramCanvas.drawRoundRect(this.i, f1, f1, this.g);
            float f4 = this.i.height() - this.d - this.c * 2.0F;
            float f5 = f4 / 2.0F;
            float f2 = this.i.width() - this.d - this.c * 2.0F;
            float f3 = (f2 - f4) * (this.a / this.b) + f4;
            f1 = f3;
            if (f3 > f2) {
                f1 = f2;
            }
            f2 = (getWidth() - f2) / 2.0F;
            f3 = (getHeight() - f4) / 2.0F;
            this.j.left = f2;
            this.j.top = f3;
            this.j.right = (f1 + f2);
            this.j.bottom = (f3 + f4);
            paramCanvas.drawRoundRect(this.j, f5, f5, this.h);
        }
    }

    protected void onRestoreInstanceState(Parcelable paramParcelable) {
        super.onRestoreInstanceState(paramParcelable);
    }

    protected Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    public void setInnerPadding(float paramFloat) {
        this.c = paramFloat;
    }

    public void setProgress(int paramInt) {
        int k = paramInt;
        if (paramInt < 0) {
            k = 0;
        }
        paramInt = k;
        if (k > this.b) {
            paramInt = this.b;
        }
        this.a = paramInt;
        invalidate();
    }

    public void setProgressColor(int paramInt) {
        this.f = paramInt;
    }

    public void setStrokeColor(int paramInt) {
        this.e = paramInt;
    }

    public void setStrokeWidth(float paramFloat) {
        this.d = paramFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/widget/CollageMainProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */