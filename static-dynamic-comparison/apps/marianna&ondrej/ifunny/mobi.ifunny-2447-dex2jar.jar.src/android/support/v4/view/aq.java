package android.support.v4.view;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

class aq
        implements MenuItem.OnActionExpandListener {
    private ar a;

    public aq(ar paramar) {
        this.a = paramar;
    }

    public boolean onMenuItemActionCollapse(MenuItem paramMenuItem) {
        return this.a.b(paramMenuItem);
    }

    public boolean onMenuItemActionExpand(MenuItem paramMenuItem) {
        return this.a.a(paramMenuItem);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */