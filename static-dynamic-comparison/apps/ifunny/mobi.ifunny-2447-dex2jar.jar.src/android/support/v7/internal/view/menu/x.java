package android.support.v7.internal.view.menu;

import android.support.v4.view.n;
import android.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;

class x
        extends ActionProvider {
    final n a;

    public x(w paramw, n paramn) {
        super(paramn.a());
        this.a = paramn;
        if (w.a(paramw)) {
            this.a.a(new y(this, paramw));
        }
    }

    public boolean hasSubMenu() {
        return this.a.g();
    }

    public View onCreateActionView() {
        if (w.a(this.b)) {
            this.b.c();
        }
        return this.a.b();
    }

    public boolean onPerformDefaultAction() {
        return this.a.f();
    }

    public void onPrepareSubMenu(SubMenu paramSubMenu) {
        this.a.a(this.b.a(paramSubMenu));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */