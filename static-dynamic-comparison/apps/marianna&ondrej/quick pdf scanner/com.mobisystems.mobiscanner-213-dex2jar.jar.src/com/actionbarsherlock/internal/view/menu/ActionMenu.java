package com.actionbarsherlock.internal.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.view.KeyEvent;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;
import java.util.ArrayList;
import java.util.List;

public class ActionMenu
  implements Menu
{
  private Context mContext;
  private boolean mIsQwerty;
  private ArrayList<ActionMenuItem> mItems;
  
  public ActionMenu(Context paramContext)
  {
    this.mContext = paramContext;
    this.mItems = new ArrayList();
  }
  
  private int findItemIndex(int paramInt)
  {
    ArrayList localArrayList = this.mItems;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (((ActionMenuItem)localArrayList.get(i)).getItemId() == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private ActionMenuItem findItemWithShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = this.mIsQwerty;
    paramKeyEvent = this.mItems;
    int k = paramKeyEvent.size();
    int i = 0;
    while (i < k)
    {
      ActionMenuItem localActionMenuItem = (ActionMenuItem)paramKeyEvent.get(i);
      if (bool) {}
      for (int j = localActionMenuItem.getAlphabeticShortcut(); paramInt == j; j = localActionMenuItem.getNumericShortcut()) {
        return localActionMenuItem;
      }
      i += 1;
    }
    return null;
  }
  
  public MenuItem add(int paramInt)
  {
    return add(0, 0, 0, paramInt);
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return add(paramInt1, paramInt2, paramInt3, this.mContext.getResources().getString(paramInt4));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    paramCharSequence = new ActionMenuItem(getContext(), paramInt1, paramInt2, 0, paramInt3, paramCharSequence);
    this.mItems.add(paramInt3, paramCharSequence);
    return paramCharSequence;
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    return add(0, 0, 0, paramCharSequence);
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    PackageManager localPackageManager = this.mContext.getPackageManager();
    List localList = localPackageManager.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, 0);
    int i;
    label52:
    ResolveInfo localResolveInfo;
    if (localList != null)
    {
      i = localList.size();
      if ((paramInt4 & 0x1) == 0) {
        removeGroup(paramInt1);
      }
      paramInt4 = 0;
      if (paramInt4 >= i) {
        break label214;
      }
      localResolveInfo = (ResolveInfo)localList.get(paramInt4);
      if (localResolveInfo.specificIndex >= 0) {
        break label201;
      }
    }
    label201:
    for (paramComponentName = paramIntent;; paramComponentName = paramArrayOfIntent[localResolveInfo.specificIndex])
    {
      paramComponentName = new Intent(paramComponentName);
      paramComponentName.setComponent(new ComponentName(localResolveInfo.activityInfo.applicationInfo.packageName, localResolveInfo.activityInfo.name));
      paramComponentName = add(paramInt1, paramInt2, paramInt3, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setIntent(paramComponentName);
      if ((paramArrayOfMenuItem != null) && (localResolveInfo.specificIndex >= 0)) {
        paramArrayOfMenuItem[localResolveInfo.specificIndex] = paramComponentName;
      }
      paramInt4 += 1;
      break label52;
      i = 0;
      break;
    }
    label214:
    return i;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    return null;
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return null;
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return null;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return null;
  }
  
  public void clear()
  {
    this.mItems.clear();
  }
  
  public void close() {}
  
  public MenuItem findItem(int paramInt)
  {
    return (MenuItem)this.mItems.get(findItemIndex(paramInt));
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public MenuItem getItem(int paramInt)
  {
    return (MenuItem)this.mItems.get(paramInt);
  }
  
  public boolean hasVisibleItems()
  {
    ArrayList localArrayList = this.mItems;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (((ActionMenuItem)localArrayList.get(i)).isVisible()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return findItemWithShortcut(paramInt, paramKeyEvent) != null;
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    paramInt1 = findItemIndex(paramInt1);
    if (paramInt1 < 0) {
      return false;
    }
    return ((ActionMenuItem)this.mItems.get(paramInt1)).invoke();
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    paramKeyEvent = findItemWithShortcut(paramInt1, paramKeyEvent);
    if (paramKeyEvent == null) {
      return false;
    }
    return paramKeyEvent.invoke();
  }
  
  public void removeGroup(int paramInt)
  {
    ArrayList localArrayList = this.mItems;
    int i = localArrayList.size();
    int j = 0;
    while (j < i) {
      if (((ActionMenuItem)localArrayList.get(j)).getGroupId() == paramInt)
      {
        localArrayList.remove(j);
        i -= 1;
      }
      else
      {
        j += 1;
      }
    }
  }
  
  public void removeItem(int paramInt)
  {
    this.mItems.remove(findItemIndex(paramInt));
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = this.mItems;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      ActionMenuItem localActionMenuItem = (ActionMenuItem)localArrayList.get(i);
      if (localActionMenuItem.getGroupId() == paramInt)
      {
        localActionMenuItem.setCheckable(paramBoolean1);
        localActionMenuItem.setExclusiveCheckable(paramBoolean2);
      }
      i += 1;
    }
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = this.mItems;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      ActionMenuItem localActionMenuItem = (ActionMenuItem)localArrayList.get(i);
      if (localActionMenuItem.getGroupId() == paramInt) {
        localActionMenuItem.setEnabled(paramBoolean);
      }
      i += 1;
    }
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = this.mItems;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      ActionMenuItem localActionMenuItem = (ActionMenuItem)localArrayList.get(i);
      if (localActionMenuItem.getGroupId() == paramInt) {
        localActionMenuItem.setVisible(paramBoolean);
      }
      i += 1;
    }
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.mIsQwerty = paramBoolean;
  }
  
  public int size()
  {
    return this.mItems.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/actionbarsherlock/internal/view/menu/ActionMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */