package android.support.v7.internal.view.menu;

import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class MenuWrapperFactory
{
  public static MenuItem createMenuItemWrapper(MenuItem paramMenuItem)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 16) {
      localObject = new MenuItemWrapperJB(paramMenuItem);
    }
    do
    {
      return (MenuItem)localObject;
      localObject = paramMenuItem;
    } while (Build.VERSION.SDK_INT < 14);
    return new MenuItemWrapperICS(paramMenuItem);
  }
  
  public static Menu createMenuWrapper(Menu paramMenu)
  {
    Object localObject = paramMenu;
    if (Build.VERSION.SDK_INT >= 14) {
      localObject = new MenuWrapperICS(paramMenu);
    }
    return (Menu)localObject;
  }
  
  public static SupportMenuItem createSupportMenuItemWrapper(MenuItem paramMenuItem)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new MenuItemWrapperJB(paramMenuItem);
    }
    if (Build.VERSION.SDK_INT >= 14) {
      return new MenuItemWrapperICS(paramMenuItem);
    }
    throw new UnsupportedOperationException();
  }
  
  public static SupportMenu createSupportMenuWrapper(Menu paramMenu)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return new MenuWrapperICS(paramMenu);
    }
    throw new UnsupportedOperationException();
  }
  
  public static SupportSubMenu createSupportSubMenuWrapper(SubMenu paramSubMenu)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return new SubMenuWrapperICS(paramSubMenu);
    }
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/internal/view/menu/MenuWrapperFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */