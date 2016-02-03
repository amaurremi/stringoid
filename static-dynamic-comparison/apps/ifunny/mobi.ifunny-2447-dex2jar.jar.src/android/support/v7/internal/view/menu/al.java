package android.support.v7.internal.view.menu;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v4.b.a.a;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

class al
        extends m<Menu>
        implements a {
    al(Menu paramMenu) {
        super(paramMenu);
    }

    public MenuItem add(int paramInt) {
        return a(((Menu) this.a).add(paramInt));
    }

    public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        return a(((Menu) this.a).add(paramInt1, paramInt2, paramInt3, paramInt4));
    }

    public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence) {
        return a(((Menu) this.a).add(paramInt1, paramInt2, paramInt3, paramCharSequence));
    }

    public MenuItem add(CharSequence paramCharSequence) {
        return a(((Menu) this.a).add(paramCharSequence));
    }

    public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem) {
        MenuItem[] arrayOfMenuItem = null;
        if (paramArrayOfMenuItem != null) {
            arrayOfMenuItem = new MenuItem[paramArrayOfMenuItem.length];
        }
        paramInt2 = ((Menu) this.a).addIntentOptions(paramInt1, paramInt2, paramInt3, paramComponentName, paramArrayOfIntent, paramIntent, paramInt4, arrayOfMenuItem);
        if (arrayOfMenuItem != null) {
            paramInt1 = 0;
            paramInt3 = arrayOfMenuItem.length;
            while (paramInt1 < paramInt3) {
                paramArrayOfMenuItem[paramInt1] = a(arrayOfMenuItem[paramInt1]);
                paramInt1 += 1;
            }
        }
        return paramInt2;
    }

    public SubMenu addSubMenu(int paramInt) {
        return a(((Menu) this.a).addSubMenu(paramInt));
    }

    public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        return a(((Menu) this.a).addSubMenu(paramInt1, paramInt2, paramInt3, paramInt4));
    }

    public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence) {
        return a(((Menu) this.a).addSubMenu(paramInt1, paramInt2, paramInt3, paramCharSequence));
    }

    public SubMenu addSubMenu(CharSequence paramCharSequence) {
        return a(((Menu) this.a).addSubMenu(paramCharSequence));
    }

    public void clear() {
        a();
        ((Menu) this.a).clear();
    }

    public void close() {
        ((Menu) this.a).close();
    }

    public MenuItem findItem(int paramInt) {
        return a(((Menu) this.a).findItem(paramInt));
    }

    public MenuItem getItem(int paramInt) {
        return a(((Menu) this.a).getItem(paramInt));
    }

    public boolean hasVisibleItems() {
        return ((Menu) this.a).hasVisibleItems();
    }

    public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent) {
        return ((Menu) this.a).isShortcutKey(paramInt, paramKeyEvent);
    }

    public boolean performIdentifierAction(int paramInt1, int paramInt2) {
        return ((Menu) this.a).performIdentifierAction(paramInt1, paramInt2);
    }

    public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2) {
        return ((Menu) this.a).performShortcut(paramInt1, paramKeyEvent, paramInt2);
    }

    public void removeGroup(int paramInt) {
        a(paramInt);
        ((Menu) this.a).removeGroup(paramInt);
    }

    public void removeItem(int paramInt) {
        b(paramInt);
        ((Menu) this.a).removeItem(paramInt);
    }

    public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
        ((Menu) this.a).setGroupCheckable(paramInt, paramBoolean1, paramBoolean2);
    }

    public void setGroupEnabled(int paramInt, boolean paramBoolean) {
        ((Menu) this.a).setGroupEnabled(paramInt, paramBoolean);
    }

    public void setGroupVisible(int paramInt, boolean paramBoolean) {
        ((Menu) this.a).setGroupVisible(paramInt, paramBoolean);
    }

    public void setQwertyMode(boolean paramBoolean) {
        ((Menu) this.a).setQwertyMode(paramBoolean);
    }

    public int size() {
        return ((Menu) this.a).size();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */