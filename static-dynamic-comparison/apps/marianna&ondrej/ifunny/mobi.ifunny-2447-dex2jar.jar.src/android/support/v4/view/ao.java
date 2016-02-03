package android.support.v4.view;

import android.view.MenuItem;
import android.view.View;

class ao {
    public static MenuItem a(MenuItem paramMenuItem, View paramView) {
        return paramMenuItem.setActionView(paramView);
    }

    public static View a(MenuItem paramMenuItem) {
        return paramMenuItem.getActionView();
    }

    public static void a(MenuItem paramMenuItem, int paramInt) {
        paramMenuItem.setShowAsAction(paramInt);
    }

    public static MenuItem b(MenuItem paramMenuItem, int paramInt) {
        return paramMenuItem.setActionView(paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */