package com.pocket.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.ideashower.readitlater.views.ResizeDetectRelativeLayout;

public class l
  extends ResizeDetectRelativeLayout
{
  private ListView a;
  private ViewGroup b;
  
  public l(Context paramContext)
  {
    super(paramContext);
  }
  
  private int a()
  {
    if ((this.a == null) || (this.a.getChildCount() == 0)) {}
    View localView1;
    label66:
    do
    {
      return 0;
      int i = this.a.getChildCount() - 1;
      while (i >= 0)
      {
        View localView2 = this.a.getChildAt(i);
        if (localView2 != this)
        {
          localView1 = localView2;
          if (localView2 != this.b) {
            break label66;
          }
        }
        i -= 1;
      }
      localView1 = null;
    } while (localView1 == null);
    return Math.max(this.a.getBottom() - localView1.getBottom(), 0);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = a();
    if (i > 0) {}
    for (;;)
    {
      setMinimumHeight(i);
      super.onMeasure(paramInt1, paramInt2);
      return;
      i = 1;
    }
  }
  
  public void setIsWrappedBy(ViewGroup paramViewGroup)
  {
    this.b = paramViewGroup;
  }
  
  public void setListView(ListView paramListView)
  {
    this.a = paramListView;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */