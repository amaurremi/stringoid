package com.actionbarsherlock.internal.view.menu;

import android.content.Context;
import android.os.Parcelable;
import android.view.ViewGroup;

public abstract interface MenuPresenter
{
  public abstract boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl);
  
  public abstract boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl);
  
  public abstract boolean flagActionItems();
  
  public abstract int getId();
  
  public abstract MenuView getMenuView(ViewGroup paramViewGroup);
  
  public abstract void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder);
  
  public abstract void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean);
  
  public abstract void onRestoreInstanceState(Parcelable paramParcelable);
  
  public abstract Parcelable onSaveInstanceState();
  
  public abstract boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder);
  
  public abstract void setCallback(Callback paramCallback);
  
  public abstract void updateMenuView(boolean paramBoolean);
  
  public static abstract interface Callback
  {
    public abstract void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean);
    
    public abstract boolean onOpenSubMenu(MenuBuilder paramMenuBuilder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/actionbarsherlock/internal/view/menu/MenuPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */