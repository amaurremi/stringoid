package com.ideashower.readitlater.e;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class v
{
  private final int a;
  private AtomicInteger b = new AtomicInteger();
  private AtomicInteger c = new AtomicInteger();
  private AtomicInteger d = new AtomicInteger();
  private AtomicInteger e = new AtomicInteger();
  private AtomicLong f = new AtomicLong();
  
  public v(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong)
  {
    this.a = paramInt1;
    AtomicInteger localAtomicInteger = this.b;
    if (paramInt2 > 0) {}
    for (;;)
    {
      localAtomicInteger.set(paramInt2);
      this.c.set(paramInt3);
      this.d.set(paramInt4);
      a(paramInt5);
      this.f.set(paramLong);
      return;
      paramInt2 = 0;
    }
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    int i;
    if (paramInt > 100) {
      i = 100;
    }
    for (;;)
    {
      this.e.set(i);
      return;
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
    }
  }
  
  public int b()
  {
    return this.b.get();
  }
  
  public int c()
  {
    return this.c.get();
  }
  
  public int d()
  {
    return this.d.get();
  }
  
  public int e()
  {
    return this.e.get();
  }
  
  public long f()
  {
    return this.f.get();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/e/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */