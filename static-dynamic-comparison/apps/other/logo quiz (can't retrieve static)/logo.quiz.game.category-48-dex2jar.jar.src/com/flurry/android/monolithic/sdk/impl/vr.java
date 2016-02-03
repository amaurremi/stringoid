package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

@rz
public class vr
  extends wv<BigInteger>
{
  public vr()
  {
    super(BigInteger.class);
  }
  
  public BigInteger b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    pb localpb = paramow.e();
    if (localpb == pb.i) {
      switch (vp.b[paramow.q().ordinal()])
      {
      }
    }
    do
    {
      paramow = paramow.k().trim();
      if (paramow.length() != 0) {
        break;
      }
      return null;
      return BigInteger.valueOf(paramow.u());
      if (localpb == pb.j) {
        return paramow.y().toBigInteger();
      }
    } while (localpb == pb.h);
    throw paramqm.a(this.q, localpb);
    try
    {
      paramow = new BigInteger(paramow);
      return paramow;
    }
    catch (IllegalArgumentException paramow)
    {
      throw paramqm.b(this.q, "not a valid representation");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/vr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */