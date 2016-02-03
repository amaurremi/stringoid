package mobi.ifunny.comments;

import android.content.res.Resources;
import android.support.v4.app.k;
import android.support.v7.c.a;
import android.support.v7.c.b;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

class v
        implements b {
    private v(CommentsFragment paramCommentsFragment) {
    }

    public void a(a parama) {
        if (parama == CommentsFragment.c(this.a)) {
            CommentsFragment.a(this.a, null);
            CommentsFragment.d(this.a);
        }
    }

    public boolean a(a parama, Menu paramMenu) {
        this.a.getActivity().getMenuInflater().inflate(2131820549, paramMenu);
        return true;
    }

    public boolean a(a parama, MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131493387) {
            CommentsFragment.a(this.a, this.a.getString(2131689518));
        }
        return false;
    }

    public boolean b(a parama, Menu paramMenu) {
        parama.a(this.a.getResources().getString(2131689547, new Object[]{Integer.valueOf(this.a.h().d())}));
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */