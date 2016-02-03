package com.everimaging.fotorsdk.collage.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.everimaging.fotorsdk.collage.R.color;
import com.everimaging.fotorsdk.collage.R.dimen;
import com.everimaging.fotorsdk.collage.R.styleable;
import com.everimaging.fotorsdk.utils.BitmapUtils;

public class CollageFxThumbImageView
        extends ImageView {
    private float a = 0.2F;
    private Bitmap b;
    private Paint c;
    private Paint d;
    private PaintFlagsDrawFilter e;

    public CollageFxThumbImageView(Context paramContext) {
        this(paramContext, null);
    }

    public CollageFxThumbImageView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public CollageFxThumbImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        a();
    }

    @SuppressLint({"NewApi"})
    private void a() {
        setWillNotDraw(false);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        TypedArray localTypedArray = getContext().obtainStyledAttributes(R.styleable.Theme);
        this.c = new Paint();
        this.c.setColor(-1);
        this.d = new Paint();
        this.d.setColor(localTypedArray.getColor(1, getResources().getColor(R.color.fotor_collage_fx_selected)));
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(getResources().getDimension(R.dimen.fotor_collage_fx_selector_stroke_width));
        this.e = new PaintFlagsDrawFilter(0, 3);
        localTypedArray.recycle();
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas paramCanvas) {
        if (this.a > 0.0F) {
            float f1 = Math.min(getWidth(), getHeight()) / 2.0F * this.a;
            RectF localRectF = new RectF();
            localRectF.left = 0.0F;
            localRectF.top = 0.0F;
            localRectF.bottom = getHeight();
            localRectF.right = getWidth();
            this.b.eraseColor(0);
            super.onDraw(new Canvas(this.b));
            paramCanvas.setDrawFilter(this.e);
            int i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
            this.c.setXfermode(null);
            paramCanvas.drawRoundRect(localRectF, f1, f1, this.c);
            this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
            paramCanvas.drawBitmap(this.b, 0.0F, 0.0F, this.c);
            paramCanvas.restoreToCount(i);
            if (isSelected()) {
                localRectF = new RectF(localRectF);
                float f2 = this.d.getStrokeWidth() / 2.0F;
                localRectF.inset(f2, f2);
                paramCanvas.drawRoundRect(localRectF, f1, f1, this.d);
            }
            return;
        }
        super.onDraw(paramCanvas);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        paramInt1 = getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
        setMeasuredDimension(paramInt1, paramInt1);
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onSizeChanged(paramInt1, paramInt1, paramInt3, paramInt4);
        if (paramInt1 > 0) {
            this.b = BitmapUtils.createBitmap(paramInt1, paramInt1, Bitmap.Config.ARGB_8888);
        }
    }

    public void setRoundStrength(float paramFloat) {
        this.a = paramFloat;
        invalidate();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/widget/CollageFxThumbImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */