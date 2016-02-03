package com.flurry.android.monolithic.sdk.impl;

import java.io.OutputStream;

public class md
{
  private static final md c = new mf(null);
  protected int a = 2048;
  protected int b = 65536;
  
  public static md a()
  {
    return c;
  }
  
  public lr a(OutputStream paramOutputStream, lr paramlr)
  {
    if ((paramlr == null) || (!paramlr.getClass().equals(ls.class))) {
      return new ls(paramOutputStream, this.a);
    }
    return ((ls)paramlr).a(paramOutputStream, this.a);
  }
  
  public md a(int paramInt)
  {
    int i = 16777216;
    int j = 32;
    if (paramInt < 32) {
      paramInt = j;
    }
    for (;;)
    {
      if (paramInt > 16777216) {
        paramInt = i;
      }
      for (;;)
      {
        this.a = paramInt;
        return this;
      }
    }
  }
  
  public lr b(OutputStream paramOutputStream, lr paramlr)
  {
    if ((paramlr == null) || (!paramlr.getClass().equals(mb.class))) {
      return new mb(paramOutputStream);
    }
    return ((mb)paramlr).a(paramOutputStream);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/md.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */