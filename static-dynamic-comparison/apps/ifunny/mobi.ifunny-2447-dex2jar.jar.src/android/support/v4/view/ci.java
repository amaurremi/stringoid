package android.support.v4.view;

import android.database.DataSetObserver;

class ci
        extends DataSetObserver {
    private ci(ViewPager paramViewPager) {
    }

    public void onChanged() {
        this.a.b();
    }

    public void onInvalidated() {
        this.a.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */