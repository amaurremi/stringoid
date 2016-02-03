package mobi.beyondpod.ui.core;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import mobi.beyondpod.ui.views.base.ActionModeBP;
import mobi.beyondpod.ui.views.base.ActionModeBP.Callback;

public class ActionBarHelperHoneycomb
  extends ActionBarHelper
{
  private Menu mOptionsMenu;
  private View mRefreshIndeterminateProgressView = null;
  
  protected ActionBarHelperHoneycomb(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  @SuppressLint({"NewApi"})
  protected Context getActionBarThemedContext()
  {
    return this._Activity;
  }
  
  @SuppressLint({"NewApi"})
  public void invalidateOptionsMenu()
  {
    this._Activity.invalidateOptionsMenu();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    this.mOptionsMenu = paramMenu;
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  @SuppressLint({"NewApi"})
  public void setDisplayOptions(int paramInt1, int paramInt2)
  {
    this._Activity.getActionBar().setDisplayOptions(paramInt1, paramInt2);
  }
  
  @SuppressLint({"NewApi"})
  public void setRefreshActionItemState(boolean paramBoolean)
  {
    if (this.mOptionsMenu == null) {}
    MenuItem localMenuItem;
    do
    {
      return;
      localMenuItem = this.mOptionsMenu.findItem(2131230764);
    } while (localMenuItem == null);
    if (paramBoolean)
    {
      if (this.mRefreshIndeterminateProgressView == null) {
        this.mRefreshIndeterminateProgressView = ((LayoutInflater)getActionBarThemedContext().getSystemService("layout_inflater")).inflate(2130903065, null);
      }
      localMenuItem.setActionView(this.mRefreshIndeterminateProgressView);
      return;
    }
    localMenuItem.setActionView(null);
  }
  
  @SuppressLint({"NewApi"})
  public void setSubtitle(String paramString)
  {
    this._Activity.getActionBar().setSubtitle(paramString);
  }
  
  public ActionModeBP startActionMode(ActionModeBP.Callback paramCallback)
  {
    paramCallback = new ActionModeHC(paramCallback);
    paramCallback.StartActionMode(this._Activity);
    return paramCallback;
  }
  
  @TargetApi(11)
  class ActionModeHC
    implements ActionModeBP
  {
    ActionMode _ActionMode;
    ActionModeBP.Callback _BPCallback;
    ActionMode.Callback _Callback = new ActionMode.Callback()
    {
      @SuppressLint({"NewApi"})
      public boolean onActionItemClicked(ActionMode paramAnonymousActionMode, MenuItem paramAnonymousMenuItem)
      {
        return ActionBarHelperHoneycomb.ActionModeHC.this._BPCallback.onActionItemClicked(ActionBarHelperHoneycomb.ActionModeHC.this, paramAnonymousMenuItem);
      }
      
      @SuppressLint({"NewApi"})
      public boolean onCreateActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        return ActionBarHelperHoneycomb.ActionModeHC.this._BPCallback.onCreateActionMode(ActionBarHelperHoneycomb.ActionModeHC.this, paramAnonymousMenu);
      }
      
      @SuppressLint({"NewApi"})
      public void onDestroyActionMode(ActionMode paramAnonymousActionMode)
      {
        ActionBarHelperHoneycomb.ActionModeHC.this._BPCallback.onDestroyActionMode(ActionBarHelperHoneycomb.ActionModeHC.this);
      }
      
      @SuppressLint({"NewApi"})
      public boolean onPrepareActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        return ActionBarHelperHoneycomb.ActionModeHC.this._BPCallback.onUpdateActionModeToolsVisibility(ActionBarHelperHoneycomb.ActionModeHC.this, paramAnonymousMenu);
      }
    };
    
    public ActionModeHC(ActionModeBP.Callback paramCallback)
    {
      this._BPCallback = paramCallback;
    }
    
    @SuppressLint({"NewApi"})
    public void StartActionMode(Activity paramActivity)
    {
      this._ActionMode = ActionBarHelperHoneycomb.this._Activity.startActionMode(this._Callback);
      this._BPCallback.onAfterActionModeCreate(this);
    }
    
    @SuppressLint({"NewApi"})
    public void finish()
    {
      this._ActionMode.finish();
    }
    
    public SimpleMenu getActionMenus()
    {
      return null;
    }
    
    @SuppressLint({"NewApi"})
    public void invalidateOptionsMenu()
    {
      if (this._ActionMode != null) {
        this._ActionMode.invalidate();
      }
    }
    
    public boolean isEmulated()
    {
      return false;
    }
    
    @SuppressLint({"NewApi"})
    public void setSubTitle(CharSequence paramCharSequence)
    {
      if (this._ActionMode != null) {
        this._ActionMode.setSubtitle(paramCharSequence);
      }
    }
    
    @SuppressLint({"NewApi"})
    public void setTitle(CharSequence paramCharSequence)
    {
      if (this._ActionMode != null) {
        this._ActionMode.setTitle(paramCharSequence);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/ActionBarHelperHoneycomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */