package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.os.Build.VERSION;

public final class ig
  implements ih
{
  private static ig a;
  private final ih b = b();
  
  public static ig a()
  {
    try
    {
      if (a == null) {
        a = new ig();
      }
      ig localig = a;
      return localig;
    }
    finally {}
  }
  
  private static ih b()
  {
    ih localih = null;
    if (c()) {
      localih = if.a();
    }
    return localih;
  }
  
  private static boolean c()
  {
    return Build.VERSION.SDK_INT >= 8;
  }
  
  public void f(Context paramContext)
  {
    if (this.b != null) {
      this.b.f(paramContext);
    }
  }
  
  public void g(Context paramContext)
  {
    if (this.b != null) {
      this.b.g(paramContext);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */