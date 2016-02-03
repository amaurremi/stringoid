package com.pocket.widget;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.Iterator;
import java.util.List;

public class v
  implements View.OnClickListener
{
  private final List a;
  private View b;
  private View.OnClickListener c;
  private x d;
  
  private v(List paramList, View paramView)
  {
    this.a = paramList;
    paramList = this.a.iterator();
    while (paramList.hasNext()) {
      ((View)paramList.next()).setOnClickListener(this);
    }
    a(paramView);
  }
  
  public void a(int paramInt)
  {
    View localView1 = (View)this.a.get(paramInt);
    if (localView1 == this.b) {}
    do
    {
      return;
      this.b = localView1;
      Iterator localIterator = this.a.iterator();
      if (localIterator.hasNext())
      {
        View localView2 = (View)localIterator.next();
        if (localView2 == localView1) {}
        for (boolean bool = true;; bool = false)
        {
          localView2.setSelected(bool);
          break;
        }
      }
    } while (this.d == null);
    this.d.a(localView1, paramInt);
  }
  
  public void a(View paramView)
  {
    int i = this.a.indexOf(paramView);
    if (i < 0) {
      throw new RuntimeException("view is not a choice");
    }
    a(i);
  }
  
  public void a(x paramx)
  {
    this.d = paramx;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.b) {}
    for (;;)
    {
      if (this.c != null) {
        this.c.onClick(paramView);
      }
      return;
      a(paramView);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */