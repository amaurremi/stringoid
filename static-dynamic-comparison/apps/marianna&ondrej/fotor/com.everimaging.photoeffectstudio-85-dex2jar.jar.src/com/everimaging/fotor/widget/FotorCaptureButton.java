package com.everimaging.fotor.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;
import com.everimaging.photoeffectstudio.R.styleable;

public class FotorCaptureButton
        extends ImageButton {
    private static final String a = FotorCaptureButton.class.getSimpleName();
    private static final LoggerFactory.c b = LoggerFactory.a(a, LoggerFactory.LoggerType.CONSOLE);
    private int c;
    private int d;
    private Drawable e;
    private Point f = new Point();
    private boolean g;

    public FotorCaptureButton(Context paramContext) {
        super(paramContext);
        a(paramContext);
    }

    public FotorCaptureButton(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 2130772246);
    }

    public FotorCaptureButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FotorCaptureButton, paramInt, 0);
        Drawable localDrawable = paramAttributeSet.getDrawable(0);
        if (localDrawable != null) {
            this.e = localDrawable;
        }
        paramAttributeSet.recycle();
        a(paramContext);
    }

    private void a(Context paramContext) {
        setBackgroundColor(0);
        setFocusable(true);
    }

    private void a(Canvas paramCanvas) {
        if (this.e != null) {
            if (this.g) {
                this.e.setBounds(0, 0, this.c, this.d);
                this.g = false;
            }
            this.e.draw(paramCanvas);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable localDrawable = this.e;
        if ((localDrawable != null) && (localDrawable.isStateful())) {
            this.e.setState(getDrawableState());
            invalidate();
        }
    }

    protected void onDraw(Canvas paramCanvas) {
        a(paramCanvas);
        super.onDraw(paramCanvas);
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.c = (paramInt3 - paramInt1);
        this.d = (paramInt4 - paramInt2);
        b.c(new Object[]{"thisW:" + this.c, "thisH:" + this.d});
        this.f.x = (this.c / 2);
        this.f.y = (this.d / 2);
        if (paramBoolean) {
            this.g = true;
        }
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/widget/FotorCaptureButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */