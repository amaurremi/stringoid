package com.pocket.widget.navigation;

import android.support.v4.widget.a;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

public class f
  implements a
{
  private final ArrayList a = new ArrayList();
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(a parama)
  {
    if (!this.a.contains(parama)) {
      this.a.add(parama);
    }
  }
  
  public void a(View paramView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramView);
    }
  }
  
  public void a(View paramView, float paramFloat)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramView, paramFloat);
    }
  }
  
  public void b(a parama)
  {
    this.a.remove(parama);
  }
  
  public void b(View paramView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).b(paramView);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/navigation/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */