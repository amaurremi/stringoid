package mobi.ifunny.view;

import android.database.DataSetObserver;

class i
        extends DataSetObserver {
    i(h paramh, DynamicStaggeredGridView paramDynamicStaggeredGridView) {
    }

    public void onChanged() {
        this.b.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.b.notifyDataSetInvalidated();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */