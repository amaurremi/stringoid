package com.jiubang.core.a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class f
{
  private static int a = 30;
  private static volatile f b;
  private static Thread c;
  private static volatile boolean d;
  private static volatile boolean e;
  private static volatile boolean f;
  private static List g = new ArrayList();
  private static ConcurrentLinkedQueue h = new ConcurrentLinkedQueue();
  
  public static void a()
  {
    if (b != null)
    {
      if (g.size() == 0)
      {
        e = true;
        c = null;
        b = null;
      }
    }
    else {
      return;
    }
    f = true;
  }
  
  public static void a(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("XAEngine init ,tickFrame must>0");
    }
    if (b == null) {
      b = new f();
    }
    b(paramInt);
    e = false;
    f = false;
  }
  
  public static void a(c paramc)
  {
    if (paramc == null) {
      throw new IllegalArgumentException("ticker cannot be null");
    }
    try
    {
      com.gtp.a.a.b.c.a("XAEngine", "addTicker");
      if (!g.contains(paramc)) {
        g.add(paramc);
      }
      h.remove(paramc);
      return;
    }
    finally {}
  }
  
  public static void b()
  {
    d = false;
    if (c == null) {
      f();
    }
  }
  
  public static void b(int paramInt)
  {
    a = paramInt;
  }
  
  private static void b(long paramLong)
  {
    for (;;)
    {
      int i;
      try
      {
        int j = g.size();
        i = 0;
        if (i < j)
        {
          c localc = (c)g.get(i);
          if (localc != null) {
            localc.a(paramLong);
          }
        }
        else
        {
          if ((j == 0) && (f)) {
            a();
          }
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public static void b(c paramc)
  {
    if (paramc == null) {
      throw new IllegalArgumentException("ticker cannot be null");
    }
    if (!e) {
      h.offer(paramc);
    }
  }
  
  public static void c()
  {
    d = true;
  }
  
  public static void d()
  {
    if (!e)
    {
      d = false;
      if (c != null) {
        synchronized (c)
        {
          c.notify();
          return;
        }
      }
      f();
    }
  }
  
  public static boolean e()
  {
    return d;
  }
  
  protected static void f()
  {
    c = new g("XAEngine_ticker");
    c.start();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */