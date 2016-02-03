package android.support.v7.internal.widget;

import android.widget.PopupWindow;

class ac
        implements Runnable {
    private ac(u paramu) {
    }

    public void run() {
        if ((u.a(this.a) != null) && (u.a(this.a).getCount() > u.a(this.a).getChildCount()) && (u.a(this.a).getChildCount() <= this.a.a)) {
            u.b(this.a).setInputMethodMode(2);
            this.a.c();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/widget/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */