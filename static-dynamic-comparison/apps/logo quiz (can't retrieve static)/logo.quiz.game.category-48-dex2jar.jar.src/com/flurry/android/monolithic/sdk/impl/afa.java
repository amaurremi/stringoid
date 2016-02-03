package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public final class afa
  extends afc
{
  final long c;
  
  public afa(long paramLong)
  {
    this.c = paramLong;
  }
  
  public static afa a(long paramLong)
  {
    return new afa(paramLong);
  }
  
  public final void a(or paramor, ru paramru)
    throws IOException, oz
  {
    paramor.a(this.c);
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
    } while (((afa)paramObject).c == this.c);
    return false;
  }
  
  public int hashCode()
  {
    return (int)this.c ^ (int)(this.c >> 32);
  }
  
  public int j()
  {
    return (int)this.c;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/afa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */