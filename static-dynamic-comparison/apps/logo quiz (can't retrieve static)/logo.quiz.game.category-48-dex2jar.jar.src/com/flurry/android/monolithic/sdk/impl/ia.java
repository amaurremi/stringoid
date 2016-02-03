package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;

public class ia
{
  private static ia a;
  private final Context b;
  private final Handler c;
  
  private ia(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.c = new Handler(Looper.getMainLooper());
  }
  
  public static ia a()
  {
    return a;
  }
  
  public static void a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        ia localia = a;
        if (localia != null) {
          return;
        }
        if (paramContext == null) {
          throw new IllegalArgumentException("Context cannot be null");
        }
      }
      finally {}
      a = new ia(paramContext);
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    this.c.post(paramRunnable);
  }
  
  public Context b()
  {
    return this.b;
  }
  
  public PackageManager c()
  {
    return this.b.getPackageManager();
  }
  
  public DisplayMetrics d()
  {
    return this.b.getResources().getDisplayMetrics();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */