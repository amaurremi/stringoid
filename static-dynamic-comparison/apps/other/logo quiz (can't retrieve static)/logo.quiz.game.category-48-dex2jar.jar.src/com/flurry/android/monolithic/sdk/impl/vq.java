package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.math.BigDecimal;

@rz
public class vq
  extends wv<BigDecimal>
{
  public vq()
  {
    super(BigDecimal.class);
  }
  
  public BigDecimal b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    pb localpb = paramow.e();
    if ((localpb == pb.i) || (localpb == pb.j)) {
      return paramow.y();
    }
    if (localpb == pb.h)
    {
      paramow = paramow.k().trim();
      if (paramow.length() == 0) {
        return null;
      }
      try
      {
        paramow = new BigDecimal(paramow);
        return paramow;
      }
      catch (IllegalArgumentException paramow)
      {
        throw paramqm.b(this.q, "not a valid representation");
      }
    }
    throw paramqm.a(this.q, localpb);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/vq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */