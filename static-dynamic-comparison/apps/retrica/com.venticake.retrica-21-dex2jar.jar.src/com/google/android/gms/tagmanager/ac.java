package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class ac
  extends Thread
  implements ab
{
  private static ac d;
  private final LinkedBlockingQueue<Runnable> a = new LinkedBlockingQueue();
  private volatile boolean b = false;
  private volatile boolean c = false;
  private volatile ad e;
  private final Context f;
  
  private ac(Context paramContext)
  {
    super("GAThread");
    if (paramContext != null) {}
    for (this.f = paramContext.getApplicationContext();; this.f = paramContext)
    {
      start();
      return;
    }
  }
  
  static ac a(Context paramContext)
  {
    if (d == null) {
      d = new ac(paramContext);
    }
    return d;
  }
  
  private String a(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  public void a(Runnable paramRunnable)
  {
    this.a.add(paramRunnable);
  }
  
  public void a(String paramString)
  {
    a(paramString, System.currentTimeMillis());
  }
  
  void a(String paramString, final long paramLong)
  {
    a(new Runnable()
    {
      public void run()
      {
        if (ac.a(ac.this) == null)
        {
          cs localcs = cs.b();
          localcs.a(ac.b(ac.this), jdField_this);
          ac.a(ac.this, localcs.c());
        }
        ac.a(ac.this).a(paramLong, this.c);
      }
    });
  }
  
  public void run()
  {
    while (!this.c) {
      try
      {
        Runnable localRunnable = (Runnable)this.a.take();
        if (!this.b) {
          localRunnable.run();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        as.c(localInterruptedException.toString());
      }
      catch (Throwable localThrowable)
      {
        as.a("Error on GAThread: " + a(localThrowable));
        as.a("Google Analytics is shutting down.");
        this.b = true;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */