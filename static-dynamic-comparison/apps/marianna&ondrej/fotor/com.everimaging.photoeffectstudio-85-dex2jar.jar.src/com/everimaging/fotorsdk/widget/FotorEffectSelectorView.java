package com.everimaging.fotorsdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.everimaging.fotorsdk.R.attr;
import com.everimaging.fotorsdk.R.color;
import com.everimaging.fotorsdk.R.styleable;

public class FotorEffectSelectorView
        extends FrameLayout {
    private int a;
    private Paint b;

    public FotorEffectSelectorView(Context paramContext) {
        this(paramContext, null);
    }

    public FotorEffectSelectorView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, R.attr.fotorDefaultEffectSelectorViewStyle);
    }

    public FotorEffectSelectorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        a();
        paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FotorEffectSelectorView, paramInt, 0);
        setSelectorColor(paramAttributeSet.getColor(0, paramContext.getResources().getColor(R.color.fotor_fx_effect_effects_listview_item_background_pressed)));
        paramAttributeSet.recycle();
    }

    @SuppressLint({"NewApi"})
    private void a() {
        this.b = new Paint();
        this.b.setStrokeWidth(2.0F);
        this.b.setStyle(Paint.Style.STROKE);
        setWillNotDraw(false);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(0, null);
        }
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        this.b.setColor(this.a);
        float f = this.b.getStrokeWidth() / 2.0F;
        RectF localRectF1 = new RectF(f, f, getWidth() - f, getHeight());
        RectF localRectF2 = new RectF(0.0F, 0.0F, getWidth(), getHeight());
        paramCanvas.save();
        paramCanvas.clipRect(localRectF2);
        paramCanvas.drawRect(localRectF1, this.b);
        paramCanvas.restore();
    }

    public void setSelectorColor(int paramInt) {
        this.a = paramInt;
        invalidate();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/FotorEffectSelectorView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */