package android.support.v4.view;

import android.view.MenuItem;

class ap {
    public static MenuItem a(MenuItem paramMenuItem, ar paramar) {
        return paramMenuItem.setOnActionExpandListener(new aq(paramar));
    }

    public static boolean a(MenuItem paramMenuItem) {
        return paramMenuItem.expandActionView();
    }

    public static boolean b(MenuItem paramMenuItem) {
        return paramMenuItem.collapseActionView();
    }

    public static boolean c(MenuItem paramMenuItem) {
        return paramMenuItem.isActionViewExpanded();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */