package com.pocket.c;

import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.service.WakefulAppService;
import com.pocket.p.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class al
{
  private final ArrayList a = new ArrayList();
  private final Runnable b = new Runnable()
  {
    public void run()
    {
      al.a(al.this, true);
    }
  };
  private final Runnable c = new Runnable()
  {
    public void run()
    {
      al.a(al.this, false);
    }
  };
  private final Object d = new Object();
  private boolean e;
  private o f;
  private ah g;
  
  private void b(boolean paramBoolean)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      am localam = (am)((WeakReference)localIterator.next()).get();
      if (localam != null) {
        if (paramBoolean) {
          localam.b();
        } else {
          localam.a();
        }
      }
    }
  }
  
  protected void a(float paramFloat)
  {
    if (!p.a(this.a))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((am)localWeakReference.get()).a(paramFloat);
        }
      }
    }
  }
  
  protected void a(ah paramah)
  {
    synchronized (this.d)
    {
      this.g = paramah;
      return;
    }
  }
  
  public void a(am paramam)
  {
    this.a.add(new WeakReference(paramam));
    paramam = this.a.iterator();
    while (paramam.hasNext()) {
      if (((WeakReference)paramam.next()).get() == null) {
        paramam.remove();
      }
    }
  }
  
  protected void a(o paramo)
  {
    synchronized (this.d)
    {
      this.f = paramo;
      return;
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.d)
      {
        if (this.e == paramBoolean) {
          return;
        }
        this.e = paramBoolean;
        WakefulAppService.a("SyncDelegate sync state changed");
        if (paramBoolean)
        {
          ??? = this.b;
          g.a((Runnable)???);
          return;
        }
      }
      ??? = this.c;
    }
  }
  
  public boolean a()
  {
    for (;;)
    {
      synchronized (this.d)
      {
        if ((this.e) && (!b()))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void b(am paramam)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (((WeakReference)localIterator.next()).get() == paramam) {
        localIterator.remove();
      }
    }
  }
  
  public boolean b()
  {
    for (;;)
    {
      synchronized (this.d)
      {
        if ((this.g == null) || (!this.g.a_()))
        {
          if ((this.f == null) || (!this.f.a_())) {
            break label58;
          }
          break label53;
          return bool;
        }
      }
      label53:
      boolean bool = true;
      continue;
      label58:
      bool = false;
    }
  }
  
  protected o c()
  {
    synchronized (this.d)
    {
      o localo = this.f;
      return localo;
    }
  }
  
  protected ah d()
  {
    synchronized (this.d)
    {
      ah localah = this.g;
      return localah;
    }
  }
  
  protected void e()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((am)localWeakReference.get()).d();
      }
    }
  }
  
  protected void f()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((am)localWeakReference.get()).c();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */