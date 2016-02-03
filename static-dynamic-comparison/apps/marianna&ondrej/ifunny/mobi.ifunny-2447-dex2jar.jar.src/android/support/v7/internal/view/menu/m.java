package android.support.v7.internal.view.menu;

import android.support.v4.b.a.b;
import android.view.MenuItem;
import android.view.SubMenu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

abstract class m<T>
        extends n<T> {
    private HashMap<MenuItem, b> b;
    private HashMap<SubMenu, SubMenu> c;

    m(T paramT) {
        super(paramT);
    }

    final b a(MenuItem paramMenuItem) {
        if (paramMenuItem != null) {
            if (this.b == null) {
                this.b = new HashMap();
            }
            b localb2 = (b) this.b.get(paramMenuItem);
            b localb1 = localb2;
            if (localb2 == null) {
                localb1 = ak.b(paramMenuItem);
                this.b.put(paramMenuItem, localb1);
            }
            return localb1;
        }
        return null;
    }

    final SubMenu a(SubMenu paramSubMenu) {
        if (paramSubMenu != null) {
            if (this.c == null) {
                this.c = new HashMap();
            }
            SubMenu localSubMenu = (SubMenu) this.c.get(paramSubMenu);
            Object localObject = localSubMenu;
            if (localSubMenu == null) {
                localObject = ak.a(paramSubMenu);
                this.c.put(paramSubMenu, localObject);
            }
            return (SubMenu) localObject;
        }
        return null;
    }

    final void a() {
        if (this.b != null) {
            this.b.clear();
        }
        if (this.c != null) {
            this.c.clear();
        }
    }

    final void a(int paramInt) {
        if (this.b == null) {
        }
        for (; ; ) {
            return;
            Iterator localIterator = this.b.keySet().iterator();
            while (localIterator.hasNext()) {
                if (paramInt == ((MenuItem) localIterator.next()).getGroupId()) {
                    localIterator.remove();
                }
            }
        }
    }

    final void b(int paramInt) {
        if (this.b == null) {
        }
        Iterator localIterator;
        do {
            return;
            while (!localIterator.hasNext()) {
                localIterator = this.b.keySet().iterator();
            }
        } while (paramInt != ((MenuItem) localIterator.next()).getItemId());
        localIterator.remove();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */