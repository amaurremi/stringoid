package com.flurry.android;

public class FlurryAgent$FlurryDefaultExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  private Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      FlurryAgent.f().a(paramThrowable);
      if (this.a != null) {
        this.a.uncaughtException(paramThread, paramThrowable);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ah.b("FlurryAgent", "", localThrowable);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/FlurryAgent$FlurryDefaultExceptionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */