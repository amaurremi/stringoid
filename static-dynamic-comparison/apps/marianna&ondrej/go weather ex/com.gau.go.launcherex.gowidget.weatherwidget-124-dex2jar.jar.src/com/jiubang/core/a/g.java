package com.jiubang.core.a;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

final class g
  extends Thread
{
  g(String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    for (;;)
    {
      if (!f.g())
      {
        if (!f.h().isEmpty())
        {
          Iterator localIterator = f.h().iterator();
          while (localIterator.hasNext())
          {
            c localc = (c)localIterator.next();
            f.i().remove(localc);
          }
          f.h().clear();
        }
        long l1 = System.currentTimeMillis();
        f.a(l1);
        long l2 = System.currentTimeMillis();
        l2 = f.j() - (l2 - l1);
        l1 = l2;
        if (l2 < 3L) {
          l1 = 3L;
        }
        try
        {
          Thread.sleep(l1);
          try
          {
            if (f.k())
            {
              com.gtp.a.a.b.c.a("XAEngine", "XAEngine_ticker Wait");
              wait();
            }
          }
          finally {}
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
    f.i().clear();
    f.h().clear();
    com.gtp.a.a.b.c.a("XAEngine", "XAEngine_ticker Destroy");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */