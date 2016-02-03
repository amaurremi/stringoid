package com.everimaging.fotorsdk.editor.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.everimaging.fotorsdk.editor.R.attr;
import com.everimaging.fotorsdk.editor.R.dimen;
import com.everimaging.fotorsdk.editor.R.styleable;

public class FotorMosaicBrushSizeSlider
        extends SeekBar
        implements SeekBar.OnSeekBarChangeListener {
    private float[] a;
    private float b;
    private Paint c;
    private float d;
    private a e;

    public FotorMosaicBrushSizeSlider(Context paramContext) {
        this(paramContext, null);
    }

    public FotorMosaicBrushSizeSlider(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, R.attr.fotorMosaicBrushSizeSliderStyle);
    }

    public FotorMosaicBrushSizeSlider(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FotorMosaicBrushSizeSlider, paramInt, 0);
        a(paramContext);
        b(paramContext);
        paramContext.recycle();
    }

    private void a(TypedArray paramTypedArray) {
        setProgressDrawable(new ColorDrawable(0));
        paramTypedArray = paramTypedArray.getDrawable(1);
        setThumb(paramTypedArray);
        int i = (int) (paramTypedArray.getIntrinsicWidth() / 2.0F + 0.5D);
        setPadding(i, 0, i, 0);
        this.d = i;
    }

    @SuppressLint({"NewApi"})
    private void b(TypedArray paramTypedArray) {
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        setWillNotDraw(false);
        Resources localResources = getResources();
        this.a = new float[5];
        this.a[0] = localResources.getDimension(R.dimen.fotor_mosaic_brush_size_slider_circle_radius_1);
        this.a[1] = localResources.getDimension(R.dimen.fotor_mosaic_brush_size_slider_circle_radius_2);
        this.a[2] = localResources.getDimension(R.dimen.fotor_mosaic_brush_size_slider_circle_radius_3);
        this.a[3] = localResources.getDimension(R.dimen.fotor_mosaic_brush_size_slider_circle_radius_4);
        this.a[4] = localResources.getDimension(R.dimen.fotor_mosaic_brush_size_slider_circle_radius_5);
        this.c = new Paint();
        this.c.setAntiAlias(true);
        int i = paramTypedArray.getColor(0, -1);
        this.c.setColor(i);
        this.b = paramTypedArray.getDimension(2, 10.0F);
        setOnSeekBarChangeListener(this);
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas paramCanvas) {
        try {
            int j = getWidth();
            int i = getHeight();
            RectF localRectF = new RectF();
            localRectF.left = this.d;
            localRectF.right = (j - this.d);
            localRectF.top = ((i - this.b) / 2.0F);
            localRectF.bottom = (localRectF.top + this.b);
            j = paramCanvas.saveLayer(0.0F, 0.0F, j, i, null, 31);
            paramCanvas.drawRect(localRectF, this.c);
            float f1 = localRectF.width() / 4.0F;
            float f2 = i / 2.0F;
            this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
            i = 0;
            while (i < this.a.length) {
                paramCanvas.drawCircle(localRectF.left + i * f1, f2, this.a[i], this.c);
                i += 1;
            }
            this.c.setXfermode(null);
            paramCanvas.restoreToCount(j);
            super.onDraw(paramCanvas);
            return;
        } finally {
        }
    }

    public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {
        int j = getMax() / 4;
        float f = j / 2.0F;
        int i = 0;
        for (; ; ) {
            if (i < 5) {
                if (Math.abs(paramInt - j * i) > f) {
                    break label60;
                }
                if (this.e != null) {
                    this.e.a(i);
                }
            }
            return;
            label60:
            i += 1;
        }
    }

    public void onStartTrackingTouch(SeekBar paramSeekBar) {
        if (this.e != null) {
            this.e.b(paramSeekBar);
        }
    }

    public void onStopTrackingTouch(SeekBar paramSeekBar) {
        int j = getMax() / 4;
        float f = j / 2.0F;
        int k = getProgress();
        int i = 0;
        for (; ; ) {
            if (i < 5) {
                if (Math.abs(k - j * i) <= f) {
                    setProgress(i * j);
                }
            } else {
                if (this.e != null) {
                    this.e.a(paramSeekBar);
                }
                return;
            }
            i += 1;
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        int i;
        float f1;
        float f3;
        float f4;
        float f5;
        if (paramMotionEvent.getAction() == 0) {
            i = getWidth();
            f1 = this.d;
            float f2 = i - this.d * 2.0F;
            f3 = f2 / 4.0F;
            f4 = f3 / 2.0F;
            f5 = paramMotionEvent.getX();
            if ((f5 > f1) && (f5 < f2 + f1)) {
                i = 0;
            }
        }
        for (; ; ) {
            if (i < 5) {
                if (Math.abs(f5 - f1 - i * f3) <= f4) {
                    paramMotionEvent.offsetLocation(i * f3 - (f5 - f1), 0.0F);
                }
            } else {
                return super.onTouchEvent(paramMotionEvent);
            }
            i += 1;
        }
    }

    public void setLevel(int paramInt) {
        if ((paramInt >= 0) && (paramInt < 5)) {
            setProgress(getMax() / 4 * paramInt);
        }
    }

    public void setSliderListener(a parama) {
        this.e = parama;
    }

    public static abstract interface a {
        public abstract void a(int paramInt);

        public abstract void a(SeekBar paramSeekBar);

        public abstract void b(SeekBar paramSeekBar);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/widget/FotorMosaicBrushSizeSlider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */