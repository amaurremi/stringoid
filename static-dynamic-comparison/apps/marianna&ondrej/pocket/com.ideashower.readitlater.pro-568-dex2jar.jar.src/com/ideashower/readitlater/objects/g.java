package com.ideashower.readitlater.objects;

import com.ideashower.readitlater.util.e;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class g
{
  private CountDownLatch a = new CountDownLatch(1);
  private final AtomicInteger b = new AtomicInteger();
  private final AtomicBoolean c = new AtomicBoolean(false);
  private String d;
  
  public void a()
  {
    this.b.getAndIncrement();
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void b()
  {
    if (this.b.decrementAndGet() <= 0) {
      c();
    }
  }
  
  public void c()
  {
    if (this.c.get()) {
      this.a.countDown();
    }
    this.b.set(0);
  }
  
  public boolean d()
  {
    if (this.b.get() <= 0) {
      return true;
    }
    try
    {
      this.c.set(true);
      this.a.await(2160000L, TimeUnit.SECONDS);
      this.c.set(false);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      e.a(localInterruptedException);
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/objects/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */