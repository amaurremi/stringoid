package com.scoreloop.client.android.core.controller;

import com.scoreloop.client.android.core.model.Range;
import java.util.Collections;
import java.util.List;

class d<T>
{
  private boolean a = true;
  private boolean b = false;
  private Range c = null;
  private List<T> d = Collections.emptyList();
  private int e = 25;
  
  private void b(List<T> paramList)
  {
    this.d = Collections.unmodifiableList(paramList);
  }
  
  private void j()
  {
    if (!g()) {
      throw new IllegalStateException("_lastRequestedRange must not be null");
    }
  }
  
  public int a()
  {
    j();
    return this.c.getLength() + 1;
  }
  
  public void a(int paramInt)
  {
    this.c = new Range(paramInt, this.e);
  }
  
  public void a(List<T> paramList)
  {
    boolean bool2 = true;
    j();
    if (this.c.getLocation() > 0)
    {
      bool1 = true;
      this.b = bool1;
      if (paramList.size() <= this.c.getLength()) {
        break label85;
      }
    }
    label85:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.a = bool1;
      while (paramList.size() > this.c.getLength()) {
        paramList.remove(paramList.size() - 1);
      }
      bool1 = false;
      break;
    }
    b(paramList);
  }
  
  public int b()
  {
    j();
    return this.c.getLocation();
  }
  
  public void b(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 100)) {
      throw new IllegalArgumentException("invalid range length");
    }
    this.e = paramInt;
  }
  
  public int c()
  {
    j();
    return this.c.getLocation() + this.d.size();
  }
  
  public void c(int paramInt)
  {
    j();
    this.c.a(paramInt);
  }
  
  public List<T> d()
  {
    return this.d;
  }
  
  public int e()
  {
    j();
    return Math.max(0, this.c.getLocation() - this.e);
  }
  
  public int f()
  {
    return this.e;
  }
  
  public boolean g()
  {
    return this.c != null;
  }
  
  public boolean h()
  {
    return this.a;
  }
  
  public boolean i()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */