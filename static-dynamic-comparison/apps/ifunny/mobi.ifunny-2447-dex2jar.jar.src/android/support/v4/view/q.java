package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

public class q {
    private final r a;

    public q(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener) {
        this(paramContext, paramOnGestureListener, null);
    }

    public q(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.a = new u(paramContext, paramOnGestureListener, paramHandler);
            return;
        }
        this.a = new s(paramContext, paramOnGestureListener, paramHandler);
    }

    public boolean a(MotionEvent paramMotionEvent) {
        return this.a.a(paramMotionEvent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */