package android.support.v7.internal.view.menu;

import android.content.DialogInterface;

class c
  extends r
{
  public c(ActionMenuPresenter paramActionMenuPresenter, ah paramah)
  {
    super(paramah);
    paramActionMenuPresenter.a(paramActionMenuPresenter.a);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    ActionMenuPresenter.a(this.a, null);
    this.a.b = 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/menu/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */