package com.actionbarsherlock.internal.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.actionbarsherlock.view.ActionProvider;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuItem.OnActionExpandListener;
import com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener;
import com.actionbarsherlock.view.SubMenu;

public class ActionMenuItem
  implements MenuItem
{
  private static final int CHECKABLE = 1;
  private static final int CHECKED = 2;
  private static final int ENABLED = 16;
  private static final int EXCLUSIVE = 4;
  private static final int HIDDEN = 8;
  private MenuItem.OnMenuItemClickListener mClickListener;
  private Context mContext;
  private int mFlags = 16;
  private final int mGroup;
  private Drawable mIconDrawable;
  private final int mId;
  private Intent mIntent;
  private final int mOrdering;
  private char mShortcutAlphabeticChar;
  private char mShortcutNumericChar;
  private CharSequence mTitle;
  private CharSequence mTitleCondensed;
  
  public ActionMenuItem(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence)
  {
    this.mContext = paramContext;
    this.mId = paramInt2;
    this.mGroup = paramInt1;
    this.mOrdering = paramInt4;
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
    return this.mShortcutAlphabeticChar;
  }
  
  public int getGroupId()
  {
    return this.mGroup;
  }
  
  public Drawable getIcon()
  {
    return this.mIconDrawable;
  }
  
  public Intent getIntent()
  {
    return this.mIntent;
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
    return this.mShortcutNumericChar;
  }
  
  public int getOrder()
  {
    return this.mOrdering;
  }
  
  public SubMenu getSubMenu()
  {
    return null;
  }
  
  public CharSequence getTitle()
  {
    return this.mTitle;
  }
  
  public CharSequence getTitleCondensed()
  {
    return this.mTitleCondensed;
  }
  
  public boolean hasSubMenu()
  {
    return false;
  }
  
  public boolean invoke()
  {
    if ((this.mClickListener != null) && (this.mClickListener.onMenuItemClick(this))) {
      return true;
    }
    if (this.mIntent != null)
    {
      this.mContext.startActivity(this.mIntent);
      return true;
    }
    return false;
  }
  
  public boolean isActionViewExpanded()
  {
    return false;
  }
  
  public boolean isCheckable()
  {
    return (this.mFlags & 0x1) != 0;
  }
  
  public boolean isChecked()
  {
    return (this.mFlags & 0x2) != 0;
  }
  
  public boolean isEnabled()
  {
    return (this.mFlags & 0x10) != 0;
  }
  
  public boolean isVisible()
  {
    return (this.mFlags & 0x8) == 0;
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException();
  }
  
  public MenuItem setActionView(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public MenuItem setActionView(View paramView)
  {
    throw new UnsupportedOperationException();
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    this.mShortcutAlphabeticChar = paramChar;
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    int j = this.mFlags;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.mFlags = (i | j & 0xFFFFFFFE);
      return this;
    }
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    int j = this.mFlags;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      this.mFlags = (i | j & 0xFFFFFFFD);
      return this;
    }
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    int j = this.mFlags;
    if (paramBoolean) {}
    for (int i = 16;; i = 0)
    {
      this.mFlags = (i | j & 0xFFFFFFEF);
      return this;
    }
  }
  
  public ActionMenuItem setExclusiveCheckable(boolean paramBoolean)
  {
    int j = this.mFlags;
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      this.mFlags = (i | j & 0xFFFFFFFB);
      return this;
    }
  }
  
  public MenuItem setIcon(int paramInt)
  {
    this.mIconDrawable = this.mContext.getResources().getDrawable(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    this.mIconDrawable = paramDrawable;
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    this.mShortcutNumericChar = paramChar;
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    return this;
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mClickListener = paramOnMenuItemClickListener;
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.mShortcutNumericChar = paramChar1;
    this.mShortcutAlphabeticChar = paramChar2;
    return this;
  }
  
  public void setShowAsAction(int paramInt) {}
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    setShowAsAction(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    this.mTitle = this.mContext.getResources().getString(paramInt);
    return this;
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
    int j = this.mFlags;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.mFlags = (i | j & 0x8);
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/actionbarsherlock/internal/view/menu/ActionMenuItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */