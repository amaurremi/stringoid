package mobi.ifunny.studio.comics.view;

import android.database.DataSetObserver;

class f
        extends DataSetObserver {
    private f(HorizontalAdapterView paramHorizontalAdapterView) {
    }

    public void onChanged() {
        super.onChanged();
        HorizontalAdapterView.a(this.a, true);
        this.a.invalidate();
        this.a.requestLayout();
    }

    public void onInvalidated() {
        super.onInvalidated();
        HorizontalAdapterView.d(this.a, HorizontalAdapterView.b(this.a));
        this.a.invalidate();
        this.a.requestLayout();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/view/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */