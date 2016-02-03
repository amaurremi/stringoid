package com.google.analytics.tracking.android;

import android.content.Context;
import java.util.ArrayList;

public class n
  implements Thread.UncaughtExceptionHandler
{
  private final ab il;
  private final Thread.UncaughtExceptionHandler it;
  private final af iu;
  private m iv;
  
  public n(af paramaf, ab paramab, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, Context paramContext)
  {
    if (paramaf == null) {
      throw new NullPointerException("tracker cannot be null");
    }
    if (paramab == null) {
      throw new NullPointerException("serviceManager cannot be null");
    }
    this.it = paramUncaughtExceptionHandler;
    this.iu = paramaf;
    this.il = paramab;
    this.iv = new ae(paramContext, new ArrayList());
    paramab = new StringBuilder().append("ExceptionReporter created, original handler is ");
    if (paramUncaughtExceptionHandler == null) {}
    for (paramaf = "null";; paramaf = paramUncaughtExceptionHandler.getClass().getName())
    {
      v.C(paramaf);
      return;
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    String str = "UncaughtException";
    if (this.iv != null) {
      if (paramThread == null) {
        break label102;
      }
    }
    label102:
    for (str = paramThread.getName();; str = null)
    {
      str = this.iv.a(str, paramThrowable);
      v.C("Tracking Exception: " + str);
      this.iu.c(w.a(str, Boolean.valueOf(true)).kg());
      this.il.jG();
      if (this.it != null)
      {
        v.C("Passing exception to original handler.");
        this.it.uncaughtException(paramThread, paramThrowable);
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/analytics/tracking/android/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */