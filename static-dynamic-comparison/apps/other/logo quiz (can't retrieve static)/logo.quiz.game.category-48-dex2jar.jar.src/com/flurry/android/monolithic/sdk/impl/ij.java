package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.os.Build.VERSION;

public final class ij
  implements ik
{
  private static ij a;
  private final ik b = b();
  
  public static ij a()
  {
    try
    {
      if (a == null) {
        a = new ij();
      }
      ij localij = a;
      return localij;
    }
    finally {}
  }
  
  private static ik b()
  {
    ik localik = null;
    if (c()) {
      localik = ii.a();
    }
    return localik;
  }
  
  private static boolean c()
  {
    return Build.VERSION.SDK_INT >= 8;
  }
  
  public void a(Context paramContext)
  {
    if (this.b != null) {
      this.b.a(paramContext);
    }
  }
  
  public void b(Context paramContext)
  {
    if (this.b != null) {
      this.b.b(paramContext);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ij.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */