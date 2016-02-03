package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class n {
    private final Context a;
    private o b;
    private p c;

    public Context a() {
        return this.a;
    }

    public View a(MenuItem paramMenuItem) {
        return b();
    }

    public void a(o paramo) {
        this.b = paramo;
    }

    public void a(p paramp) {
        if ((this.c != null) && (paramp != null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.c = paramp;
    }

    public void a(SubMenu paramSubMenu) {
    }

    public abstract View b();

    public boolean c() {
        return false;
    }

    public boolean d() {
        return true;
    }

    public void e() {
        if ((this.c != null) && (c())) {
            this.c.a(d());
        }
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */