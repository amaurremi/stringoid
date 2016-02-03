package com.pocket.l.a;

import java.util.ArrayList;
import java.util.Iterator;

public class e
  extends a
{
  private final ArrayList a = new ArrayList();
  
  public b a(boolean paramBoolean)
  {
    return new f(this, paramBoolean, null);
  }
  
  public void a(float paramFloat)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(a parama)
  {
    this.a.add(parama);
  }
  
  public void b(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).b(paramInt);
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).d();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/l/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */