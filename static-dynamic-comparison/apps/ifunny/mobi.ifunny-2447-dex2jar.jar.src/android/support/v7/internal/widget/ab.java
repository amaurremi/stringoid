package android.support.v7.internal.widget;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;

class ab
        implements View.OnTouchListener {
    private ab(u paramu) {
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
        int i = paramMotionEvent.getAction();
        int j = (int) paramMotionEvent.getX();
        int k = (int) paramMotionEvent.getY();
        if ((i == 0) && (u.b(this.a) != null) && (u.b(this.a).isShowing()) && (j >= 0) && (j < u.b(this.a).getWidth()) && (k >= 0) && (k < u.b(this.a).getHeight())) {
            u.d(this.a).postDelayed(u.c(this.a), 250L);
        }
        for (; ; ) {
            return false;
            if (i == 1) {
                u.d(this.a).removeCallbacks(u.c(this.a));
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/widget/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */