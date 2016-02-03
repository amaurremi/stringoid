package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public class ux
  extends ub<ou>
{
  private static final ux a = new ux();
  
  protected ux()
  {
    super(ou.class);
  }
  
  public static qu<? extends ou> a(Class<?> paramClass)
  {
    if (paramClass == afd.class) {
      return va.d();
    }
    if (paramClass == aeo.class) {
      return uz.d();
    }
    return a;
  }
  
  public ou b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    switch (uy.a[paramow.e().ordinal()])
    {
    default: 
      return c(paramow, paramqm, paramqm.e());
    case 1: 
      return a(paramow, paramqm, paramqm.e());
    }
    return b(paramow, paramqm, paramqm.e());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ux.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */