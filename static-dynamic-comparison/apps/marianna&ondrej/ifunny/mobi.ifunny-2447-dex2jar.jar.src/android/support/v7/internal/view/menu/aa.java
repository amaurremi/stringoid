package android.support.v7.internal.view.menu;

import android.support.v4.view.an;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

class aa
        extends n<an>
        implements MenuItem.OnActionExpandListener {
    aa(w paramw, an paraman) {
        super(paraman);
    }

    public boolean onMenuItemActionCollapse(MenuItem paramMenuItem) {
        return ((an) this.a).b(this.b.a(paramMenuItem));
    }

    public boolean onMenuItemActionExpand(MenuItem paramMenuItem) {
        return ((an) this.a).a(this.b.a(paramMenuItem));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */