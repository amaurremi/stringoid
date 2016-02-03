package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

@rz
public final class aaf
  extends abq<Number>
{
  public static final aaf a = new aaf();
  
  public aaf()
  {
    super(Number.class);
  }
  
  public void a(Number paramNumber, or paramor, ru paramru)
    throws IOException, oq
  {
    if ((paramNumber instanceof BigDecimal))
    {
      paramor.a((BigDecimal)paramNumber);
      return;
    }
    if ((paramNumber instanceof BigInteger))
    {
      paramor.a((BigInteger)paramNumber);
      return;
    }
    if ((paramNumber instanceof Integer))
    {
      paramor.b(paramNumber.intValue());
      return;
    }
    if ((paramNumber instanceof Long))
    {
      paramor.a(paramNumber.longValue());
      return;
    }
    if ((paramNumber instanceof Double))
    {
      paramor.a(paramNumber.doubleValue());
      return;
    }
    if ((paramNumber instanceof Float))
    {
      paramor.a(paramNumber.floatValue());
      return;
    }
    if (((paramNumber instanceof Byte)) || ((paramNumber instanceof Short)))
    {
      paramor.b(paramNumber.intValue());
      return;
    }
    paramor.e(paramNumber.toString());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */