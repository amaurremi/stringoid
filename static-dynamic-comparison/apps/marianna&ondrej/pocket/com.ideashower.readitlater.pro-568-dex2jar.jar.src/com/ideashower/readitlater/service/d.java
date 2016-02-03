package com.ideashower.readitlater.service;

import android.os.Handler;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.util.m;
import com.pocket.c.e;
import com.pocket.stats.f;
import java.util.concurrent.atomic.AtomicBoolean;

class d
  implements Runnable
{
  private long b;
  
  private d(WakefulAppService paramWakefulAppService)
  {
    a();
  }
  
  public void a()
  {
    this.b = System.currentTimeMillis();
  }
  
  public void run()
  {
    int i = 1;
    boolean bool = WakefulAppService.g().getAndSet(false);
    StringBuilder localStringBuilder;
    if (WakefulAppService.h()) {
      if (WakefulAppService.a(this.a) == 1)
      {
        if (i == 0) {
          return;
        }
        this.a.a.postDelayed(this, 15000L);
        if ((!g.y()) || (g.u()) || (m.a(this.b) <= 3600000L)) {
          return;
        }
        localStringBuilder = new StringBuilder().append("A: ").append(g.j());
        if (!e.n()) {
          break label296;
        }
        str = " S: true" + e.g();
        label120:
        localStringBuilder = localStringBuilder.append(str);
        if (!com.pocket.m.a.j()) {
          break label302;
        }
      }
    }
    label296:
    label302:
    for (String str = " OF: true (" + com.pocket.m.a.o() + "/" + com.pocket.m.a.n() + ")";; str = " OF: false")
    {
      str = str + " DB: " + com.ideashower.readitlater.db.operation.d.g() + " BS: " + a.a() + " ST: " + f.a();
      throw new RuntimeException("Suspected non released wake lock - " + str);
      WakefulAppService.a(this.a, 1);
      WakefulAppService.a(true, WakefulAppService.f());
      break;
      if ((WakefulAppService.a(this.a) == 2) && (!bool))
      {
        WakefulAppService.b();
        i = 0;
        break;
      }
      WakefulAppService.a(this.a, 2);
      break;
      str = " S: false";
      break label120;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/service/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */