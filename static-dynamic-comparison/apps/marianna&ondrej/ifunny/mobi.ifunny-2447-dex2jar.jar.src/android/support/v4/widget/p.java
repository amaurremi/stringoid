package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

class p {
    public static Object a(Context paramContext) {
        return new EdgeEffect(paramContext);
    }

    public static void a(Object paramObject, int paramInt1, int paramInt2) {
        ((EdgeEffect) paramObject).setSize(paramInt1, paramInt2);
    }

    public static boolean a(Object paramObject) {
        return ((EdgeEffect) paramObject).isFinished();
    }

    public static boolean a(Object paramObject, float paramFloat) {
        ((EdgeEffect) paramObject).onPull(paramFloat);
        return true;
    }

    public static boolean a(Object paramObject, Canvas paramCanvas) {
        return ((EdgeEffect) paramObject).draw(paramCanvas);
    }

    public static void b(Object paramObject) {
        ((EdgeEffect) paramObject).finish();
    }

    public static boolean c(Object paramObject) {
        paramObject = (EdgeEffect) paramObject;
        ((EdgeEffect) paramObject).onRelease();
        return ((EdgeEffect) paramObject).isFinished();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/widget/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */