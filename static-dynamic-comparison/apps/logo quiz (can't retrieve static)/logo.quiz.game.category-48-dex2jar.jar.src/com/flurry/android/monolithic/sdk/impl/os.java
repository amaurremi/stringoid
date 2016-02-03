package com.flurry.android.monolithic.sdk.impl;

public enum os
{
  final boolean h;
  final int i;
  
  private os(boolean paramBoolean)
  {
    this.h = paramBoolean;
    this.i = (1 << ordinal());
  }
  
  public static int a()
  {
    int m = 0;
    os[] arrayOfos = values();
    int i1 = arrayOfos.length;
    int k = 0;
    while (k < i1)
    {
      os localos = arrayOfos[k];
      int n = m;
      if (localos.b()) {
        n = m | localos.c();
      }
      k += 1;
      m = n;
    }
    return m;
  }
  
  public boolean b()
  {
    return this.h;
  }
  
  public int c()
  {
    return this.i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/os.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */