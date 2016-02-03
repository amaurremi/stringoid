package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

final class va
  extends ub<afd>
{
  protected static final va a = new va();
  
  protected va()
  {
    super(afd.class);
  }
  
  public static va d()
  {
    return a;
  }
  
  public afd b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (paramow.e() == pb.b)
    {
      paramow.b();
      return a(paramow, paramqm, paramqm.e());
    }
    if (paramow.e() == pb.f) {
      return a(paramow, paramqm, paramqm.e());
    }
    throw paramqm.b(afd.class);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/va.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */