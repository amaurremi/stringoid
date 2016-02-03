package com.everimaging.fotorsdk.editor.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.everimaging.fotorsdk.editor.R.attr;
import com.everimaging.fotorsdk.editor.R.styleable;

public class FotorMosaicBrushSizeDisplayer
        extends View {
    private Paint a;
    private float b;

    public FotorMosaicBrushSizeDisplayer(Context paramContext) {
        this(paramContext, null);
    }

    public FotorMosaicBrushSizeDisplayer(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, R.attr.fotorMosaicBrushSizeDisplayerStyle);
    }

    public FotorMosaicBrushSizeDisplayer(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        setWillNotDraw(false);
        this.a = new Paint();
        this.a.setStyle(Paint.Style.STROKE);
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FotorMosaicBrushSizeDisplaer, paramInt, 0);
        float f = paramContext.getDimension(1, 10.0F);
        paramInt = paramContext.getColor(0, -1);
        this.a.setColor(paramInt);
        this.a.setAntiAlias(true);
        this.a.setStrokeWidth(f);
        this.b = 0.0F;
        paramContext.recycle();
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        int i = getWidth();
        int j = getHeight();
        if (this.b > 0.0F) {
            paramCanvas.drawCircle(i / 2.0F, j / 2.0F, this.b, this.a);
        }
    }

    public void setBrushSize(float paramFloat) {
        this.b = paramFloat;
        invalidate();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/widget/FotorMosaicBrushSizeDisplayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */