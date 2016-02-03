package com.jirbo.adcolony;

import android.app.Activity;
import java.io.PrintStream;

class p
  implements Runnable
{
  public static final int a = 5;
  public static final int b = 10;
  static String c = "MONITOR_MUTEX";
  static volatile p d;
  static volatile long e;
  
  static void a()
  {
    synchronized (c)
    {
      e = System.currentTimeMillis();
      if (d == null)
      {
        a.b("Creating ADC Monitor singleton.");
        d = new p();
        new Thread(d).start();
      }
      return;
    }
  }
  
  void a(long paramLong)
  {
    try
    {
      Thread.sleep(paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public void run()
  {
    a.a(a.n);
    l.a.b("ADC Monitor Started.");
    a.l.b();
    int j = 0;
    for (;;)
    {
      long l2;
      long l1;
      int k;
      if (!AdColony.activity().isFinishing())
      {
        l2 = System.currentTimeMillis();
        a.r = false;
        a.l.g();
        if (!a.r) {
          break label170;
        }
        l1 = 50L;
        k = (int)((System.currentTimeMillis() - e) / 1000L);
        a.l.g();
        if ((j != 0) && (k < 10)) {
          break label193;
        }
      }
      synchronized (c)
      {
        d = null;
        if (j == 0) {
          a.l.c();
        }
        if (AdColony.activity().isFinishing())
        {
          a.s = true;
          a(5000L);
          if (a.s)
          {
            l.c.b("ADC.finishing, controller on_stop");
            a.l.d();
            aa.a();
          }
        }
        System.out.println("Exiting monitor");
        return;
        label170:
        if (j != 0) {}
        for (int i = 2000;; i = 250)
        {
          l1 = i;
          break;
        }
        label193:
        i = j;
        if (k < 5)
        {
          a.l.b();
          a.b("AdColony is active.");
          i = 0;
        }
        do
        {
          a(l1);
          l1 = System.currentTimeMillis();
          j = i;
          if (l1 - l2 > 3000L) {
            break;
          }
          j = i;
          if (l1 - l2 <= 0L) {
            break;
          }
          ??? = a.l.e;
          double d1 = ((v)???).h;
          ((v)???).h = ((l1 - l2) / 1000.0D + d1);
          j = i;
          break;
          i = j;
        } while (k < 5);
        a.b("AdColony is idle.");
        a.l.c();
        i = 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */