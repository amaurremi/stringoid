package com.flurry.android;

public class FlurryAgent$FlurryDefaultExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  private Thread.UncaughtExceptionHandler bH = Thread.getDefaultUncaughtExceptionHandler();
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      FlurryAgent.az.a(paramThrowable);
      if (this.bH != null) {
        this.bH.uncaughtException(paramThread, paramThrowable);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        db.b("FlurryAgent", "", localThrowable);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/FlurryAgent$FlurryDefaultExceptionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */