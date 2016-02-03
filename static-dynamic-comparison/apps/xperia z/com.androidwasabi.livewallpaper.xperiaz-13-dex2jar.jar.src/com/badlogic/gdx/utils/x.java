package com.badlogic.gdx.utils;

import com.badlogic.gdx.g;
import com.badlogic.gdx.p;

class x
  implements p, Runnable
{
  private com.badlogic.gdx.a a;
  private long b;
  
  public x()
  {
    g.a.a(this);
    b();
  }
  
  public void a()
  {
    this.b = (System.nanoTime() / 1000000L);
    synchronized (v.a)
    {
      this.a = null;
      v.c();
      return;
    }
  }
  
  public void b()
  {
    long l1 = System.nanoTime() / 1000000L;
    long l2 = this.b;
    synchronized (v.a)
    {
      int j = v.a.b;
      int i = 0;
      while (i < j)
      {
        ((v)v.a.a(i)).a(l1 - l2);
        i += 1;
      }
      this.a = g.a;
      new Thread(this, "Timer").start();
      return;
    }
  }
  
  public void c()
  {
    a();
    g.a.b(this);
    v.b = null;
    v.a.b();
    v.c = null;
  }
  
  public void run()
  {
    for (;;)
    {
      long l1;
      synchronized (v.a)
      {
        if (this.a != g.a) {
          return;
        }
        long l2 = System.nanoTime() / 1000000L;
        int j = v.a.b;
        l1 = 5000L;
        int i = 0;
        if (i < j) {
          try
          {
            l1 = ((v)v.a.a(i)).a(l2, l1);
            i += 1;
          }
          catch (Throwable localThrowable)
          {
            throw new f("Task failed: " + ((v)v.a.a(i)).getClass().getName(), localThrowable);
          }
        }
      }
      if (this.a != g.a) {
        return;
      }
      if (l1 > 0L) {}
      try
      {
        v.a.wait(l1);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/utils/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */