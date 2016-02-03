package android.support.v7.internal.widget;

import android.widget.PopupWindow;

class x
  implements Runnable
{
  private x(ListPopupWindow paramListPopupWindow) {}
  
  public void run()
  {
    if ((ListPopupWindow.a(this.a) != null) && (ListPopupWindow.a(this.a).getCount() > ListPopupWindow.a(this.a).getChildCount()) && (ListPopupWindow.a(this.a).getChildCount() <= this.a.a))
    {
      ListPopupWindow.b(this.a).setInputMethodMode(2);
      this.a.c();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */