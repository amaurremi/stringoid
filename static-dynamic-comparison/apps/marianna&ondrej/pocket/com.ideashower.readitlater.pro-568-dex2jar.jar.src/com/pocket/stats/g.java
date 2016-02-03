package com.pocket.stats;

import com.ideashower.readitlater.g.m;
import com.ideashower.readitlater.objects.a;
import com.ideashower.readitlater.util.e;
import java.util.concurrent.atomic.AtomicInteger;

class g
  extends m
{
  private final a a;
  private final com.ideashower.readitlater.d.f b;
  private boolean c;
  
  public g(a parama, com.ideashower.readitlater.d.f paramf)
  {
    this.a = parama;
    this.b = paramf;
  }
  
  protected void a()
  {
    boolean bool = true;
    if (this.a == null)
    {
      this.c = false;
      return;
    }
    for (;;)
    {
      try
      {
        this.a.b();
        if (this.a.c() == 1)
        {
          this.c = bool;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        e.a(localThrowable);
        return;
      }
      bool = false;
    }
  }
  
  protected void a(boolean paramBoolean, Throwable paramThrowable)
  {
    if (this.b != null) {
      this.b.a(this.c);
    }
    f.b().decrementAndGet();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/stats/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */