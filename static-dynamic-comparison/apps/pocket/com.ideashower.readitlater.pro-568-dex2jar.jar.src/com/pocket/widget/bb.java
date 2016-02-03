package com.pocket.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

public class bb
{
  private final ArrayList a = new ArrayList();
  private final View b;
  private final int c;
  
  public bb(View paramView, int paramInt)
  {
    this.b = paramView;
    this.c = paramInt;
  }
  
  private boolean b()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (!((bc)localIterator.next()).a()) {
        return false;
      }
    }
    return true;
  }
  
  public void a()
  {
    if (b())
    {
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(this.c);
  }
  
  public void a(bc parambc)
  {
    this.a.add(parambc);
    a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */