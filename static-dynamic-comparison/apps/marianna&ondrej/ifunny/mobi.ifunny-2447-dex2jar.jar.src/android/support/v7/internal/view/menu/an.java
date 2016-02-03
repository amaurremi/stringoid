package android.support.v7.internal.view.menu;

import android.graphics.drawable.Drawable;
import android.support.v4.b.a.c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

class an
        extends al
        implements c {
    an(SubMenu paramSubMenu) {
        super(paramSubMenu);
    }

    public void clearHeader() {
        ((SubMenu) this.a).clearHeader();
    }

    public MenuItem getItem() {
        return a(((SubMenu) this.a).getItem());
    }

    public SubMenu setHeaderIcon(int paramInt) {
        ((SubMenu) this.a).setHeaderIcon(paramInt);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable paramDrawable) {
        ((SubMenu) this.a).setHeaderIcon(paramDrawable);
        return this;
    }

    public SubMenu setHeaderTitle(int paramInt) {
        ((SubMenu) this.a).setHeaderTitle(paramInt);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence paramCharSequence) {
        ((SubMenu) this.a).setHeaderTitle(paramCharSequence);
        return this;
    }

    public SubMenu setHeaderView(View paramView) {
        ((SubMenu) this.a).setHeaderView(paramView);
        return this;
    }

    public SubMenu setIcon(int paramInt) {
        ((SubMenu) this.a).setIcon(paramInt);
        return this;
    }

    public SubMenu setIcon(Drawable paramDrawable) {
        ((SubMenu) this.a).setIcon(paramDrawable);
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */