package com.pocket.c;

import com.ideashower.readitlater.g.m;
import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.objects.a;
import com.ideashower.readitlater.objects.b;
import com.ideashower.readitlater.util.e;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class f
  extends m
{
  private final AtomicInteger a = new AtomicInteger();
  protected int c;
  protected ErrorReport d;
  protected boolean e;
  protected boolean f;
  protected g g;
  
  public f(int paramInt)
  {
    this.c = paramInt;
    this.e = m();
  }
  
  protected int a(a parama)
  {
    parama.b();
    return c(parama);
  }
  
  protected void a()
  {
    a locala = k();
    if (locala != null)
    {
      b localb = l();
      if (localb != null) {
        locala.a(localb);
      }
      locala.a(this.e);
    }
    this.a.set(a(locala));
  }
  
  protected void a(int paramInt) {}
  
  public void a(g paramg)
  {
    this.g = paramg;
  }
  
  protected void a(boolean paramBoolean, Throwable paramThrowable)
  {
    for (;;)
    {
      try
      {
        if (a_()) {
          paramBoolean = false;
        }
        if (!paramBoolean)
        {
          if (a_()) {
            this.a.set(-3);
          }
        }
        else
        {
          a(this.a.get());
          if (this.g == null) {
            break;
          }
          this.g.a(this, u());
          return;
        }
        this.a.set(-4);
        if (this.d == null) {
          if (paramThrowable != null) {
            this.d = new ErrorReport(paramThrowable, -1);
          } else {
            this.d = new ErrorReport(-1, com.ideashower.readitlater.a.g.a(2131493043));
          }
        }
      }
      catch (Throwable paramThrowable)
      {
        e.a(paramThrowable, true);
        s();
        return;
      }
    }
  }
  
  protected int b(a parama)
  {
    this.d = parama.f();
    this.f = parama.g();
    return -5;
  }
  
  protected int c(a parama)
  {
    if (a_()) {}
    for (int i = 3;; i = parama.c()) {
      switch (i)
      {
      case 2: 
      default: 
        return b(parama);
      }
    }
    return d(parama);
    return e(parama);
    return f(parama);
  }
  
  protected int d(a parama)
  {
    return 3;
  }
  
  protected int e(a parama)
  {
    return -3;
  }
  
  protected int f(a parama)
  {
    if (!this.e) {
      return b(parama);
    }
    com.ideashower.readitlater.a.g.a(new Runnable()
    {
      public void run() {}
    });
    return -6;
  }
  
  protected abstract a k();
  
  protected abstract b l();
  
  protected boolean m()
  {
    return true;
  }
  
  protected void s() {}
  
  public ErrorReport t()
  {
    return this.d;
  }
  
  public boolean u()
  {
    return this.a.get() == 3;
  }
  
  public boolean v()
  {
    return this.f;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */