package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

@rz
final class vi
  extends ve<double[]>
{
  public vi()
  {
    super(double[].class);
  }
  
  private final double[] c(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if ((paramow.e() == pb.h) && (paramqm.a(ql.q)) && (paramow.k().length() == 0)) {
      return null;
    }
    if (!paramqm.a(ql.o)) {
      throw paramqm.b(this.q);
    }
    return new double[] { A(paramow, paramqm) };
  }
  
  public double[] b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (!paramow.j()) {
      return c(paramow, paramqm);
    }
    adt localadt = paramqm.h().g();
    double[] arrayOfDouble = (double[])localadt.a();
    int i = 0;
    double d;
    if (paramow.b() != pb.e)
    {
      d = A(paramow, paramqm);
      if (i < arrayOfDouble.length) {
        break label110;
      }
      arrayOfDouble = (double[])localadt.a(arrayOfDouble, i);
      i = 0;
    }
    label110:
    for (;;)
    {
      int j = i + 1;
      arrayOfDouble[i] = d;
      i = j;
      break;
      return (double[])localadt.b(arrayOfDouble, i);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/vi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */