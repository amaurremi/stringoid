package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public class l {
    private static final o b = new m();
    private Object a;

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            b = new n();
            return;
        }
    }

    public l(Context paramContext) {
        this.a = b.a(paramContext);
    }

    public void a(int paramInt1, int paramInt2) {
        b.a(this.a, paramInt1, paramInt2);
    }

    public boolean a() {
        return b.a(this.a);
    }

    public boolean a(float paramFloat) {
        return b.a(this.a, paramFloat);
    }

    public boolean a(Canvas paramCanvas) {
        return b.a(this.a, paramCanvas);
    }

    public void b() {
        b.b(this.a);
    }

    public boolean c() {
        return b.c(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/widget/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */