package com.flurry.sdk;

import java.util.Comparator;

public class ee
  implements Comparator<Runnable>
{
  private static final String a = ee.class.getSimpleName();
  
  private int a(Runnable paramRunnable)
  {
    int i = Integer.MAX_VALUE;
    if (paramRunnable != null)
    {
      if (!(paramRunnable instanceof ef)) {
        break label36;
      }
      paramRunnable = (fg)((ef)paramRunnable).a();
      if (paramRunnable == null) {
        break label87;
      }
    }
    label36:
    label87:
    for (i = paramRunnable.i();; i = Integer.MAX_VALUE)
    {
      return i;
      if ((paramRunnable instanceof fg)) {
        return ((fg)paramRunnable).i();
      }
      eo.a(6, a, "Unknown runnable class: " + paramRunnable.getClass().getName());
      return Integer.MAX_VALUE;
    }
  }
  
  public int a(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    int i = a(paramRunnable1);
    int j = a(paramRunnable2);
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/flurry/sdk/ee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */