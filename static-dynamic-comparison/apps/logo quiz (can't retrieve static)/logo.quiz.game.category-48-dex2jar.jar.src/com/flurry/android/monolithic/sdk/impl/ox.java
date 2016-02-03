package com.flurry.android.monolithic.sdk.impl;

public enum ox
{
  final boolean k;
  
  private ox(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public static int a()
  {
    int n = 0;
    ox[] arrayOfox = values();
    int i2 = arrayOfox.length;
    int m = 0;
    while (m < i2)
    {
      ox localox = arrayOfox[m];
      int i1 = n;
      if (localox.b()) {
        i1 = n | localox.c();
      }
      m += 1;
      n = i1;
    }
    return n;
  }
  
  public boolean b()
  {
    return this.k;
  }
  
  public int c()
  {
    return 1 << ordinal();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */