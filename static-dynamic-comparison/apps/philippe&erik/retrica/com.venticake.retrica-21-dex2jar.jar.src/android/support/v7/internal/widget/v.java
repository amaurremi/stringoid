package android.support.v7.internal.widget;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.PopupWindow;

class v
  implements AbsListView.OnScrollListener
{
  private v(ListPopupWindow paramListPopupWindow) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 1) && (!this.a.g()) && (ListPopupWindow.b(this.a).getContentView() != null))
    {
      ListPopupWindow.d(this.a).removeCallbacks(ListPopupWindow.c(this.a));
      ListPopupWindow.c(this.a).run();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */