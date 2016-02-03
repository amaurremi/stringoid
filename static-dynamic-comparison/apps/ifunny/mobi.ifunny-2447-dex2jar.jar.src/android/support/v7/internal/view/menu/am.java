package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class am
        extends q
        implements SubMenu {
    private q d;
    private u e;

    public am(Context paramContext, q paramq, u paramu) {
        super(paramContext);
        this.d = paramq;
        this.e = paramu;
    }

    public String a() {
        if (this.e != null) {
        }
        for (int i = this.e.getItemId(); i == 0; i = 0) {
            return null;
        }
        return super.a() + ":" + i;
    }

    public void a(r paramr) {
        this.d.a(paramr);
    }

    public boolean a(q paramq, MenuItem paramMenuItem) {
        return (super.a(paramq, paramMenuItem)) || (this.d.a(paramq, paramMenuItem));
    }

    public boolean b() {
        return this.d.b();
    }

    public boolean c() {
        return this.d.c();
    }

    public boolean c(u paramu) {
        return this.d.c(paramu);
    }

    public void clearHeader() {
    }

    public boolean d(u paramu) {
        return this.d.d(paramu);
    }

    public MenuItem getItem() {
        return this.e;
    }

    public q p() {
        return this.d;
    }

    public Menu s() {
        return this.d;
    }

    public SubMenu setHeaderIcon(int paramInt) {
        super.a(e().getResources().getDrawable(paramInt));
        return this;
    }

    public SubMenu setHeaderIcon(Drawable paramDrawable) {
        super.a(paramDrawable);
        return this;
    }

    public SubMenu setHeaderTitle(int paramInt) {
        super.a(e().getResources().getString(paramInt));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence paramCharSequence) {
        super.a(paramCharSequence);
        return this;
    }

    public SubMenu setHeaderView(View paramView) {
        super.a(paramView);
        return this;
    }

    public SubMenu setIcon(int paramInt) {
        this.e.setIcon(paramInt);
        return this;
    }

    public SubMenu setIcon(Drawable paramDrawable) {
        this.e.setIcon(paramDrawable);
        return this;
    }

    public void setQwertyMode(boolean paramBoolean) {
        this.d.setQwertyMode(paramBoolean);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */