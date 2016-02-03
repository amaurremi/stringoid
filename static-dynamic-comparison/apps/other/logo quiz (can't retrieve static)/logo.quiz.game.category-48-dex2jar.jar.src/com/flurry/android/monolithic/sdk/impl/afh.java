package com.flurry.android.monolithic.sdk.impl;

public final class afh
{
  final afh a = null;
  final boolean b;
  private int c;
  private int d;
  private int[] e;
  private afl[] f;
  private afi[] g;
  private int h;
  private transient boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  
  private afh(int paramInt, boolean paramBoolean)
  {
    this.b = paramBoolean;
    int m;
    if (paramInt < 16) {
      m = 16;
    }
    for (;;)
    {
      a(m);
      return;
      m = paramInt;
      if ((paramInt - 1 & paramInt) != 0)
      {
        m = n;
        while (m < paramInt) {
          m += m;
        }
      }
    }
  }
  
  public static afh a()
  {
    return new afh(64, true);
  }
  
  private void a(int paramInt)
  {
    this.c = 0;
    this.e = new int[paramInt];
    this.f = new afl[paramInt];
    this.j = false;
    this.k = false;
    this.d = (paramInt - 1);
    this.l = true;
    this.g = null;
    this.h = 0;
    this.i = false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/afh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */