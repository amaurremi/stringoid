package android.support.v7.internal.widget;

import android.database.DataSetObserver;

class z
        extends DataSetObserver {
    private z(u paramu) {
    }

    public void onChanged() {
        if (this.a.f()) {
            this.a.c();
        }
    }

    public void onInvalidated() {
        this.a.d();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/widget/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */