package com.greystripe.sdk;

import android.os.Handler;

final class bm
{
  private static Handler a = null;
  
  public static void a()
  {
    if (a == null)
    {
      if (Thread.currentThread().getId() != 1L) {
        bd.e("Initializing UiThreadHandler from a non-UI Thread!", new Object[0]);
      }
      a = new Handler();
    }
  }
  
  public static boolean a(Runnable paramRunnable)
  {
    return a.post(paramRunnable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */