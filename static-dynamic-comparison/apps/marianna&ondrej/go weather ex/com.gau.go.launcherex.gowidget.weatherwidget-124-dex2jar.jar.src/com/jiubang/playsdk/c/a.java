package com.jiubang.playsdk.c;

import java.util.concurrent.atomic.AtomicInteger;

public class a
  extends Thread
{
  private static final AtomicInteger a = new AtomicInteger();
  private static final AtomicInteger b = new AtomicInteger();
  
  public a(Runnable paramRunnable)
  {
    this(paramRunnable, "SDKThread");
  }
  
  public a(Runnable paramRunnable, String paramString)
  {
    super(paramRunnable, paramString + "-" + a.incrementAndGet());
    setUncaughtExceptionHandler(new b(this));
  }
  
  public void run()
  {
    try
    {
      b.incrementAndGet();
      super.run();
      return;
    }
    finally
    {
      b.decrementAndGet();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */