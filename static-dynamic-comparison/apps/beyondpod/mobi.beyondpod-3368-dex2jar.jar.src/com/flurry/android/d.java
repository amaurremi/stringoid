package com.flurry.android;

final class d
  implements Thread.UncaughtExceptionHandler
{
  private Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      FlurryAgent.b().a(paramThrowable);
      if (this.a != null) {
        this.a.uncaughtException(paramThread, paramThrowable);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Flog.b("FlurryAgent", "", localThrowable);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/flurry/android/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */