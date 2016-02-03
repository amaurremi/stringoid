package android.support.v7.internal.widget;

import android.support.v7.a.e;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

class aa
  extends BaseAdapter
{
  private aa(ScrollingTabContainerView paramScrollingTabContainerView) {}
  
  public int getCount()
  {
    return ScrollingTabContainerView.a(this.a).getChildCount();
  }
  
  public Object getItem(int paramInt)
  {
    return ((ScrollingTabContainerView.TabView)ScrollingTabContainerView.a(this.a).getChildAt(paramInt)).getTab();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      return ScrollingTabContainerView.a(this.a, (e)getItem(paramInt), true);
    }
    ((ScrollingTabContainerView.TabView)paramView).a((e)getItem(paramInt));
    return paramView;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */