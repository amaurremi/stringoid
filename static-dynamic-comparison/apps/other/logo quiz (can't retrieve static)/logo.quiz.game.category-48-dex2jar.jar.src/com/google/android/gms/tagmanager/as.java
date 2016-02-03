package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class as
  extends Thread
  implements ar
{
  private static as ape;
  private final LinkedBlockingQueue<Runnable> apd = new LinkedBlockingQueue();
  private volatile at apf;
  private volatile boolean mClosed = false;
  private final Context mContext;
  private volatile boolean yU = false;
  
  private as(Context paramContext)
  {
    super("GAThread");
    if (paramContext != null) {}
    for (this.mContext = paramContext.getApplicationContext();; this.mContext = paramContext)
    {
      start();
      return;
    }
  }
  
  static as Y(Context paramContext)
  {
    if (ape == null) {
      ape = new as(paramContext);
    }
    return ape;
  }
  
  private String g(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  public void b(Runnable paramRunnable)
  {
    this.apd.add(paramRunnable);
  }
  
  void b(String paramString, final long paramLong)
  {
    b(new Runnable()
    {
      public void run()
      {
        if (as.a(as.this) == null)
        {
          cy localcy = cy.pu();
          localcy.a(as.b(as.this), jdField_this);
          as.a(as.this, localcy.pv());
        }
        as.a(as.this).f(paramLong, this.wz);
      }
    });
  }
  
  public void cz(String paramString)
  {
    b(paramString, System.currentTimeMillis());
  }
  
  public void run()
  {
    while (!this.mClosed) {
      try
      {
        Runnable localRunnable = (Runnable)this.apd.take();
        if (!this.yU) {
          localRunnable.run();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        bh.U(localInterruptedException.toString());
      }
      catch (Throwable localThrowable)
      {
        bh.T("Error on Google TagManager Thread: " + g(localThrowable));
        bh.T("Google TagManager is shutting down.");
        this.yU = true;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */