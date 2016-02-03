package mobi.ifunny.view;

import android.database.DataSetObserver;

class g
        extends DataSetObserver {
    g(e parame, DynamicListView paramDynamicListView) {
    }

    public void onChanged() {
        this.b.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.b.notifyDataSetInvalidated();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */