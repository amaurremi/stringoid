package com.google.android.gms.internal;

public final class ab
  extends aq
{
  private final Object a = new Object();
  private af b;
  private aa c;
  
  public final void a()
  {
    synchronized (this.a)
    {
      if (this.c != null) {
        this.c.j();
      }
      return;
    }
  }
  
  public final void a(int paramInt)
  {
    synchronized (this.a)
    {
      if (this.b != null)
      {
        if (paramInt == 3)
        {
          paramInt = 1;
          this.b.a(paramInt);
          this.b = null;
        }
      }
      else {
        return;
      }
      paramInt = 2;
    }
  }
  
  public final void a(aa paramaa)
  {
    synchronized (this.a)
    {
      this.c = paramaa;
      return;
    }
  }
  
  public final void a(af paramaf)
  {
    synchronized (this.a)
    {
      this.b = paramaf;
      return;
    }
  }
  
  public final void b()
  {
    synchronized (this.a)
    {
      if (this.c != null) {
        this.c.k();
      }
      return;
    }
  }
  
  public final void c()
  {
    synchronized (this.a)
    {
      if (this.c != null) {
        this.c.l();
      }
      return;
    }
  }
  
  public final void d()
  {
    synchronized (this.a)
    {
      if (this.c != null) {
        this.c.m();
      }
      return;
    }
  }
  
  public final void e()
  {
    synchronized (this.a)
    {
      if (this.b != null)
      {
        this.b.a(0);
        this.b = null;
        return;
      }
      if (this.c != null) {
        this.c.n();
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */