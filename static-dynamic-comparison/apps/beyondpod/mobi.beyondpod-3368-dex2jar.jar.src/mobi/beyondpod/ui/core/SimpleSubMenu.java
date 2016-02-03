package mobi.beyondpod.ui.core;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class SimpleSubMenu
  extends SimpleMenu
  implements SubMenu
{
  private SimpleMenuItem mItem;
  private SimpleMenu mParentMenu;
  
  public SimpleSubMenu(Context paramContext, SimpleMenu paramSimpleMenu, SimpleMenuItem paramSimpleMenuItem)
  {
    super(paramContext);
    this.mParentMenu = paramSimpleMenu;
    this.mItem = paramSimpleMenuItem;
  }
  
  public void clearHeader() {}
  
  public MenuItem getItem()
  {
    return this.mItem;
  }
  
  public Menu getParentMenu()
  {
    return this.mParentMenu;
  }
  
  public SubMenu setHeaderIcon(int paramInt)
  {
    return null;
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    return null;
  }
  
  public SubMenu setHeaderTitle(int paramInt)
  {
    return null;
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    return null;
  }
  
  public SubMenu setHeaderView(View paramView)
  {
    return null;
  }
  
  public SubMenu setIcon(int paramInt)
  {
    this.mItem.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    this.mItem.setIcon(paramDrawable);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.mParentMenu.setQwertyMode(paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/SimpleSubMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */