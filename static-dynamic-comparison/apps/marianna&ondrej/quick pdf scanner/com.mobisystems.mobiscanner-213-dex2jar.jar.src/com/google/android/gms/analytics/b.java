package com.google.android.gms.analytics;

import android.content.Context;
import java.util.ArrayList;

public class b
  implements Thread.UncaughtExceptionHandler
{
  private final Context mContext;
  private final Thread.UncaughtExceptionHandler mf;
  private final g mg;
  private a mh;
  
  public b(g paramg, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, Context paramContext)
  {
    if (paramg == null) {
      throw new NullPointerException("tracker cannot be null");
    }
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.mf = paramUncaughtExceptionHandler;
    this.mg = paramg;
    this.mh = new f(paramContext, new ArrayList());
    this.mContext = paramContext.getApplicationContext();
    paramContext = new StringBuilder().append("ExceptionReporter created, original handler is ");
    if (paramUncaughtExceptionHandler == null) {}
    for (paramg = "null";; paramg = paramUncaughtExceptionHandler.getClass().getName())
    {
      j.C(paramg);
      return;
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    String str = "UncaughtException";
    if (this.mh != null) {
      if (paramThread == null) {
        break label112;
      }
    }
    label112:
    for (str = paramThread.getName();; str = null)
    {
      str = this.mh.a(str, paramThrowable);
      j.C("Tracking Exception: " + str);
      this.mg.c(new d.b().R(str).q(true).kg());
      c.o(this.mContext).jG();
      if (this.mf != null)
      {
        j.C("Passing exception to original handler.");
        this.mf.uncaughtException(paramThread, paramThrowable);
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/analytics/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */