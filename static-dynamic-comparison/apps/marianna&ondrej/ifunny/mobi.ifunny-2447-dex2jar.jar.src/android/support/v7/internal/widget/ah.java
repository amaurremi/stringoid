package android.support.v7.internal.widget;

import android.view.View;

class ah
        implements Runnable {
    ah(ScrollingTabContainerView paramScrollingTabContainerView, View paramView) {
    }

    public void run() {
        int i = this.a.getLeft();
        int j = (this.b.getWidth() - this.a.getWidth()) / 2;
        this.b.smoothScrollTo(i - j, 0);
        this.b.a = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/widget/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */