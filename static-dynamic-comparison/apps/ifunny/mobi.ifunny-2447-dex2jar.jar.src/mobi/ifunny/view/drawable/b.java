package mobi.ifunny.view.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

public class b
        extends Drawable {
    private int a;
    private int b;
    private int c;
    private int d;
    private Paint e;

    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramInt3;
        this.d = paramInt4;
        this.e = new Paint(3);
        this.e.setStyle(Paint.Style.FILL);
        this.e.setColor(paramInt3);
    }

    public int a() {
        return this.a;
    }

    public void a(int paramInt) {
        this.a = paramInt;
        if (getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public void draw(Canvas paramCanvas) {
        float f = this.b;
        int i = 0;
        while (i < this.a) {
            paramCanvas.drawCircle(f, this.b, this.b, this.e);
            f += this.b * 2 + this.d;
            i += 1;
        }
    }

    public int getIntrinsicHeight() {
        return this.b * 2;
    }

    public int getIntrinsicWidth() {
        return this.b * 2 * this.a + this.d * (this.a - 1);
    }

    public int getOpacity() {
        return -1;
    }

    public void setAlpha(int paramInt) {
    }

    public void setColorFilter(ColorFilter paramColorFilter) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/drawable/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */