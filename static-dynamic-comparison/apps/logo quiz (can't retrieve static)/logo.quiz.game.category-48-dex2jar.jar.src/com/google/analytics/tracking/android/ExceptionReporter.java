package com.google.analytics.tracking.android;

public class ExceptionReporter
  implements Thread.UncaughtExceptionHandler
{
  private ExceptionParser exceptionParser;
  private final Thread.UncaughtExceptionHandler originalHandler;
  private final ServiceManager serviceManager;
  private final Tracker tracker;
  
  public ExceptionReporter(Tracker paramTracker, ServiceManager paramServiceManager, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    if (paramTracker == null) {
      throw new NullPointerException("tracker cannot be null");
    }
    if (paramServiceManager == null) {
      throw new NullPointerException("serviceManager cannot be null");
    }
    this.originalHandler = paramUncaughtExceptionHandler;
    this.tracker = paramTracker;
    this.serviceManager = paramServiceManager;
    paramServiceManager = new StringBuilder().append("ExceptionReporter created, original handler is ");
    if (paramUncaughtExceptionHandler == null) {}
    for (paramTracker = "null";; paramTracker = paramUncaughtExceptionHandler.getClass().getName())
    {
      Log.iDebug(paramTracker);
      return;
    }
  }
  
  public ExceptionParser getExceptionParser()
  {
    return this.exceptionParser;
  }
  
  public void setExceptionParser(ExceptionParser paramExceptionParser)
  {
    this.exceptionParser = paramExceptionParser;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (this.exceptionParser == null)
    {
      str = paramThrowable.getMessage();
      Log.iDebug("Tracking Exception: " + str);
      this.tracker.trackException(str, true);
      this.serviceManager.dispatch();
      if (this.originalHandler != null)
      {
        Log.iDebug("Passing exception to original handler.");
        this.originalHandler.uncaughtException(paramThread, paramThrowable);
      }
      return;
    }
    if (paramThread != null) {}
    for (String str = paramThread.getName();; str = null)
    {
      str = this.exceptionParser.getDescription(str, paramThrowable);
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/analytics/tracking/android/ExceptionReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */