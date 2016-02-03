package com.pocket.m;

import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.service.WakefulAppService;
import com.ideashower.readitlater.util.e;

class d
  implements Runnable
{
  private final boolean a;
  
  public d(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void run()
  {
    a.q().a(5, true);
    a.r().a(5, true);
    int i = 0;
    while (i < 15) {
      try
      {
        Thread.sleep(1000L);
        if ((g.k()) && ((!this.a) || (g.l())))
        {
          a.q().a(5);
          a.r().a(5);
          a.a(null);
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          e.a(localInterruptedException);
        }
        i += 1;
      }
    }
    if (this.a) {}
    for (i = 2131493746;; i = 2131493745)
    {
      WakefulAppService.a(i, 1);
      a.d();
      a.a(null);
      a.q().a(5);
      a.r().a(5);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */