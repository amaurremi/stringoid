package android.support.v7.internal.view.menu;

import android.os.Build.VERSION;
import android.support.v4.b.a.b;
import android.support.v4.b.a.c;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class ak {
    public static c a(SubMenu paramSubMenu) {
        if (Build.VERSION.SDK_INT >= 14) {
            return new an(paramSubMenu);
        }
        throw new UnsupportedOperationException();
    }

    public static Menu a(Menu paramMenu) {
        Object localObject = paramMenu;
        if (Build.VERSION.SDK_INT >= 14) {
            localObject = new al(paramMenu);
        }
        return (Menu) localObject;
    }

    public static MenuItem a(MenuItem paramMenuItem) {
        Object localObject;
        if (Build.VERSION.SDK_INT >= 16) {
            localObject = new ac(paramMenuItem);
        }
        do {
            return (MenuItem) localObject;
            localObject = paramMenuItem;
        } while (Build.VERSION.SDK_INT < 14);
        return new w(paramMenuItem);
    }

    public static b b(MenuItem paramMenuItem) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new ac(paramMenuItem);
        }
        if (Build.VERSION.SDK_INT >= 14) {
            return new w(paramMenuItem);
        }
        throw new UnsupportedOperationException();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */