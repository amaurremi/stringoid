package mobi.ifunny.util;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class x
        implements ViewTreeObserver.OnGlobalLayoutListener {
    x(w paramw) {
    }

    public void onGlobalLayout() {
        int i = w.a(this.a).getRootView().getHeight();
        int j = w.a(this.a).getHeight();
        if ((i == 0) || (j == 0)) {
        }
        do {
            do {
                do {
                    do {
                        return;
                        if (i - j <= w.b(this.a)) {
                            break;
                        }
                    } while (w.c(this.a));
                    w.a(this.a, true);
                } while (w.d(this.a) == null);
                w.d(this.a).t();
                return;
            } while (!w.c(this.a));
            w.a(this.a, false);
        } while (w.d(this.a) == null);
        w.d(this.a).u();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */