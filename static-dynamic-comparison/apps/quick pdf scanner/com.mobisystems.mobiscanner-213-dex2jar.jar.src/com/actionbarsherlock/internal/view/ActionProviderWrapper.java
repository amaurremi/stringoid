package com.actionbarsherlock.internal.view;

import android.view.SubMenu;
import android.view.View;
import com.actionbarsherlock.internal.view.menu.SubMenuWrapper;

public class ActionProviderWrapper
  extends android.view.ActionProvider
{
  private final com.actionbarsherlock.view.ActionProvider mProvider;
  
  public ActionProviderWrapper(com.actionbarsherlock.view.ActionProvider paramActionProvider)
  {
    super(null);
    this.mProvider = paramActionProvider;
  }
  
  public boolean hasSubMenu()
  {
    return this.mProvider.hasSubMenu();
  }
  
  public View onCreateActionView()
  {
    return this.mProvider.onCreateActionView();
  }
  
  public boolean onPerformDefaultAction()
  {
    return this.mProvider.onPerformDefaultAction();
  }
  
  public void onPrepareSubMenu(SubMenu paramSubMenu)
  {
    this.mProvider.onPrepareSubMenu(new SubMenuWrapper(paramSubMenu));
  }
  
  public com.actionbarsherlock.view.ActionProvider unwrap()
  {
    return this.mProvider;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/actionbarsherlock/internal/view/ActionProviderWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */