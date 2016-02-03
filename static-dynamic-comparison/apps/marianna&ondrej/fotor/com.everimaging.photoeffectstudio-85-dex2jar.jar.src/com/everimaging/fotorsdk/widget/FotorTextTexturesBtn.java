package com.everimaging.fotorsdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

public class FotorTextTexturesBtn
        extends View {
    private Drawable a;
    private int b;
    private int c;
    private Paint d;

    public FotorTextTexturesBtn(Context paramContext) {
        this(paramContext, null);
    }

    public FotorTextTexturesBtn(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public FotorTextTexturesBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        setWillNotDraw(false);
        setClickable(true);
        this.d = new Paint();
        this.d.setStrokeWidth(1.0F);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setAntiAlias(true);
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        int i = getWidth();
        int j = getHeight();
        float f1 = i / 2.0F;
        float f2 = j / 2.0F;
        RectF localRectF;
        if (this.a != null) {
            int m = this.a.getIntrinsicWidth();
            int k = this.a.getIntrinsicHeight();
            i = (int) (f1 - m / 2.0F);
            j = (int) (f2 - k / 2.0F);
            m += i;
            k += j;
            this.a.setBounds(i, j, m, k);
            this.a.draw(paramCanvas);
            localRectF = new RectF(i, j, m, k);
            if (!isSelected()) {
                break label161;
            }
            this.d.setColor(this.b);
        }
        for (; ; ) {
            paramCanvas.drawRect(localRectF, this.d);
            return;
            label161:
            this.d.setColor(this.c);
        }
    }

    public void setBorderDefaultColor(int paramInt) {
        this.c = paramInt;
    }

    public void setBorderSelectedColor(int paramInt) {
        this.b = paramInt;
    }

    public void setTextureDrawable(Drawable paramDrawable) {
        this.a = paramDrawable;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/FotorTextTexturesBtn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */