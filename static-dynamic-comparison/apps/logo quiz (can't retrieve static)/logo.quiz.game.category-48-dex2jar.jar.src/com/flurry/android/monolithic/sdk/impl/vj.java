package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

@rz
final class vj
  extends ve<float[]>
{
  public vj()
  {
    super(float[].class);
  }
  
  private final float[] c(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if ((paramow.e() == pb.h) && (paramqm.a(ql.q)) && (paramow.k().length() == 0)) {
      return null;
    }
    if (!paramqm.a(ql.o)) {
      throw paramqm.b(this.q);
    }
    return new float[] { y(paramow, paramqm) };
  }
  
  public float[] b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (!paramow.j()) {
      return c(paramow, paramqm);
    }
    adu localadu = paramqm.h().f();
    float[] arrayOfFloat = (float[])localadu.a();
    int i = 0;
    float f;
    if (paramow.b() != pb.e)
    {
      f = y(paramow, paramqm);
      if (i < arrayOfFloat.length) {
        break label110;
      }
      arrayOfFloat = (float[])localadu.a(arrayOfFloat, i);
      i = 0;
    }
    label110:
    for (;;)
    {
      int j = i + 1;
      arrayOfFloat[i] = f;
      i = j;
      break;
      return (float[])localadu.b(arrayOfFloat, i);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/vj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */