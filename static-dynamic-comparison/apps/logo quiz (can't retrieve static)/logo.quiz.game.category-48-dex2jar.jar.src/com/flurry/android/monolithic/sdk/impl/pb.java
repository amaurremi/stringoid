package com.flurry.android.monolithic.sdk.impl;

public enum pb
{
  final String n;
  final char[] o;
  final byte[] p;
  
  private pb(String paramString)
  {
    if (paramString == null)
    {
      this.n = null;
      this.o = null;
      this.p = null;
    }
    for (;;)
    {
      return;
      this.n = paramString;
      this.o = paramString.toCharArray();
      int i2 = this.o.length;
      this.p = new byte[i2];
      i1 = 0;
      while (i1 < i2)
      {
        this.p[i1] = ((byte)this.o[i1]);
        i1 += 1;
      }
    }
  }
  
  public String a()
  {
    return this.n;
  }
  
  public char[] b()
  {
    return this.o;
  }
  
  public boolean c()
  {
    return (this == i) || (this == j);
  }
  
  public boolean d()
  {
    return ordinal() >= g.ordinal();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/pb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */