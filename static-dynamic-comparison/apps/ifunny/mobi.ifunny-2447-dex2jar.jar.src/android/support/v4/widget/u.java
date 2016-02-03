package android.support.v4.widget;

import android.support.v4.view.bd;
import android.view.View;

import java.util.ArrayList;

class u
        implements Runnable {
    final View a;

    u(SlidingPaneLayout paramSlidingPaneLayout, View paramView) {
        this.a = paramView;
    }

    public void run() {
        if (this.a.getParent() == this.b) {
            bd.a(this.a, 0, null);
            SlidingPaneLayout.a(this.b, this.a);
        }
        SlidingPaneLayout.a(this.b).remove(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/widget/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */