package com.everimaging.fotorsdk.widget.lib.hlist.util.v11;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.everimaging.fotorsdk.widget.lib.hlist.AbsHListView;

public class b
        implements a {
    private a a;
    private AbsHListView b;

    public b(AbsHListView paramAbsHListView) {
        this.b = paramAbsHListView;
    }

    @TargetApi(11)
    public void a(ActionMode paramActionMode, int paramInt, long paramLong, boolean paramBoolean) {
        this.a.a(paramActionMode, paramInt, paramLong, paramBoolean);
        if (this.b.getCheckedItemCount() == 0) {
            paramActionMode.finish();
        }
    }

    public void a(a parama) {
        this.a = parama;
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem) {
        return this.a.onActionItemClicked(paramActionMode, paramMenuItem);
    }

    public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu) {
        boolean bool = false;
        if (this.a.onCreateActionMode(paramActionMode, paramMenu)) {
            this.b.setLongClickable(false);
            bool = true;
        }
        return bool;
    }

    public void onDestroyActionMode(ActionMode paramActionMode) {
        this.a.onDestroyActionMode(paramActionMode);
        this.b.c = null;
        this.b.b();
        this.b.ai = true;
        this.b.x();
        this.b.requestLayout();
        this.b.setLongClickable(true);
    }

    public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu) {
        return this.a.onPrepareActionMode(paramActionMode, paramMenu);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/lib/hlist/util/v11/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */