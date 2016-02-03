package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public class uw
  extends wv<afm>
{
  public uw()
  {
    super(afm.class);
  }
  
  public afm b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    pb localpb = paramow.e();
    if (localpb == pb.h)
    {
      paramow = paramow.k().trim();
      if (paramow.length() == 0) {
        return (afm)c();
      }
      return paramqm.f().b(paramow);
    }
    if (localpb == pb.g) {
      return (afm)paramow.z();
    }
    throw paramqm.b(this.q);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/uw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */