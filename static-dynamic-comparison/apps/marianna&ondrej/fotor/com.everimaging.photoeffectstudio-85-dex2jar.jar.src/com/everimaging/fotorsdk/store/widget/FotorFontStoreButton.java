package com.everimaging.fotorsdk.store.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.everimaging.fotorsdk.store.R.attr;
import com.everimaging.fotorsdk.store.R.color;
import com.everimaging.fotorsdk.store.R.dimen;
import com.everimaging.fotorsdk.store.R.styleable;
import com.everimaging.fotorsdk.utils.TypefaceUtils;

public class FotorFontStoreButton
        extends ImageButton
        implements a {
    private int a = 0;
    private Paint b;
    private TextPaint c;
    private int d;
    private Typeface e;

    public FotorFontStoreButton(Context paramContext) {
        this(paramContext, null);
    }

    public FotorFontStoreButton(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, R.attr.fotorDefaultNavigateBtnStyle);
    }

    public FotorFontStoreButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        a(paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FotorNavigationButton, paramInt, 0));
        a();
    }

    private void a() {
        this.a = 0;
        this.b = new Paint();
        this.b.setAntiAlias(true);
        this.b.setColor(getResources().getColor(R.color.fotor_store_new_indicator));
        this.d = getResources().getDimensionPixelSize(R.dimen.fotor_store_entrance_btn_new_indicator_radius);
        this.c = new TextPaint();
        this.c.setAntiAlias(true);
        this.c.setColor(-1);
        this.c.setTextSize(getResources().getDimension(R.dimen.fotor_main_navigation_btn_textsize));
    }

    private void a(TypedArray paramTypedArray) {
        setTypeface(paramTypedArray.getString(2));
        paramTypedArray.recycle();
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        Object localObject2 = getDrawable();
        Object localObject1;
        int i;
        float f1;
        if ((this.a > 0) && (localObject2 != null)) {
            localObject1 = String.valueOf(this.a);
            i = this.d * 2;
            if (((String) localObject1).length() > 1) {
                i = this.d * 3;
            }
            int j = ((Drawable) localObject2).getIntrinsicWidth();
            ((Drawable) localObject2).getIntrinsicHeight();
            f1 = (getWidth() - j) / 2.0F + j;
            if (i / 2.0F + f1 <= getWidth()) {
                break label348;
            }
            f1 = getWidth() - i / 2.0F;
        }
        label348:
        for (; ; ) {
            float f2 = this.d + 2;
            if (((String) localObject1).length() <= 1) {
                paramCanvas.drawCircle(f1, f2, this.d, this.b);
            }
            for (; ; ) {
                this.c.setTypeface(this.e);
                localObject1 = new StaticLayout((CharSequence) localObject1, this.c, i, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
                paramCanvas.save();
                paramCanvas.translate(f1 - ((StaticLayout) localObject1).getWidth() / 2.0F, f2 - ((StaticLayout) localObject1).getHeight() / 2.0F);
                ((StaticLayout) localObject1).draw(paramCanvas);
                paramCanvas.restore();
                return;
                paramCanvas.drawCircle(f1 - this.d / 2.0F, f2, this.d, this.b);
                paramCanvas.drawCircle(this.d / 2.0F + f1, f2, this.d, this.b);
                localObject2 = new RectF();
                ((RectF) localObject2).left = (f1 - this.d / 2.0F);
                ((RectF) localObject2).top = (f2 - this.d);
                ((RectF) localObject2).right = (((RectF) localObject2).left + this.d);
                ((RectF) localObject2).bottom = (((RectF) localObject2).top + this.d * 2);
                paramCanvas.drawRect((RectF) localObject2, this.b);
            }
        }
    }

    public void setNewNum(int paramInt) {
        this.a = paramInt;
        invalidate();
    }

    public void setTypeface(String paramString) {
        if (paramString != null) {
        }
        try {
            this.e = TypefaceUtils.createFromAssetPath(getContext(), paramString);
            return;
        } catch (Throwable paramString) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/widget/FotorFontStoreButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */