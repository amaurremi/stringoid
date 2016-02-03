package android.support.v4.view;

import android.view.MenuItem;

class ak
        extends aj {
    public MenuItem a(MenuItem paramMenuItem, an paraman) {
        if (paraman == null) {
            return ap.a(paramMenuItem, null);
        }
        return ap.a(paramMenuItem, new al(this, paraman));
    }

    public boolean b(MenuItem paramMenuItem) {
        return ap.a(paramMenuItem);
    }

    public boolean c(MenuItem paramMenuItem) {
        return ap.b(paramMenuItem);
    }

    public boolean d(MenuItem paramMenuItem) {
        return ap.c(paramMenuItem);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */