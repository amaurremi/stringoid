package android.support.v4.widget;

import android.database.DataSetObserver;

class d
        extends DataSetObserver {
    private d(a parama) {
    }

    public void onChanged() {
        this.a.a = true;
        this.a.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.a.a = false;
        this.a.notifyDataSetInvalidated();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/widget/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */