package mobi.beyondpod.ui.views.base;

import android.view.Menu;
import android.view.MenuItem;
import mobi.beyondpod.ui.core.SimpleMenu;

public abstract interface ActionModeBP
{
  public abstract void finish();
  
  public abstract SimpleMenu getActionMenus();
  
  public abstract void invalidateOptionsMenu();
  
  public abstract boolean isEmulated();
  
  public abstract void setSubTitle(CharSequence paramCharSequence);
  
  public abstract void setTitle(CharSequence paramCharSequence);
  
  public static abstract interface Callback
  {
    public abstract boolean onActionItemClicked(ActionModeBP paramActionModeBP, MenuItem paramMenuItem);
    
    public abstract void onAfterActionModeCreate(ActionModeBP paramActionModeBP);
    
    public abstract boolean onCreateActionMode(ActionModeBP paramActionModeBP, Menu paramMenu);
    
    public abstract void onDestroyActionMode(ActionModeBP paramActionModeBP);
    
    public abstract boolean onUpdateActionModeToolsVisibility(ActionModeBP paramActionModeBP, Menu paramMenu);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/base/ActionModeBP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */