package mobi.beyondpod.ui.core;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

@TargetApi(14)
public class SimpleMenuItem
  implements MenuItem
{
  private boolean mCheckable;
  private boolean mChecked;
  private boolean mEnabled = true;
  private Drawable mIconDrawable;
  private int mIconResId = 0;
  private final int mId;
  private SimpleMenu mMenu;
  private final int mOrder;
  private SubMenu mSubMenu = null;
  private CharSequence mTitle;
  private CharSequence mTitleCondensed;
  private boolean mVisible = true;
  
  public SimpleMenuItem(SimpleMenu paramSimpleMenu, int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    this.mMenu = paramSimpleMenu;
    this.mId = paramInt1;
    this.mOrder = paramInt2;
    this.mTitle = paramCharSequence;
  }
  
  public boolean collapseActionView()
  {
    return false;
  }
  
  public boolean expandActionView()
  {
    return false;
  }
  
  public ActionProvider getActionProvider()
  {
    return null;
  }
  
  public View getActionView()
  {
    return null;
  }
  
  public char getAlphabeticShortcut()
  {
    return '\000';
  }
  
  public int getGroupId()
  {
    return 0;
  }
  
  public Drawable getIcon()
  {
    if (this.mIconDrawable != null) {
      return this.mIconDrawable;
    }
    if (this.mIconResId != 0) {
      return this.mMenu.getResources().getDrawable(this.mIconResId);
    }
    return null;
  }
  
  public int getIconResId()
  {
    return this.mIconResId;
  }
  
  public Intent getIntent()
  {
    return null;
  }
  
  public int getItemId()
  {
    return this.mId;
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return null;
  }
  
  public char getNumericShortcut()
  {
    return '\000';
  }
  
  public int getOrder()
  {
    return this.mOrder;
  }
  
  public SubMenu getSubMenu()
  {
    return this.mSubMenu;
  }
  
  public CharSequence getTitle()
  {
    return this.mTitle;
  }
  
  public CharSequence getTitleCondensed()
  {
    if (this.mTitleCondensed != null) {
      return this.mTitleCondensed;
    }
    return this.mTitle;
  }
  
  public boolean hasSubMenu()
  {
    return this.mSubMenu != null;
  }
  
  public boolean isActionViewExpanded()
  {
    return false;
  }
  
  public boolean isCheckable()
  {
    return this.mCheckable;
  }
  
  public boolean isChecked()
  {
    return this.mChecked;
  }
  
  public boolean isEnabled()
  {
    return this.mEnabled;
  }
  
  public boolean isVisible()
  {
    return this.mVisible;
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    return this;
  }
  
  public MenuItem setActionView(int paramInt)
  {
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    this.mCheckable = paramBoolean;
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    this.mChecked = paramBoolean;
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    this.mEnabled = paramBoolean;
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    this.mIconDrawable = null;
    this.mIconResId = paramInt;
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    this.mIconResId = 0;
    this.mIconDrawable = paramDrawable;
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    return this;
  }
  
  @SuppressLint({"NewApi"})
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    return this;
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    return this;
  }
  
  public void setShowAsAction(int paramInt) {}
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    return null;
  }
  
  void setSubMenu(SimpleSubMenu paramSimpleSubMenu)
  {
    this.mSubMenu = paramSimpleSubMenu;
    paramSimpleSubMenu.setHeaderTitle(getTitle());
  }
  
  public MenuItem setTitle(int paramInt)
  {
    return setTitle(this.mMenu.getContext().getString(paramInt));
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.mTitle = paramCharSequence;
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.mTitleCondensed = paramCharSequence;
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    this.mVisible = paramBoolean;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/SimpleMenuItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */