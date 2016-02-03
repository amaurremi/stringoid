package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.math.BigInteger;

public final class aeq
  extends afc
{
  protected final BigInteger c;
  
  public aeq(BigInteger paramBigInteger)
  {
    this.c = paramBigInteger;
  }
  
  public static aeq a(BigInteger paramBigInteger)
  {
    return new aeq(paramBigInteger);
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
    } while (((aeq)paramObject).c == this.c);
    return false;
  }
  
  public int hashCode()
  {
    return this.c.hashCode();
  }
  
  public int j()
  {
    return this.c.intValue();
  }
  
  public long k()
  {
    return this.c.longValue();
  }
  
  public double l()
  {
    return this.c.doubleValue();
  }
  
  public String m()
  {
    return this.c.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aeq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */