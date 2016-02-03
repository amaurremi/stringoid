package android.support.v7.internal.view.menu;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.view.j;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

public class t
  extends k<MenuItem>
  implements android.support.v4.b.a.b
{
  private final boolean b;
  private boolean c;
  private Method d;
  
  t(MenuItem paramMenuItem)
  {
    this(paramMenuItem, true);
  }
  
  t(MenuItem paramMenuItem, boolean paramBoolean)
  {
    super(paramMenuItem);
    this.c = paramMenuItem.isVisible();
    this.b = paramBoolean;
  }
  
  public android.support.v4.b.a.b a(j paramj)
  {
    MenuItem localMenuItem = (MenuItem)this.a;
    if (paramj != null) {}
    for (paramj = b(paramj);; paramj = null)
    {
      localMenuItem.setActionProvider(paramj);
      return this;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if (this.d == null) {
        this.d = ((MenuItem)this.a).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] { Boolean.TYPE });
      }
      this.d.invoke(this.a, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", localException);
    }
  }
  
  public j b()
  {
    u localu = (u)((MenuItem)this.a).getActionProvider();
    if (localu != null) {
      return localu.a;
    }
    return null;
  }
  
  u b(j paramj)
  {
    return new u(this, paramj);
  }
  
  final MenuItem b(boolean paramBoolean)
  {
    return ((MenuItem)this.a).setVisible(paramBoolean);
  }
  
  final boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.c)
    {
      j localj = b();
      bool1 = bool2;
      if (localj != null)
      {
        bool1 = bool2;
        if (localj.c())
        {
          bool1 = bool2;
          if (!localj.d())
          {
            b(false);
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean collapseActionView()
  {
    return ((MenuItem)this.a).collapseActionView();
  }
  
  public boolean expandActionView()
  {
    return ((MenuItem)this.a).expandActionView();
  }
  
  public ActionProvider getActionProvider()
  {
    return ((MenuItem)this.a).getActionProvider();
  }
  
  public View getActionView()
  {
    View localView2 = ((MenuItem)this.a).getActionView();
    View localView1 = localView2;
    if ((localView2 instanceof v)) {
      localView1 = ((v)localView2).a();
    }
    return localView1;
  }
  
  public char getAlphabeticShortcut()
  {
    return ((MenuItem)this.a).getAlphabeticShortcut();
  }
  
  public int getGroupId()
  {
    return ((MenuItem)this.a).getGroupId();
  }
  
  public Drawable getIcon()
  {
    return ((MenuItem)this.a).getIcon();
  }
  
  public Intent getIntent()
  {
    return ((MenuItem)this.a).getIntent();
  }
  
  public int getItemId()
  {
    return ((MenuItem)this.a).getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return ((MenuItem)this.a).getMenuInfo();
  }
  
  public char getNumericShortcut()
  {
    return ((MenuItem)this.a).getNumericShortcut();
  }
  
  public int getOrder()
  {
    return ((MenuItem)this.a).getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return a(((MenuItem)this.a).getSubMenu());
  }
  
  public CharSequence getTitle()
  {
    return ((MenuItem)this.a).getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return ((MenuItem)this.a).getTitleCondensed();
  }
  
  public boolean hasSubMenu()
  {
    return ((MenuItem)this.a).hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return ((MenuItem)this.a).isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return ((MenuItem)this.a).isCheckable();
  }
  
  public boolean isChecked()
  {
    return ((MenuItem)this.a).isChecked();
  }
  
  public boolean isEnabled()
  {
    return ((MenuItem)this.a).isEnabled();
  }
  
  public boolean isVisible()
  {
    return ((MenuItem)this.a).isVisible();
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    ((MenuItem)this.a).setActionProvider(paramActionProvider);
    if ((paramActionProvider != null) && (this.b)) {
      c();
    }
    return this;
  }
  
  public MenuItem setActionView(int paramInt)
  {
    ((MenuItem)this.a).setActionView(paramInt);
    View localView = ((MenuItem)this.a).getActionView();
    if ((localView instanceof android.support.v7.c.b)) {
      ((MenuItem)this.a).setActionView(new v(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    Object localObject = paramView;
    if ((paramView instanceof android.support.v7.c.b)) {
      localObject = new v(paramView);
    }
    ((MenuItem)this.a).setActionView((View)localObject);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    ((MenuItem)this.a).setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    ((MenuItem)this.a).setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    ((MenuItem)this.a).setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    ((MenuItem)this.a).setEnabled(paramBoolean);
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    ((MenuItem)this.a).setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    ((MenuItem)this.a).setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    ((MenuItem)this.a).setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    ((MenuItem)this.a).setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    ((MenuItem)this.a).setOnActionExpandListener(paramOnActionExpandListener);
    return this;
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    MenuItem localMenuItem = (MenuItem)this.a;
    if (paramOnMenuItemClickListener != null) {}
    for (paramOnMenuItemClickListener = new w(this, paramOnMenuItemClickListener);; paramOnMenuItemClickListener = null)
    {
      localMenuItem.setOnMenuItemClickListener(paramOnMenuItemClickListener);
      return this;
    }
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    ((MenuItem)this.a).setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    ((MenuItem)this.a).setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    ((MenuItem)this.a).setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    ((MenuItem)this.a).setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    ((MenuItem)this.a).setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    ((MenuItem)this.a).setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    if (this.b)
    {
      this.c = paramBoolean;
      if (c()) {
        return this;
      }
    }
    return b(paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/menu/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */