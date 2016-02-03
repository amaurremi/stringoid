package com.everimaging.fotorsdk.store.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.store.R.attr;
import com.everimaging.fotorsdk.store.R.styleable;
import com.everimaging.fotorsdk.utils.UIUtils;
import com.everimaging.fotorsdk.widget.FotorTextButton;

public class PurchaseButton
        extends FotorTextButton {
    private static final String a = PurchaseButton.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private Drawable c;
    private Paint d;
    private Paint e;
    private boolean f;
    private int g;
    private float h;

    public PurchaseButton(Context paramContext) {
        this(paramContext, null);
    }

    public PurchaseButton(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, R.attr.fotorStorePurchasButtonStyle);
    }

    public PurchaseButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PurchaseButton, paramInt, 0);
        paramAttributeSet = paramContext.getDrawable(0);
        if (paramAttributeSet != null) {
            this.c = paramAttributeSet;
        }
        this.d = new Paint(1);
        this.g = paramContext.getDimensionPixelSize(1, (int) UIUtils.dip2px(2.0F));
        paramInt = paramContext.getColor(2, -16735489);
        this.d.setStyle(Paint.Style.FILL);
        this.d.setColor(paramInt);
        paramInt = paramContext.getColor(3, -8882056);
        this.e = new Paint(1);
        this.e.setStyle(Paint.Style.FILL);
        this.e.setColor(paramInt);
        paramContext.recycle();
    }

    public void a() {
        this.f = true;
    }

    public void a(float paramFloat) {
        if ((paramFloat < 0.0F) && (paramFloat > 1.0F)) {
            throw new IllegalStateException("invaild progress value,(0 ~ 1)");
        }
        if (!this.f) {
        }
        this.h = paramFloat;
        invalidate();
    }

    public void b() {
        this.f = false;
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        if (this.c != null) {
            this.c.draw(paramCanvas);
        }
        if (this.f) {
            int i = getHeight() - this.g;
            paramCanvas.drawRect(0.0F, i, getWidth(), getHeight(), this.e);
            float f1 = i;
            float f2 = getWidth();
            paramCanvas.drawRect(0.0F, f1, this.h * f2, getHeight(), this.d);
        }
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        if (this.c != null) {
            paramInt1 = getMeasuredWidth();
            paramInt2 = getMeasuredHeight();
            int i = Math.max(paramInt1, this.c.getIntrinsicWidth() + getPaddingLeft() + getPaddingRight());
            TextPaint localTextPaint = getPaint();
            float f1 = -localTextPaint.ascent();
            f1 = localTextPaint.descent() + f1 + (getPaddingTop() + getPaddingBottom()) + this.c.getIntrinsicHeight();
            paramInt1 = paramInt2;
            if (paramInt2 < f1) {
                paramInt1 = (int) (0.5F + f1);
            }
            setMeasuredDimension(i, this.g + paramInt1);
            paramInt2 = (i - this.c.getIntrinsicWidth()) / 2;
            paramInt1 -= getPaddingBottom();
            this.c.setBounds(paramInt2, paramInt1, this.c.getIntrinsicWidth() + paramInt2, this.c.getIntrinsicHeight() + paramInt1);
        }
    }

    public void setIconDrawable(Drawable paramDrawable) {
        this.c = paramDrawable;
        requestLayout();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/widget/PurchaseButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */