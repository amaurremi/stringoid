package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

@rz
final class vk
  extends ve<int[]>
{
  public vk()
  {
    super(int[].class);
  }
  
  private final int[] c(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if ((paramow.e() == pb.h) && (paramqm.a(ql.q)) && (paramow.k().length() == 0)) {
      return null;
    }
    if (!paramqm.a(ql.o)) {
      throw paramqm.b(this.q);
    }
    return new int[] { t(paramow, paramqm) };
  }
  
  public int[] b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (!paramow.j()) {
      return c(paramow, paramqm);
    }
    adv localadv = paramqm.h().d();
    int[] arrayOfInt = (int[])localadv.a();
    int i = 0;
    int k;
    if (paramow.b() != pb.e)
    {
      k = t(paramow, paramqm);
      if (i < arrayOfInt.length) {
        break label104;
      }
      arrayOfInt = (int[])localadv.a(arrayOfInt, i);
      i = 0;
    }
    label104:
    for (;;)
    {
      int j = i + 1;
      arrayOfInt[i] = k;
      i = j;
      break;
      return (int[])localadv.b(arrayOfInt, i);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/vk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */