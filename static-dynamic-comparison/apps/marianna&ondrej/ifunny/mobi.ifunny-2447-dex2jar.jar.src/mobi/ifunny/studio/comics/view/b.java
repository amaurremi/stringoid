package mobi.ifunny.studio.comics.view;

import android.database.DataSetObserver;

class b
        extends DataSetObserver {
    private b(EqualSpaceGridView paramEqualSpaceGridView) {
    }

    public void onChanged() {
        super.onChanged();
        EqualSpaceGridView.a(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */