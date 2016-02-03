package com.everimaging.fotorsdk.editor.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.everimaging.fotorsdk.editor.R.attr;
import com.everimaging.fotorsdk.widget.FotorNavigationButtonShort;

public class FotorCropRatioButton
        extends FotorNavigationButtonShort {
    protected float a = 0.0F;
    protected float b = 0.0F;
    protected Paint c;

    public FotorCropRatioButton(Context paramContext) {
        super(paramContext);
    }

    public FotorCropRatioButton(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, R.attr.fotorDefaultNavigateBtnStyle);
    }

    public FotorCropRatioButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    protected void a() {
        super.a();
        this.c = new Paint();
        this.c.setAntiAlias(true);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(2.0F);
    }

    public void a(float paramFloat1, float paramFloat2) {
        this.a = paramFloat1;
        this.b = paramFloat2;
        invalidate();
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        float f4;
        float f1;
        float f2;
        float f3;
        if (this.e) {
            this.c.setColor(this.m);
            if ((this.a != 0.0F) && (this.b != 0.0F)) {
                f4 = this.g.height() * 0.13333334F;
                f1 = this.g.height() - f4 * 2.0F;
                if ((this.a <= 0.0F) || (this.b <= 0.0F)) {
                    break label256;
                }
                if (this.a < this.b) {
                    break label238;
                }
                f2 = this.b / this.a * f1;
                f3 = f1;
            }
        }
        for (; ; ) {
            RectF localRectF = new RectF();
            localRectF.left = (this.g.left + (f1 - f3) / 2.0F + f4);
            float f5 = this.g.top;
            localRectF.top = ((f1 - f2) / 2.0F + f5 + f4);
            localRectF.right = (localRectF.left + f3);
            localRectF.bottom = (f2 + localRectF.top);
            paramCanvas.drawRect(localRectF, this.c);
            return;
            if (this.f) {
                this.c.setColor(this.m);
                break;
            }
            this.c.setColor(this.n);
            break;
            label238:
            f3 = this.a / this.b * f1;
            f2 = f1;
            continue;
            label256:
            f2 = f1;
            f3 = f1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/widget/FotorCropRatioButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */