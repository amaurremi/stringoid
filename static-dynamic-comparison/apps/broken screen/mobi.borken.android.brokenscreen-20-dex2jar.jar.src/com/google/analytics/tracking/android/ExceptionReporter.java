package com.google.analytics.tracking.android;

import android.content.Context;
import java.util.ArrayList;

public class ExceptionReporter
  implements Thread.UncaughtExceptionHandler
{
  static final String DEFAULT_DESCRIPTION = "UncaughtException";
  private ExceptionParser mExceptionParser;
  private final Thread.UncaughtExceptionHandler mOriginalHandler;
  private final ServiceManager mServiceManager;
  private final Tracker mTracker;
  
  public ExceptionReporter(Tracker paramTracker, ServiceManager paramServiceManager, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, Context paramContext)
  {
    if (paramTracker == null) {
      throw new NullPointerException("tracker cannot be null");
    }
    if (paramServiceManager == null) {
      throw new NullPointerException("serviceManager cannot be null");
    }
    this.mOriginalHandler = paramUncaughtExceptionHandler;
    this.mTracker = paramTracker;
    this.mServiceManager = paramServiceManager;
    this.mExceptionParser = new StandardExceptionParser(paramContext, new ArrayList());
    paramServiceManager = new StringBuilder().append("ExceptionReporter created, original handler is ");
    if (paramUncaughtExceptionHandler == null) {}
    for (paramTracker = "null";; paramTracker = paramUncaughtExceptionHandler.getClass().getName())
    {
      Log.v(paramTracker);
      return;
    }
  }
  
  public ExceptionParser getExceptionParser()
  {
    return this.mExceptionParser;
  }
  
  public void setExceptionParser(ExceptionParser paramExceptionParser)
  {
    this.mExceptionParser = paramExceptionParser;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    String str = "UncaughtException";
    if (this.mExceptionParser != null) {
      if (paramThread == null) {
        break label102;
      }
    }
    label102:
    for (str = paramThread.getName();; str = null)
    {
      str = this.mExceptionParser.getDescription(str, paramThrowable);
      Log.v("Tracking Exception: " + str);
      this.mTracker.send(MapBuilder.createException(str, Boolean.valueOf(true)).build());
      this.mServiceManager.dispatchLocalHits();
      if (this.mOriginalHandler != null)
      {
        Log.v("Passing exception to original handler.");
        this.mOriginalHandler.uncaughtException(paramThread, paramThrowable);
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/analytics/tracking/android/ExceptionReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */