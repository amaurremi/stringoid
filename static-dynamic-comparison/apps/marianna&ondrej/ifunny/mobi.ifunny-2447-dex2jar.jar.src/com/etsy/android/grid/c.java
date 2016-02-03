package com.etsy.android.grid;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.widget.ListAdapter;

class c
        extends DataSetObserver {
    private Parcelable b = null;

    c(ExtendableListView paramExtendableListView) {
    }

    public void onChanged() {
        this.a.n();
        ExtendableListView.a(this.a, true);
        ExtendableListView.d(this.a, ExtendableListView.e(this.a));
        ExtendableListView.e(this.a, this.a.getAdapter().getCount());
        ExtendableListView.f(this.a).c();
        if ((this.a.getAdapter().hasStableIds()) && (this.b != null) && (ExtendableListView.g(this.a) == 0) && (ExtendableListView.e(this.a) > 0)) {
            this.a.onRestoreInstanceState(this.b);
            this.b = null;
        }
        for (; ; ) {
            ExtendableListView.h(this.a);
            this.a.requestLayout();
            return;
            this.a.o();
        }
    }

    public void onInvalidated() {
        ExtendableListView.a(this.a, true);
        if (this.a.getAdapter().hasStableIds()) {
            this.b = this.a.onSaveInstanceState();
        }
        ExtendableListView.d(this.a, ExtendableListView.e(this.a));
        ExtendableListView.e(this.a, 0);
        this.a.j = false;
        ExtendableListView.h(this.a);
        this.a.requestLayout();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/etsy/android/grid/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */