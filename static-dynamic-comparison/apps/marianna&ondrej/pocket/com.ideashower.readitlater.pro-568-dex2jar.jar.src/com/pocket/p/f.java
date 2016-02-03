package com.pocket.p;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class f
{
  private final SortedSet a = new TreeSet();
  
  public f a(int paramInt, float paramFloat)
  {
    this.a.add(new g(this, paramInt, paramFloat, null));
    return this;
  }
  
  public float[] a()
  {
    float[] arrayOfFloat = new float[this.a.size()];
    Iterator localIterator = this.a.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      arrayOfFloat[i] = g.b((g)localIterator.next());
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public int[] b()
  {
    int[] arrayOfInt = new int[this.a.size()];
    Iterator localIterator = this.a.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      arrayOfInt[i] = g.c((g)localIterator.next());
      i += 1;
    }
    return arrayOfInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/p/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */