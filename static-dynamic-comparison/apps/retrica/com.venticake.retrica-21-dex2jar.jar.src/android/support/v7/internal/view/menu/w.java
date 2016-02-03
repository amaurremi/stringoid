package android.support.v7.internal.view.menu;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class w
  extends l<MenuItem.OnMenuItemClickListener>
  implements MenuItem.OnMenuItemClickListener
{
  w(t paramt, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    super(paramOnMenuItemClickListener);
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    return ((MenuItem.OnMenuItemClickListener)this.a).onMenuItemClick(this.b.a(paramMenuItem));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/menu/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */