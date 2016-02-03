package com.etsy.android.grid;

import android.view.View;
import android.view.ViewConfiguration;

final class e
        implements Runnable {
    e(ExtendableListView paramExtendableListView) {
    }

    public void run() {
        if (ExtendableListView.c(this.a) == 3) {
            ExtendableListView.a(this.a, 4);
            View localView = this.a.getChildAt(ExtendableListView.a(this.a) - this.a.b);
            if ((localView != null) && (!localView.hasFocusable())) {
                ExtendableListView.b(this.a, 0);
                if (ExtendableListView.b(this.a)) {
                    break label175;
                }
                this.a.layoutChildren();
                localView.setPressed(true);
                this.a.setPressed(true);
                int i = ViewConfiguration.getLongPressTimeout();
                if (!this.a.isLongClickable()) {
                    break label165;
                }
                if (ExtendableListView.d(this.a) == null) {
                    ExtendableListView.a(this.a, new d(this.a, null));
                }
                ExtendableListView.d(this.a).a();
                this.a.postDelayed(ExtendableListView.d(this.a), i);
            }
        }
        return;
        label165:
        ExtendableListView.a(this.a, 5);
        return;
        label175:
        ExtendableListView.a(this.a, 5);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/etsy/android/grid/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */