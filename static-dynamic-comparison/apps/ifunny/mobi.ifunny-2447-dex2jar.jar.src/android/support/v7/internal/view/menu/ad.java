package android.support.v7.internal.view.menu;

import android.support.v4.view.n;
import android.support.v4.view.p;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

class ad
        extends x
        implements p {
    ActionProvider.VisibilityListener c;

    public ad(ac paramac, n paramn) {
        super(paramac, paramn);
    }

    public void a(boolean paramBoolean) {
        if (this.c != null) {
            this.c.onActionProviderVisibilityChanged(paramBoolean);
        }
    }

    public boolean isVisible() {
        return this.a.d();
    }

    public View onCreateActionView(MenuItem paramMenuItem) {
        return this.a.a(paramMenuItem);
    }

    public boolean overridesItemVisibility() {
        return this.a.c();
    }

    public void refreshVisibility() {
        this.a.e();
    }

    public void setVisibilityListener(ActionProvider.VisibilityListener paramVisibilityListener) {
        this.c = paramVisibilityListener;
        n localn = this.a;
        if (paramVisibilityListener != null) {
        }
        for (paramVisibilityListener = this; ; paramVisibilityListener = null) {
            localn.a(paramVisibilityListener);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */