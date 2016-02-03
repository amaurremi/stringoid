package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public class as {
    static final av a = new at();

    static {
        if (Build.VERSION.SDK_INT >= 5) {
            a = new au();
            return;
        }
    }

    public static int a(MotionEvent paramMotionEvent) {
        return paramMotionEvent.getAction() & 0xFF;
    }

    public static int a(MotionEvent paramMotionEvent, int paramInt) {
        return a.a(paramMotionEvent, paramInt);
    }

    public static int b(MotionEvent paramMotionEvent) {
        return (paramMotionEvent.getAction() & 0xFF00) >> 8;
    }

    public static int b(MotionEvent paramMotionEvent, int paramInt) {
        return a.b(paramMotionEvent, paramInt);
    }

    public static float c(MotionEvent paramMotionEvent, int paramInt) {
        return a.c(paramMotionEvent, paramInt);
    }

    public static int c(MotionEvent paramMotionEvent) {
        return a.a(paramMotionEvent);
    }

    public static float d(MotionEvent paramMotionEvent, int paramInt) {
        return a.d(paramMotionEvent, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */