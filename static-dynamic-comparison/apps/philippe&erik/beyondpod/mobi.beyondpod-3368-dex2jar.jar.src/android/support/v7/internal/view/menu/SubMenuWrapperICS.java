package android.support.v7.internal.view.menu;

import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

class SubMenuWrapperICS
  extends MenuWrapperICS
  implements SupportSubMenu
{
  SubMenuWrapperICS(SubMenu paramSubMenu)
  {
    super(paramSubMenu);
  }
  
  public void clearHeader()
  {
    ((SubMenu)this.mWrappedObject).clearHeader();
  }
  
  public MenuItem getItem()
  {
    return getMenuItemWrapper(((SubMenu)this.mWrappedObject).getItem());
  }
  
  public SubMenu getWrappedObject()
  {
    return (SubMenu)this.mWrappedObject;
  }
  
  public SubMenu setHeaderIcon(int paramInt)
  {
    ((SubMenu)this.mWrappedObject).setHeaderIcon(paramInt);
    return this;
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    ((SubMenu)this.mWrappedObject).setHeaderIcon(paramDrawable);
    return this;
  }
  
  public SubMenu setHeaderTitle(int paramInt)
  {
    ((SubMenu)this.mWrappedObject).setHeaderTitle(paramInt);
    return this;
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    ((SubMenu)this.mWrappedObject).setHeaderTitle(paramCharSequence);
    return this;
  }
  
  public SubMenu setHeaderView(View paramView)
  {
    ((SubMenu)this.mWrappedObject).setHeaderView(paramView);
    return this;
  }
  
  public SubMenu setIcon(int paramInt)
  {
    ((SubMenu)this.mWrappedObject).setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    ((SubMenu)this.mWrappedObject).setIcon(paramDrawable);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/internal/view/menu/SubMenuWrapperICS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */