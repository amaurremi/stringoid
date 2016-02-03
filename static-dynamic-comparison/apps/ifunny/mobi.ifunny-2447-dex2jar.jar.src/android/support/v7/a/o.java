package android.support.v7.a;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.internal.view.c;
import android.support.v7.internal.view.menu.ak;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.Window.Callback;

class o
        extends h {
    Menu d;

    o(g paramg) {
        super(paramg);
    }

    public a a() {
        return new x(this.a, this.a);
    }

    public android.support.v7.c.a a(android.support.v7.c.b paramb) {
        if (paramb == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        Context localContext = j();
        c localc = a(localContext, paramb);
        paramb = null;
        ActionMode localActionMode = this.a.startActionMode(localc);
        if (localActionMode != null) {
            paramb = a(localContext, localActionMode);
            localc.a(paramb);
        }
        return paramb;
    }

    android.support.v7.internal.view.b a(Context paramContext, ActionMode paramActionMode) {
        return new android.support.v7.internal.view.b(paramContext, paramActionMode);
    }

    c a(Context paramContext, android.support.v7.c.b paramb) {
        return new c(paramContext, paramb);
    }

    Window.Callback a(Window.Callback paramCallback) {
        return new p(this, paramCallback);
    }

    public void a(int paramInt) {
        this.a.a_(paramInt);
    }

    public void a(Configuration paramConfiguration) {
    }

    public void a(Bundle paramBundle) {
        if ("splitActionBarWhenNarrow".equals(i())) {
            this.a.getWindow().setUiOptions(1, 1);
        }
        super.a(paramBundle);
        if (this.b) {
            this.a.requestWindowFeature(8);
        }
        if (this.c) {
            this.a.requestWindowFeature(9);
        }
        paramBundle = this.a.getWindow();
        paramBundle.setCallback(a(paramBundle.getCallback()));
    }

    public void a(ActionMode paramActionMode) {
        this.a.a(a(j(), paramActionMode));
    }

    public void a(View paramView) {
        this.a.a(paramView);
    }

    public void a(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
        this.a.a(paramView, paramLayoutParams);
    }

    public void a(CharSequence paramCharSequence) {
    }

    public boolean a(int paramInt, Menu paramMenu) {
        if ((paramInt == 0) || (paramInt == 8)) {
            if (this.d == null) {
                this.d = ak.a(paramMenu);
            }
            return this.a.a(paramInt, this.d);
        }
        return this.a.a(paramInt, paramMenu);
    }

    public boolean a(int paramInt, MenuItem paramMenuItem) {
        MenuItem localMenuItem = paramMenuItem;
        if (paramInt == 0) {
            localMenuItem = ak.a(paramMenuItem);
        }
        return this.a.a(paramInt, localMenuItem);
    }

    public boolean a(int paramInt, View paramView, Menu paramMenu) {
        if ((paramInt == 0) || (paramInt == 8)) {
            return this.a.a(paramInt, paramView, this.d);
        }
        return this.a.a(paramInt, paramView, paramMenu);
    }

    public View b(int paramInt) {
        return null;
    }

    public void b(ActionMode paramActionMode) {
        this.a.b(a(j(), paramActionMode));
    }

    public void b(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
        this.a.b(paramView, paramLayoutParams);
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
        this.d = null;
    }

    public boolean g() {
        return false;
    }

    public void h() {
        this.a.j();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */