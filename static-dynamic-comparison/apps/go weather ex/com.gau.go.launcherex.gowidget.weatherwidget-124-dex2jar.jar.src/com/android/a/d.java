package com.android.a;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public class d
  extends Thread
{
  private static final boolean a = ab.b;
  private final BlockingQueue b;
  private final BlockingQueue c;
  private final b d;
  private final w e;
  private volatile boolean f = false;
  
  public d(BlockingQueue paramBlockingQueue1, BlockingQueue paramBlockingQueue2, b paramb, w paramw)
  {
    this.b = paramBlockingQueue1;
    this.c = paramBlockingQueue2;
    this.d = paramb;
    this.e = paramw;
  }
  
  public void a()
  {
    this.f = true;
    interrupt();
  }
  
  public void run()
  {
    if (a) {
      ab.a("start new dispatcher", new Object[0]);
    }
    Process.setThreadPriority(10);
    this.d.a();
    for (;;)
    {
      try
      {
        p localp = (p)this.b.take();
        localp.a("cache-queue-take");
        if (!localp.h()) {
          break label73;
        }
        localp.b("cache-discard-canceled");
        continue;
        if (!this.f) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException) {}
      return;
      label73:
      c localc = this.d.a(localInterruptedException.e());
      if (localc == null)
      {
        localInterruptedException.a("cache-miss");
        this.c.put(localInterruptedException);
      }
      else if (localc.a())
      {
        localInterruptedException.a("cache-hit-expired");
        localInterruptedException.a(localc);
        this.c.put(localInterruptedException);
      }
      else
      {
        localInterruptedException.a("cache-hit");
        t localt = localInterruptedException.a(new m(localc.a, localc.f));
        localInterruptedException.a("cache-hit-parsed");
        if (!localc.b())
        {
          this.e.a(localInterruptedException, localt);
        }
        else
        {
          localInterruptedException.a("cache-hit-refresh-needed");
          localInterruptedException.a(localc);
          localt.d = true;
          this.e.a(localInterruptedException, localt, new e(this, localInterruptedException));
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */