package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

@rz
public final class vz
  extends wv<Number>
{
  public vz()
  {
    super(Number.class);
  }
  
  public Object a(ow paramow, qm paramqm, rw paramrw)
    throws IOException, oz
  {
    switch (vp.a[paramow.e().ordinal()])
    {
    default: 
      return paramrw.c(paramow, paramqm);
    }
    return b(paramow, paramqm);
  }
  
  public Number b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    pb localpb = paramow.e();
    if (localpb == pb.i)
    {
      if (paramqm.a(ql.h)) {
        return paramow.v();
      }
      return paramow.p();
    }
    if (localpb == pb.j)
    {
      if (paramqm.a(ql.g)) {
        return paramow.y();
      }
      return Double.valueOf(paramow.x());
    }
    if (localpb == pb.h)
    {
      paramow = paramow.k().trim();
      try
      {
        if (paramow.indexOf('.') < 0) {
          break label132;
        }
        if (paramqm.a(ql.g))
        {
          paramow = new BigDecimal(paramow);
          return paramow;
        }
      }
      catch (IllegalArgumentException paramow)
      {
        throw paramqm.b(this.q, "not a valid number");
      }
      return new Double(paramow);
      label132:
      if (paramqm.a(ql.h)) {
        return new BigInteger(paramow);
      }
      long l = Long.parseLong(paramow);
      if ((l <= 2147483647L) && (l >= -2147483648L)) {
        return Integer.valueOf((int)l);
      }
      return Long.valueOf(l);
    }
    throw paramqm.a(this.q, localpb);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/vz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */