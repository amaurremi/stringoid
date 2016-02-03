package com.pocket.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

public class ax
{
  private final ArrayList a = new ArrayList();
  private final View b;
  
  public ax(View paramView)
  {
    this.b = paramView;
  }
  
  private boolean b()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (!((ay)localIterator.next()).a()) {
        return false;
      }
    }
    return true;
  }
  
  public void a()
  {
    this.b.setEnabled(b());
  }
  
  public void a(ay paramay)
  {
    this.a.add(paramay);
    a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */