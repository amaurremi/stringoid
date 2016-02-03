package android.support.v7.internal.view.menu;

import android.support.v4.view.j;
import android.support.v4.view.l;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

class y
  extends u
  implements l
{
  ActionProvider.VisibilityListener c;
  
  public y(x paramx, j paramj)
  {
    super(paramx, paramj);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.c != null) {
      this.c.onActionProviderVisibilityChanged(paramBoolean);
    }
  }
  
  public boolean isVisible()
  {
    return this.a.d();
  }
  
  public View onCreateActionView(MenuItem paramMenuItem)
  {
    return this.a.a(paramMenuItem);
  }
  
  public boolean overridesItemVisibility()
  {
    return this.a.c();
  }
  
  public void refreshVisibility()
  {
    this.a.e();
  }
  
  public void setVisibilityListener(ActionProvider.VisibilityListener paramVisibilityListener)
  {
    this.c = paramVisibilityListener;
    j localj = this.a;
    if (paramVisibilityListener != null) {}
    for (paramVisibilityListener = this;; paramVisibilityListener = null)
    {
      localj.a(paramVisibilityListener);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/menu/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */