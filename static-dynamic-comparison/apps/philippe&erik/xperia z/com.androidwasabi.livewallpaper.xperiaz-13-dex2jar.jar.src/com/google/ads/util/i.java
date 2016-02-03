package com.google.ads.util;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class i
{
  private static final Object a = new Object();
  private static int b = 0;
  private static HashMap<Class<?>, Integer> c = new HashMap();
  private final ArrayList<i.a<?>> d = new ArrayList();
  public final int u;
  
  public i()
  {
    synchronized (a)
    {
      int i = b;
      b = i + 1;
      this.u = i;
      Integer localInteger = (Integer)c.get(getClass());
      if (localInteger == null)
      {
        c.put(getClass(), Integer.valueOf(1));
        b.d("State created: " + toString());
        return;
      }
      c.put(getClass(), Integer.valueOf(localInteger.intValue() + 1));
    }
  }
  
  private void a(i.a<?> parama)
  {
    this.d.add(parama);
  }
  
  protected void finalize()
  {
    synchronized (a)
    {
      c.put(getClass(), Integer.valueOf(((Integer)c.get(getClass())).intValue() - 1));
      super.finalize();
      return;
    }
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "[" + this.u + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/util/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */