package android.support.v7.internal.view.menu;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ab
        extends n<MenuItem.OnMenuItemClickListener>
        implements MenuItem.OnMenuItemClickListener {
    ab(w paramw, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener) {
        super(paramOnMenuItemClickListener);
    }

    public boolean onMenuItemClick(MenuItem paramMenuItem) {
        return ((MenuItem.OnMenuItemClickListener) this.a).onMenuItemClick(this.b.a(paramMenuItem));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */