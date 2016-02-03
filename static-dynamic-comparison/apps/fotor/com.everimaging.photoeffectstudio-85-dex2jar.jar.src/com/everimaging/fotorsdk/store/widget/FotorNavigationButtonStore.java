package com.everimaging.fotorsdk.store.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.everimaging.fotorsdk.store.R.color;
import com.everimaging.fotorsdk.store.R.dimen;
import com.everimaging.fotorsdk.widget.FotorNavigationButton;

public class FotorNavigationButtonStore
        extends FotorNavigationButton
        implements a {
    private int F;
    private int a = 0;
    private Paint b;
    private TextPaint c;

    public FotorNavigationButtonStore(Context paramContext) {
        super(paramContext);
        c();
    }

    public FotorNavigationButtonStore(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        c();
    }

    public FotorNavigationButtonStore(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        c();
    }

    private void c() {
        this.a = 0;
        this.b = new Paint();
        this.b.setAntiAlias(true);
        this.b.setColor(getResources().getColor(R.color.fotor_store_new_indicator));
        this.F = getResources().getDimensionPixelSize(R.dimen.fotor_store_entrance_btn_new_indicator_radius);
        this.c = new TextPaint();
        this.c.setAntiAlias(true);
        this.c.setColor(-1);
        this.c.setTextSize(getResources().getDimension(R.dimen.fotor_main_navigation_btn_textsize));
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        Object localObject;
        int i;
        float f1;
        if (this.a > 0) {
            localObject = String.valueOf(this.a);
            i = this.F * 2;
            if (((String) localObject).length() > 1) {
                i = this.F * 3;
            }
            f1 = this.g.right;
            if (i / 2.0F + f1 <= getWidth()) {
                break label338;
            }
            f1 = getWidth() - i / 2.0F;
        }
        label338:
        for (; ; ) {
            float f2 = this.g.top;
            if (f2 - this.F < 0.0F) {
                f2 = this.F;
            }
            for (; ; ) {
                if (((String) localObject).length() <= 1) {
                    paramCanvas.drawCircle(f1, f2, this.F, this.b);
                }
                for (; ; ) {
                    this.c.setTypeface(this.r);
                    localObject = new StaticLayout((CharSequence) localObject, this.c, i, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
                    paramCanvas.save();
                    paramCanvas.translate(f1 - ((StaticLayout) localObject).getWidth() / 2.0F, f2 - ((StaticLayout) localObject).getHeight() / 2.0F);
                    ((StaticLayout) localObject).draw(paramCanvas);
                    paramCanvas.restore();
                    return;
                    paramCanvas.drawCircle(f1 - this.F / 2.0F, f2, this.F, this.b);
                    paramCanvas.drawCircle(this.F / 2.0F + f1, f2, this.F, this.b);
                    RectF localRectF = new RectF();
                    localRectF.left = (f1 - this.F / 2.0F);
                    localRectF.top = (f2 - this.F);
                    localRectF.right = (localRectF.left + this.F);
                    localRectF.bottom = (localRectF.top + this.F * 2);
                    paramCanvas.drawRect(localRectF, this.b);
                }
            }
        }
    }

    public void setNewNum(int paramInt) {
        this.a = paramInt;
        invalidate();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/widget/FotorNavigationButtonStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */