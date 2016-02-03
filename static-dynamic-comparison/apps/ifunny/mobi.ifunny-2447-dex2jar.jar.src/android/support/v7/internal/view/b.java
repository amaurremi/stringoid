package android.support.v7.internal.view;

import android.content.Context;
import android.support.v7.c.a;
import android.support.v7.internal.view.menu.ak;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;

public class b
        extends a {
    final MenuInflater a;
    final ActionMode b;

    public b(Context paramContext, ActionMode paramActionMode) {
        this.b = paramActionMode;
        this.a = new f(paramContext);
    }

    public Menu a() {
        return ak.a(this.b.getMenu());
    }

    public void a(CharSequence paramCharSequence) {
        this.b.setTitle(paramCharSequence);
    }

    public void b() {
        this.b.finish();
    }

    public void c() {
        this.b.invalidate();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */