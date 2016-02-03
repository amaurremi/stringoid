package android.support.v7.a;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;

class o
  implements ActionMode.Callback
{
  private final ActionMode.Callback b;
  
  o(n paramn, ActionMode.Callback paramCallback)
  {
    this.b = paramCallback;
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return this.b.onActionItemClicked(paramActionMode, paramMenuItem);
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    boolean bool = this.b.onCreateActionMode(paramActionMode, paramMenu);
    if (bool)
    {
      n.a(this.a, paramActionMode);
      this.a.d();
    }
    return bool;
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode)
  {
    this.b.onDestroyActionMode(paramActionMode);
    this.a.e();
    n.a(this.a, null);
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return this.b.onPrepareActionMode(paramActionMode, paramMenu);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */