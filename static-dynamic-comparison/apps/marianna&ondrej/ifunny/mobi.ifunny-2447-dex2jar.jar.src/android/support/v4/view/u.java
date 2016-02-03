package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

class u
        implements r {
    private final GestureDetector a;

    public u(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler) {
        this.a = new GestureDetector(paramContext, paramOnGestureListener, paramHandler);
    }

    public boolean a(MotionEvent paramMotionEvent) {
        return this.a.onTouchEvent(paramMotionEvent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */