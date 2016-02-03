package com.etsy.android.grid;

import android.view.View;
import android.widget.ListAdapter;

class j
        extends l
        implements Runnable {
    int a;

    private j(ExtendableListView paramExtendableListView) {
        super(paramExtendableListView, null);
    }

    public void run() {
        if (ExtendableListView.b(this.b)) {
        }
        ListAdapter localListAdapter;
        int i;
        View localView;
        int j;
        do {
            do {
                do {
                    return;
                    localListAdapter = this.b.a;
                    i = this.a;
                }
                while ((localListAdapter == null) || (ExtendableListView.e(this.b) <= 0) || (i == -1) || (i >= localListAdapter.getCount()) || (!b()));
                localView = this.b.getChildAt(i - this.b.b);
            } while (localView == null);
            j = this.b.getHeaderViewsCount();
        } while ((i < j) || (i >= localListAdapter.getCount() - this.b.getFooterViewsCount()));
        this.b.performItemClick(localView, i - j, localListAdapter.getItemId(i));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/etsy/android/grid/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */