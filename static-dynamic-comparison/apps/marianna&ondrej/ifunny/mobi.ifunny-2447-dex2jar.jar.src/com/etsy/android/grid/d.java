package com.etsy.android.grid;

import android.view.View;
import android.widget.ListAdapter;

class d
        extends l
        implements Runnable {
    private d(ExtendableListView paramExtendableListView) {
        super(paramExtendableListView, null);
    }

    public void run() {
        int i = ExtendableListView.a(this.a);
        View localView = this.a.getChildAt(i - this.a.b);
        long l;
        if (localView != null) {
            l = this.a.a.getItemId(i);
            if ((!b()) || (ExtendableListView.b(this.a))) {
                break label114;
            }
        }
        label114:
        for (boolean bool = ExtendableListView.a(this.a, localView, i, l); ; bool = false) {
            if (bool) {
                ExtendableListView.a(this.a, 0);
                this.a.setPressed(false);
                localView.setPressed(false);
                return;
            }
            ExtendableListView.a(this.a, 5);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/etsy/android/grid/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */