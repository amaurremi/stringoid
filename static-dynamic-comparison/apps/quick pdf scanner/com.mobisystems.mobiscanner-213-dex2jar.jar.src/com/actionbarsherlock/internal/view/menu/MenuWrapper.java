package com.actionbarsherlock.internal.view.menu;

import android.content.ComponentName;
import android.content.Intent;
import android.view.KeyEvent;
import java.util.WeakHashMap;

public class MenuWrapper
  implements com.actionbarsherlock.view.Menu
{
  private final WeakHashMap<android.view.MenuItem, com.actionbarsherlock.view.MenuItem> mNativeMap = new WeakHashMap();
  private final android.view.Menu mNativeMenu;
  
  public MenuWrapper(android.view.Menu paramMenu)
  {
    this.mNativeMenu = paramMenu;
  }
  
  private com.actionbarsherlock.view.MenuItem addInternal(android.view.MenuItem paramMenuItem)
  {
    MenuItemWrapper localMenuItemWrapper = new MenuItemWrapper(paramMenuItem);
    this.mNativeMap.put(paramMenuItem, localMenuItemWrapper);
    return localMenuItemWrapper;
  }
  
  private com.actionbarsherlock.view.SubMenu addInternal(android.view.SubMenu paramSubMenu)
  {
    SubMenuWrapper localSubMenuWrapper = new SubMenuWrapper(paramSubMenu);
    paramSubMenu = paramSubMenu.getItem();
    com.actionbarsherlock.view.MenuItem localMenuItem = localSubMenuWrapper.getItem();
    this.mNativeMap.put(paramSubMenu, localMenuItem);
    return localSubMenuWrapper;
  }
  
  public com.actionbarsherlock.view.MenuItem add(int paramInt)
  {
    return addInternal(this.mNativeMenu.add(paramInt));
  }
  
  public com.actionbarsherlock.view.MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return addInternal(this.mNativeMenu.add(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public com.actionbarsherlock.view.MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return addInternal(this.mNativeMenu.add(paramInt1, paramInt2, paramInt3, paramCharSequence));
  }
  
  public com.actionbarsherlock.view.MenuItem add(CharSequence paramCharSequence)
  {
    return addInternal(this.mNativeMenu.add(paramCharSequence));
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, com.actionbarsherlock.view.MenuItem[] paramArrayOfMenuItem)
  {
    if (paramArrayOfMenuItem != null)
    {
      android.view.MenuItem[] arrayOfMenuItem = new android.view.MenuItem[paramArrayOfMenuItem.length];
      paramInt3 = this.mNativeMenu.addIntentOptions(paramInt1, paramInt2, paramInt3, paramComponentName, paramArrayOfIntent, paramIntent, paramInt4, arrayOfMenuItem);
      paramInt1 = 0;
      paramInt4 = paramArrayOfMenuItem.length;
      for (;;)
      {
        paramInt2 = paramInt3;
        if (paramInt1 >= paramInt4) {
          break;
        }
        paramArrayOfMenuItem[paramInt1] = new MenuItemWrapper(arrayOfMenuItem[paramInt1]);
        paramInt1 += 1;
      }
    }
    paramInt2 = this.mNativeMenu.addIntentOptions(paramInt1, paramInt2, paramInt3, paramComponentName, paramArrayOfIntent, paramIntent, paramInt4, null);
    return paramInt2;
  }
  
  public com.actionbarsherlock.view.SubMenu addSubMenu(int paramInt)
  {
    return addInternal(this.mNativeMenu.addSubMenu(paramInt));
  }
  
  public com.actionbarsherlock.view.SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return addInternal(this.mNativeMenu.addSubMenu(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public com.actionbarsherlock.view.SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return addInternal(this.mNativeMenu.addSubMenu(paramInt1, paramInt2, paramInt3, paramCharSequence));
  }
  
  public com.actionbarsherlock.view.SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return addInternal(this.mNativeMenu.addSubMenu(paramCharSequence));
  }
  
  public void clear()
  {
    this.mNativeMap.clear();
    this.mNativeMenu.clear();
  }
  
  public void close()
  {
    this.mNativeMenu.close();
  }
  
  public com.actionbarsherlock.view.MenuItem findItem(int paramInt)
  {
    return findItem(this.mNativeMenu.findItem(paramInt));
  }
  
  public com.actionbarsherlock.view.MenuItem findItem(android.view.MenuItem paramMenuItem)
  {
    Object localObject;
    if (paramMenuItem == null) {
      localObject = null;
    }
    com.actionbarsherlock.view.MenuItem localMenuItem;
    do
    {
      return (com.actionbarsherlock.view.MenuItem)localObject;
      localMenuItem = (com.actionbarsherlock.view.MenuItem)this.mNativeMap.get(paramMenuItem);
      localObject = localMenuItem;
    } while (localMenuItem != null);
    return addInternal(paramMenuItem);
  }
  
  public com.actionbarsherlock.view.MenuItem getItem(int paramInt)
  {
    return findItem(this.mNativeMenu.getItem(paramInt));
  }
  
  public boolean hasVisibleItems()
  {
    return this.mNativeMenu.hasVisibleItems();
  }
  
  public void invalidate()
  {
    if (this.mNativeMap.isEmpty()) {
      return;
    }
    WeakHashMap localWeakHashMap = new WeakHashMap(this.mNativeMap.size());
    int i = 0;
    while (i < this.mNativeMenu.size())
    {
      android.view.MenuItem localMenuItem = this.mNativeMenu.getItem(i);
      localWeakHashMap.put(localMenuItem, this.mNativeMap.get(localMenuItem));
      i += 1;
    }
    this.mNativeMap.clear();
    this.mNativeMap.putAll(localWeakHashMap);
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.mNativeMenu.isShortcutKey(paramInt, paramKeyEvent);
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return this.mNativeMenu.performIdentifierAction(paramInt1, paramInt2);
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    return this.mNativeMenu.performShortcut(paramInt1, paramKeyEvent, paramInt2);
  }
  
  public void removeGroup(int paramInt)
  {
    int i = 0;
    while (i < this.mNativeMenu.size())
    {
      android.view.MenuItem localMenuItem = this.mNativeMenu.getItem(i);
      if (localMenuItem.getGroupId() == paramInt) {
        this.mNativeMap.remove(localMenuItem);
      }
      i += 1;
    }
    this.mNativeMenu.removeGroup(paramInt);
  }
  
  public void removeItem(int paramInt)
  {
    this.mNativeMap.remove(this.mNativeMenu.findItem(paramInt));
    this.mNativeMenu.removeItem(paramInt);
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mNativeMenu.setGroupCheckable(paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    this.mNativeMenu.setGroupEnabled(paramInt, paramBoolean);
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    this.mNativeMenu.setGroupVisible(paramInt, paramBoolean);
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.mNativeMenu.setQwertyMode(paramBoolean);
  }
  
  public int size()
  {
    return this.mNativeMenu.size();
  }
  
  public android.view.Menu unwrap()
  {
    return this.mNativeMenu;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/actionbarsherlock/internal/view/menu/MenuWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */