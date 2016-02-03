package com.etsy.android.grid;

import android.view.View;

class b
        implements Runnable {
    b(ExtendableListView paramExtendableListView, View paramView, j paramj) {
    }

    public void run() {
        this.a.setPressed(false);
        this.c.setPressed(false);
        if (!ExtendableListView.b(this.c)) {
            this.c.post(this.b);
        }
        ExtendableListView.a(this.c, 0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/etsy/android/grid/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */