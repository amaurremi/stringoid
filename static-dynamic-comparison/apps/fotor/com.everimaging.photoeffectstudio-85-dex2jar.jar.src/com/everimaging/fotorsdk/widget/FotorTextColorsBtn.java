package com.everimaging.fotorsdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.everimaging.fotorsdk.R.dimen;

public class FotorTextColorsBtn
        extends View {
    private int a;
    private Paint b;

    public FotorTextColorsBtn(Context paramContext) {
        this(paramContext, null);
    }

    public FotorTextColorsBtn(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public FotorTextColorsBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        setWillNotDraw(false);
        setClickable(true);
        this.b = new Paint();
        this.b.setStrokeWidth(paramContext.getResources().getDimension(R.dimen.fotor_text_color_button_stroke));
        this.b.setAntiAlias(true);
    }

    public int getColor() {
        return this.a;
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        int i = getWidth();
        int j = getHeight();
        float f1 = i / 2.0F;
        float f2 = j / 2.0F;
        float f3 = 0.35714287F * i;
        float f4 = 0.19285715F * i;
        RectF localRectF1 = new RectF(f1 - f3, f2 - f3, f1 + f3, f3 + f2);
        RectF localRectF2 = new RectF(f1 - f4, f2 - f4, f1 + f4, f4 + f2);
        this.b.setColor(this.a);
        if (isSelected()) {
            this.b.setStyle(Paint.Style.STROKE);
            paramCanvas.drawOval(localRectF1, this.b);
            this.b.setStyle(Paint.Style.FILL_AND_STROKE);
            paramCanvas.drawOval(localRectF2, this.b);
            return;
        }
        this.b.setStyle(Paint.Style.FILL_AND_STROKE);
        paramCanvas.drawOval(localRectF1, this.b);
    }

    public void setColor(int paramInt) {
        this.a = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/FotorTextColorsBtn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */