package android.support.v7.internal.view.menu;

import android.os.Build.VERSION;
import android.support.v4.b.a.b;
import android.support.v4.b.a.c;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class af
{
  public static c a(SubMenu paramSubMenu)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return new ai(paramSubMenu);
    }
    throw new UnsupportedOperationException();
  }
  
  public static Menu a(Menu paramMenu)
  {
    Object localObject = paramMenu;
    if (Build.VERSION.SDK_INT >= 14) {
      localObject = new ag(paramMenu);
    }
    return (Menu)localObject;
  }
  
  public static MenuItem a(MenuItem paramMenuItem)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 16) {
      localObject = new x(paramMenuItem);
    }
    do
    {
      return (MenuItem)localObject;
      localObject = paramMenuItem;
    } while (Build.VERSION.SDK_INT < 14);
    return new t(paramMenuItem);
  }
  
  public static b b(MenuItem paramMenuItem)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new x(paramMenuItem);
    }
    if (Build.VERSION.SDK_INT >= 14) {
      return new t(paramMenuItem);
    }
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/menu/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */