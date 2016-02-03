package android.support.v7.internal.view.menu;

import android.content.Context;
import android.view.View;

class f
  extends z
{
  public f(ActionMenuPresenter paramActionMenuPresenter, Context paramContext, o paramo, View paramView, boolean paramBoolean)
  {
    super(paramContext, paramo, paramView, paramBoolean);
    a(paramActionMenuPresenter.a);
  }
  
  public void onDismiss()
  {
    super.onDismiss();
    this.a.e.close();
    ActionMenuPresenter.a(this.a, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/menu/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */