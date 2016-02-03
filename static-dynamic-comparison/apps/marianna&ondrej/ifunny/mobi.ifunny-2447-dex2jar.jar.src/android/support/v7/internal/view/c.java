package android.support.v7.internal.view;

import android.content.Context;
import android.support.v7.c.a;
import android.support.v7.internal.view.menu.ak;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;

public class c
        implements ActionMode.Callback {
    final android.support.v7.c.b a;
    final Context b;
    private b c;

    public c(Context paramContext, android.support.v7.c.b paramb) {
        this.b = paramContext;
        this.a = paramb;
    }

    private a a(ActionMode paramActionMode) {
        if ((this.c != null) && (this.c.b == paramActionMode)) {
            return this.c;
        }
        return a(this.b, paramActionMode);
    }

    protected b a(Context paramContext, ActionMode paramActionMode) {
        return new b(paramContext, paramActionMode);
    }

    public void a(b paramb) {
        this.c = paramb;
    }

    public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem) {
        return this.a.a(a(paramActionMode), ak.a(paramMenuItem));
    }

    public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu) {
        return this.a.a(a(paramActionMode), ak.a(paramMenu));
    }

    public void onDestroyActionMode(ActionMode paramActionMode) {
        this.a.a(a(paramActionMode));
    }

    public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu) {
        return this.a.b(a(paramActionMode), ak.a(paramMenu));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */