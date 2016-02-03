package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

@rz
final class vm
  extends ve<short[]>
{
  public vm()
  {
    super(short[].class);
  }
  
  private final short[] c(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if ((paramow.e() == pb.h) && (paramqm.a(ql.q)) && (paramow.k().length() == 0)) {
      return null;
    }
    if (!paramqm.a(ql.o)) {
      throw paramqm.b(this.q);
    }
    return new short[] { s(paramow, paramqm) };
  }
  
  public short[] b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (!paramow.j()) {
      return c(paramow, paramqm);
    }
    adx localadx = paramqm.h().c();
    short[] arrayOfShort = (short[])localadx.a();
    int j = 0;
    int i;
    if (paramow.b() != pb.e)
    {
      i = s(paramow, paramqm);
      if (j < arrayOfShort.length) {
        break label110;
      }
      arrayOfShort = (short[])localadx.a(arrayOfShort, j);
      j = 0;
    }
    label110:
    for (;;)
    {
      int k = j + 1;
      arrayOfShort[j] = i;
      j = k;
      break;
      return (short[])localadx.b(arrayOfShort, j);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/vm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */