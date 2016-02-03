package com.ideashower.readitlater.g;

import java.util.Comparator;

public class e
  implements Comparator
{
  public int a(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    paramRunnable1 = (d)paramRunnable1;
    paramRunnable2 = (d)paramRunnable2;
    long l = paramRunnable2.b() - paramRunnable1.b();
    if (l == 0L) {
      return Long.signum(paramRunnable1.c() - paramRunnable2.c());
    }
    return Long.signum(l);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/g/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */