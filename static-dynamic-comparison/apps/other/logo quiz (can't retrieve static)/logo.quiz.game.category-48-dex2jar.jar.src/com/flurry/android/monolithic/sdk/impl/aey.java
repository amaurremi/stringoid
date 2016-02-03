package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public final class aey
  extends afc
{
  private static final aey[] d = new aey[12];
  final int c;
  
  static
  {
    int i = 0;
    while (i < 12)
    {
      d[i] = new aey(i - 1);
      i += 1;
    }
  }
  
  public aey(int paramInt)
  {
    this.c = paramInt;
  }
  
  public static aey a(int paramInt)
  {
    if ((paramInt > 10) || (paramInt < -1)) {
      return new aey(paramInt);
    }
    return d[(paramInt + 1)];
  }
  
  public final void a(or paramor, ru paramru)
    throws IOException, oz
  {
    paramor.b(this.c);
  }
  
  public boolean d()
  {
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (paramObject.getClass() != getClass()) {
        return false;
      }
    } while (((aey)paramObject).c == this.c);
    return false;
  }
  
  public int hashCode()
  {
    return this.c;
  }
  
  public int j()
  {
    return this.c;
  }
  
  public long k()
  {
    return this.c;
  }
  
  public double l()
  {
    return this.c;
  }
  
  public String m()
  {
    return pu.a(this.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */