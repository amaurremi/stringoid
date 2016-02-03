package com.google.android.gms.internal;

import android.os.Handler;

public class y$a
{
  private final Handler mHandler;
  
  public y$a(Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }
  
  public boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    return this.mHandler.postDelayed(paramRunnable, paramLong);
  }
  
  public void removeCallbacks(Runnable paramRunnable)
  {
    this.mHandler.removeCallbacks(paramRunnable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/y$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */