package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.math.BigDecimal;

public final class aew
  extends afc
{
  protected final BigDecimal c;
  
  public aew(BigDecimal paramBigDecimal)
  {
    this.c = paramBigDecimal;
  }
  
  public static aew a(BigDecimal paramBigDecimal)
  {
    return new aew(paramBigDecimal);
  }
  
  public final void a(or paramor, ru paramru)
    throws IOException, oz
  {
    paramor.a(this.c);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (paramObject.getClass() != getClass());
    return ((aew)paramObject).c.equals(this.c);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */