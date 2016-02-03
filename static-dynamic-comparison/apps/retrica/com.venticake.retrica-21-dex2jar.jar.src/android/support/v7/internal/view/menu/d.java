package android.support.v7.internal.view.menu;

import android.view.View;

class d
  implements Runnable
{
  private f b;
  
  public d(ActionMenuPresenter paramActionMenuPresenter, f paramf)
  {
    this.b = paramf;
  }
  
  public void run()
  {
    this.a.e.e();
    View localView = (View)this.a.h;
    if ((localView != null) && (localView.getWindowToken() != null) && (this.b.a())) {
      ActionMenuPresenter.a(this.a, this.b);
    }
    ActionMenuPresenter.a(this.a, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/menu/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */