package com.pocket.m.e;

import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.g.j;
import com.pocket.m.b.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
{
  private final com.ideashower.readitlater.g.f a;
  private final ArrayList b = new ArrayList();
  private AtomicBoolean c = new AtomicBoolean(false);
  private AtomicBoolean d = new AtomicBoolean(false);
  private AtomicBoolean e = new AtomicBoolean(false);
  private AtomicBoolean f = new AtomicBoolean(false);
  private AtomicBoolean g = new AtomicBoolean(false);
  
  public a(int paramInt, f paramf)
  {
    this.a = new com.ideashower.readitlater.g.f(paramf.a(), "off-queue");
    while (paramInt < paramf.a())
    {
      this.b.add(new c(paramf.b(), paramf.c()));
      paramInt += 1;
    }
  }
  
  private boolean b(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    }
    while ((this.c.get()) && (this.e.get()) && (this.d.get()) && (this.f.get()))
    {
      return true;
      this.c.set(paramBoolean);
      continue;
      this.d.set(paramBoolean);
      continue;
      this.e.set(paramBoolean);
      continue;
      this.f.set(paramBoolean);
      continue;
      this.g.set(paramBoolean);
    }
    return false;
  }
  
  public c a(com.pocket.m.b.f paramf)
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.a())
        {
          localc.a(paramf);
          return localc;
        }
      }
      return null;
    }
  }
  
  public void a(e parame)
  {
    this.a.a(parame);
  }
  
  public void a(f paramf)
  {
    this.a.a(paramf.a(), paramf.a());
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      if (localIterator.hasNext()) {
        ((c)localIterator.next()).a(paramf.b(), paramf.c());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    com.ideashower.readitlater.g.f localf = this.a;
    if (paramBoolean) {}
    for (j local3 = new j()
        {
          public void a(boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean) {
              return;
            }
            com.pocket.m.a.e();
          }
        };; local3 = null)
    {
      localf.a(local3);
      return;
    }
  }
  
  public boolean a()
  {
    return this.a.g();
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    if (!b(paramInt, false))
    {
      this.a.f();
      g.a(new Runnable()
      {
        public void run()
        {
          new b(a.this, false).h();
        }
      });
      bool = true;
    }
    return bool;
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    b(paramInt, true);
    this.a.e();
    if (paramBoolean) {
      g.a(new Runnable()
      {
        public void run()
        {
          new b(a.this, true).h();
        }
      });
    }
    return true;
  }
  
  public void b()
  {
    this.a.a(false);
  }
  
  public void c()
  {
    this.a.a(60, TimeUnit.SECONDS);
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      if (localIterator.hasNext()) {
        ((c)localIterator.next()).g();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */