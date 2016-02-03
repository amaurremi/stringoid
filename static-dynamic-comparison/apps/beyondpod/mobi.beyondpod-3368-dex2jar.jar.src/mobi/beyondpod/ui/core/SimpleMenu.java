package mobi.beyondpod.ui.core;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import java.util.ArrayList;

public class SimpleMenu
  implements Menu
{
  private View _AnchorView;
  private Context _Context;
  private MenuItem.OnMenuItemClickListener _OnClickListener = null;
  private Resources _Resources;
  private ArrayList<SimpleMenuItem> mItems;
  
  public SimpleMenu(Context paramContext)
  {
    this._Context = paramContext;
    this._Resources = paramContext.getResources();
    this.mItems = new ArrayList();
  }
  
  public SimpleMenu(Context paramContext, View paramView)
  {
    this(paramContext);
    this._AnchorView = paramView;
  }
  
  private void BuildPopupMenuItem(SimpleMenuItem paramSimpleMenuItem, Menu paramMenu)
  {
    paramMenu.add(paramSimpleMenuItem.getGroupId(), paramSimpleMenuItem.getItemId(), paramSimpleMenuItem.getOrder(), paramSimpleMenuItem.getTitle()).setIcon(paramSimpleMenuItem.getIconResId()).setVisible(paramSimpleMenuItem.isVisible()).setEnabled(paramSimpleMenuItem.isEnabled()).setCheckable(paramSimpleMenuItem.isCheckable()).setChecked(paramSimpleMenuItem.isChecked());
  }
  
  private void BuildPopupMenuItems(Menu paramMenu1, Menu paramMenu2)
  {
    int i = 0;
    if (i == paramMenu1.size()) {
      return;
    }
    SimpleMenuItem localSimpleMenuItem = (SimpleMenuItem)paramMenu1.getItem(i);
    if (localSimpleMenuItem.hasSubMenu())
    {
      SubMenu localSubMenu = paramMenu2.addSubMenu(localSimpleMenuItem.getGroupId(), localSimpleMenuItem.getItemId(), localSimpleMenuItem.getOrder(), localSimpleMenuItem.getTitle()).setHeaderIcon(localSimpleMenuItem.getIconResId()).setHeaderTitle(localSimpleMenuItem.getTitle());
      BuildPopupMenuItems(localSimpleMenuItem.getSubMenu(), localSubMenu);
    }
    for (;;)
    {
      i += 1;
      break;
      BuildPopupMenuItem(localSimpleMenuItem, paramMenu2);
    }
  }
  
  private MenuItem addInternal(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    paramCharSequence = new SimpleMenuItem(this, paramInt1, paramInt2, paramCharSequence);
    this.mItems.add(findInsertIndex(this.mItems, paramInt2), paramCharSequence);
    return paramCharSequence;
  }
  
  private static int findInsertIndex(ArrayList<? extends MenuItem> paramArrayList, int paramInt)
  {
    int i = paramArrayList.size() - 1;
    for (;;)
    {
      if (i < 0) {
        return 0;
      }
      if (((MenuItem)paramArrayList.get(i)).getOrder() <= paramInt) {
        return i + 1;
      }
      i -= 1;
    }
  }
  
  private void removeItemAtInt(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mItems.size())) {
      return;
    }
    this.mItems.remove(paramInt);
  }
  
  public MenuItem add(int paramInt)
  {
    return addInternal(0, 0, this._Resources.getString(paramInt));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return addInternal(paramInt2, paramInt3, this._Resources.getString(paramInt4));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return addInternal(paramInt2, paramInt3, paramCharSequence);
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    return addInternal(0, 0, paramCharSequence);
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    SimpleMenuItem localSimpleMenuItem = new SimpleMenuItem(this, paramInt2, paramInt3, this._Resources.getString(paramInt4));
    this.mItems.add(findInsertIndex(this.mItems, paramInt3), localSimpleMenuItem);
    SimpleSubMenu localSimpleSubMenu = new SimpleSubMenu(this._Context, this, localSimpleMenuItem);
    localSimpleMenuItem.setSubMenu(localSimpleSubMenu);
    return localSimpleSubMenu;
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    paramCharSequence = new SimpleMenuItem(this, paramInt2, paramInt3, paramCharSequence);
    this.mItems.add(findInsertIndex(this.mItems, paramInt3), paramCharSequence);
    SimpleSubMenu localSimpleSubMenu = new SimpleSubMenu(this._Context, this, paramCharSequence);
    paramCharSequence.setSubMenu(localSimpleSubMenu);
    return localSimpleSubMenu;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
  }
  
  public void clear()
  {
    this.mItems.clear();
  }
  
  public void close()
  {
    throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
  }
  
  public MenuItem findItem(int paramInt)
  {
    int j = size();
    int i = 0;
    for (;;)
    {
      Object localObject;
      if (i >= j) {
        localObject = null;
      }
      SimpleMenuItem localSimpleMenuItem;
      do
      {
        return (MenuItem)localObject;
        localSimpleMenuItem = (SimpleMenuItem)this.mItems.get(i);
        localObject = localSimpleMenuItem;
      } while (localSimpleMenuItem.getItemId() == paramInt);
      i += 1;
    }
  }
  
  public int findItemIndex(int paramInt)
  {
    int k = size();
    int i = 0;
    for (;;)
    {
      int j;
      if (i >= k) {
        j = -1;
      }
      do
      {
        return j;
        j = i;
      } while (((SimpleMenuItem)this.mItems.get(i)).getItemId() == paramInt);
      i += 1;
    }
  }
  
  public Context getContext()
  {
    return this._Context;
  }
  
  public MenuItem getItem(int paramInt)
  {
    return (MenuItem)this.mItems.get(paramInt);
  }
  
  public Resources getResources()
  {
    return this._Resources;
  }
  
  public boolean hasVisibleItems()
  {
    throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
  }
  
  public void removeGroup(int paramInt)
  {
    throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
  }
  
  public void removeItem(int paramInt)
  {
    removeItemAtInt(findItemIndex(paramInt));
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
  }
  
  public void setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this._OnClickListener = paramOnMenuItemClickListener;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
  }
  
  @SuppressLint({"NewApi"})
  public void showAsPopupMenu()
  {
    if (Build.VERSION.SDK_INT < 11) {
      return;
    }
    PopupMenu localPopupMenu = new PopupMenu(this._Context, this._AnchorView);
    localPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
    {
      public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        if (SimpleMenu.this._OnClickListener != null) {
          return SimpleMenu.this._OnClickListener.onMenuItemClick(paramAnonymousMenuItem);
        }
        return false;
      }
    });
    BuildPopupMenuItems(this, localPopupMenu.getMenu());
    localPopupMenu.show();
  }
  
  public int size()
  {
    return this.mItems.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/SimpleMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */