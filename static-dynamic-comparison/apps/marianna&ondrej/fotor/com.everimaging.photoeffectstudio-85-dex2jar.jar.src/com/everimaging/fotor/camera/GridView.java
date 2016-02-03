package com.everimaging.fotor.camera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

public class GridView
        extends ImageView {
    private Paint a = new Paint();
    private float b = 0.0F;

    public GridView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        this.a.setColor(-1);
        this.a.setStrokeWidth(2.0F);
    }

    protected void onDraw(Canvas paramCanvas) {
        int k;
        float f2;
        if (this.b == 0.0F) {
            j = getWidth() / 3;
            k = getHeight() / 3;
            i = 1;
            while (i <= 2) {
                f1 = j * i;
                f2 = k * i;
                paramCanvas.drawLine(f1, 0.0F, f1, getHeight(), this.a);
                paramCanvas.drawLine(0.0F, f2, getWidth(), f2, this.a);
                i += 1;
            }
        }
        int i = getHeight();
        int j = getWidth();
        float f1 = j * 1.0F / i;
        if (f1 > this.b) {
            k = (int) (i * this.b);
            j = i;
            i = k;
        }
        for (; ; ) {
            int m = (getWidth() - i) / 2;
            int n = (getHeight() - j) / 2;
            int i1 = i / 3;
            int i2 = j / 3;
            k = 1;
            for (; ; ) {
                if (k <= 2) {
                    f1 = i1 * k + m;
                    f2 = i2 * k + n;
                    paramCanvas.drawLine(f1, n, f1, j + n, this.a);
                    paramCanvas.drawLine(m, f2, i + m, f2, this.a);
                    k += 1;
                    continue;
                    if (f1 >= this.b) {
                        break label281;
                    }
                    k = (int) (j / this.b);
                    i = j;
                    j = k;
                    break;
                }
            }
            return;
            label281:
            k = i;
            i = j;
            j = k;
        }
    }

    public void setRatio(float paramFloat) {
        this.b = paramFloat;
        invalidate();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/camera/GridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */