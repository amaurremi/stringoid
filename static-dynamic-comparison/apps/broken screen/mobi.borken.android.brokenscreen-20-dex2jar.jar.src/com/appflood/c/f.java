package com.appflood.c;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import com.appflood.b.b;
import com.appflood.e.j;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadPoolExecutor;

public final class f
{
  public static String a;
  private static Timer b;
  private static Handler c;
  private static WeakReference<Thread> d;
  private static com.appflood.b.a e;
  private static com.appflood.a.a f;
  private static Context g;
  private static h h;
  private static File i = null;
  
  public static void a()
  {
    if (c == null) {
      c = new Handler();
    }
    if (d == null) {
      d = new WeakReference(Thread.currentThread());
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    new StringBuilder(" ctx = ctx = ").append(paramContext).toString();
    j.a();
    if (i == null) {
      i = paramContext.getFileStreamPath("com_appflood_provider_file");
    }
    if (b == null) {
      b = new Timer("appflood timer");
    }
    if (e == null) {
      e = new com.appflood.b.a();
    }
    if (f == null) {
      f = new com.appflood.a.a("ppy_cross", paramContext);
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = com.appflood.e.a.a(f.a("ppyid"));
      if ((localObject != null) && (localObject.length == 32)) {
        a = j.a((byte[])localObject, null);
      }
      if ((a == null) || (a.length() != 32) || (a.charAt(0) < '0') || (a.charAt(0) > 'z'))
      {
        a = j.b();
        if (!f.a("ppyid", j.b(a))) {
          j.c("Can't write cache initially!");
        }
      }
      g = paramContext;
      if (paramContext != null) {
        break label216;
      }
      j.c("context ctx is null");
    }
    for (;;)
    {
      d.a(new d.a()
      {
        public final void a()
        {
          f.a(f.h());
        }
      });
      return;
      label216:
      h = new h();
      localObject = new IntentFilter("com.papayamobile.ACTION_RETURN_VIRTUAL_ID");
      paramContext.registerReceiver(h, (IntentFilter)localObject);
    }
  }
  
  public static void a(Runnable paramRunnable)
  {
    if (c != null)
    {
      if (Thread.currentThread() != d.get()) {
        c.post(paramRunnable);
      }
    }
    else {
      return;
    }
    try
    {
      paramRunnable.run();
      return;
    }
    catch (Throwable paramRunnable)
    {
      j.b(paramRunnable, "Error occurred in handler run thread " + paramRunnable.toString());
    }
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    if (c != null) {
      c.postDelayed(paramRunnable, paramLong);
    }
  }
  
  public static void a(TimerTask paramTimerTask, long paramLong)
  {
    if (b != null) {
      b.schedule(paramTimerTask, paramLong);
    }
  }
  
  public static Context b()
  {
    return g;
  }
  
  public static com.appflood.a.a c()
  {
    return f;
  }
  
  public static com.appflood.b.a d()
  {
    return e;
  }
  
  public static File e()
  {
    return i;
  }
  
  public static void f()
  {
    ??? = g;
    if (??? == null) {
      j.c("context ctx is null");
    }
    for (;;)
    {
      g = null;
      if (e != null) {}
      synchronized (e)
      {
        Iterator localIterator = ((com.appflood.b.a)???).a.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            b localb = (b)localIterator.next();
            try
            {
              localb.a(null);
            }
            catch (Throwable localThrowable2) {}
            continue;
            if (h == null) {
              break;
            }
            try
            {
              ((Context)???).unregisterReceiver(h);
              h = null;
            }
            catch (Exception localException)
            {
              j.a(localException, "failed to unregister Receiver");
            }
            break;
          }
        }
        localException.a.clear();
        try
        {
          if (localException.b != null) {
            localException.b.shutdownNow();
          }
          localException.b = null;
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            j.b(localThrowable1, "failed to shutdown the httpservice");
          }
        }
        e = null;
        if (b != null)
        {
          b.cancel();
          b = null;
        }
        return;
      }
    }
  }
  
  public static boolean g()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (c != null)
    {
      bool1 = bool2;
      if (Thread.currentThread() == d.get()) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */