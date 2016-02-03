package android.support.v7.a;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;

class w
        implements ActionMode.Callback {
    private final ActionMode.Callback b;

    w(v paramv, ActionMode.Callback paramCallback) {
        this.b = paramCallback;
    }

    public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem) {
        return this.b.onActionItemClicked(paramActionMode, paramMenuItem);
    }

    public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu) {
        boolean bool = this.b.onCreateActionMode(paramActionMode, paramMenu);
        if (bool) {
            v.a(this.a, paramActionMode);
            this.a.k();
        }
        return bool;
    }

    public void onDestroyActionMode(ActionMode paramActionMode) {
        this.b.onDestroyActionMode(paramActionMode);
        this.a.l();
        v.a(this.a, null);
    }

    public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu) {
        return this.b.onPrepareActionMode(paramActionMode, paramMenu);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */