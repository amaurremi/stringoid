package android.support.v7.internal.widget;

import android.database.DataSetObserver;

class u
  extends DataSetObserver
{
  private u(ListPopupWindow paramListPopupWindow) {}
  
  public void onChanged()
  {
    if (this.a.f()) {
      this.a.c();
    }
  }
  
  public void onInvalidated()
  {
    this.a.d();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */