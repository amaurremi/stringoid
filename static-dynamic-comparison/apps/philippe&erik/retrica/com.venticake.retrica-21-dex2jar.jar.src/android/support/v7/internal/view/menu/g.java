package android.support.v7.internal.view.menu;

import android.view.MenuItem;

class g
  implements ac
{
  private g(ActionMenuPresenter paramActionMenuPresenter) {}
  
  public void a(o paramo, boolean paramBoolean)
  {
    if ((paramo instanceof ah)) {
      ((ah)paramo).o().a(false);
    }
  }
  
  public boolean b(o paramo)
  {
    if (paramo == null) {
      return false;
    }
    this.a.b = ((ah)paramo).getItem().getItemId();
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/menu/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */