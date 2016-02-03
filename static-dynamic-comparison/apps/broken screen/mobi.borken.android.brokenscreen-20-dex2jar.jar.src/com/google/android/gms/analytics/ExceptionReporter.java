package com.google.android.gms.analytics;

import android.content.Context;
import java.util.ArrayList;

public class ExceptionReporter
  implements Thread.UncaughtExceptionHandler
{
  private final Context mContext;
  private final Thread.UncaughtExceptionHandler tL;
  private final Tracker tM;
  private ExceptionParser tN;
  
  public ExceptionReporter(Tracker paramTracker, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, Context paramContext)
  {
    if (paramTracker == null) {
      throw new NullPointerException("tracker cannot be null");
    }
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.tL = paramUncaughtExceptionHandler;
    this.tM = paramTracker;
    this.tN = new StandardExceptionParser(paramContext, new ArrayList());
    this.mContext = paramContext.getApplicationContext();
    paramContext = new StringBuilder().append("ExceptionReporter created, original handler is ");
    if (paramUncaughtExceptionHandler == null) {}
    for (paramTracker = "null";; paramTracker = paramUncaughtExceptionHandler.getClass().getName())
    {
      aa.C(paramTracker);
      return;
    }
  }
  
  Thread.UncaughtExceptionHandler cy()
  {
    return this.tL;
  }
  
  public ExceptionParser getExceptionParser()
  {
    return this.tN;
  }
  
  public void setExceptionParser(ExceptionParser paramExceptionParser)
  {
    this.tN = paramExceptionParser;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    String str = "UncaughtException";
    if (this.tN != null) {
      if (paramThread == null) {
        break label112;
      }
    }
    label112:
    for (str = paramThread.getName();; str = null)
    {
      str = this.tN.getDescription(str, paramThrowable);
      aa.C("Tracking Exception: " + str);
      this.tM.send(new HitBuilders.ExceptionBuilder().setDescription(str).setFatal(true).build());
      GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
      if (this.tL != null)
      {
        aa.C("Passing exception to original handler.");
        this.tL.uncaughtException(paramThread, paramThrowable);
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/analytics/ExceptionReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */