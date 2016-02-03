package fr.castorflex.android.smoothprogressbar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.Shape;

public class a
        extends Shape {
    private float a;
    private int[] b;

    public a(float paramFloat, int[] paramArrayOfInt) {
        this.a = paramFloat;
        this.b = paramArrayOfInt;
    }

    public void draw(Canvas paramCanvas, Paint paramPaint) {
        int j = 0;
        float f1 = 1.0F / this.b.length;
        paramPaint.setStrokeWidth(this.a);
        int[] arrayOfInt = this.b;
        int k = arrayOfInt.length;
        int i = 0;
        while (i < k) {
            paramPaint.setColor(arrayOfInt[i]);
            float f2 = j;
            float f3 = getWidth();
            float f4 = getHeight() / 2.0F;
            j += 1;
            float f5 = j;
            paramCanvas.drawLine(f2 * f1 * f3, f4, getWidth() * (f5 * f1), getHeight() / 2.0F, paramPaint);
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/fr/castorflex/android/smoothprogressbar/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */