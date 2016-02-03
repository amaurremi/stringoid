package mobi.beyondpod.ui.views.base;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import mobi.beyondpod.ui.core.SimpleMenu;

public abstract interface IView
{
  public abstract boolean AllowScrollLeftRightFor(float paramFloat1, float paramFloat2);
  
  public abstract boolean CanScrollLeft();
  
  public abstract boolean CanScrollRight();
  
  public abstract TitleBarBase.TitleInfo GetViewTitle();
  
  public abstract boolean HandleContextMenu(MenuItem paramMenuItem);
  
  public abstract boolean HandleOptionsMenu(int paramInt, MenuItem paramMenuItem);
  
  public abstract boolean IsActive();
  
  public abstract void OnAfterActivate();
  
  public abstract void OnAfterDeactivate(boolean paramBoolean);
  
  public abstract void OnBeforeActivate();
  
  public abstract void PrepareContextMenu(ContextMenu paramContextMenu, ContextMenu.ContextMenuInfo paramContextMenuInfo);
  
  public abstract boolean PrepareOptionsMenu(Menu paramMenu);
  
  public abstract SimpleMenu PreparePopupOptionsMenu();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/base/IView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */