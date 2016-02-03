package com.pocket.m.c;

import com.ideashower.readitlater.e.o;
import com.pocket.m.a.k;
import java.util.ArrayList;
import java.util.Iterator;

public class c
  extends d
{
  protected final ArrayList a;
  protected final int b;
  protected final int c;
  protected final boolean d;
  protected final boolean e;
  
  public c(ArrayList paramArrayList, int paramInt1, int paramInt2, k paramk, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramk);
    this.a = paramArrayList;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
  }
  
  protected void c_()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        a((o)localIterator.next(), this.b, this.c, this.d, this.e);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */