package com.flurry.android;

abstract class bk
  implements Runnable
{
  public abstract void a();
  
  public final void run()
  {
    try
    {
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      db.b("FlurryAgent", "", localThrowable);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */