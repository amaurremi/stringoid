package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

@rz
final class vl
  extends ve<long[]>
{
  public vl()
  {
    super(long[].class);
  }
  
  private final long[] c(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if ((paramow.e() == pb.h) && (paramqm.a(ql.q)) && (paramow.k().length() == 0)) {
      return null;
    }
    if (!paramqm.a(ql.o)) {
      throw paramqm.b(this.q);
    }
    return new long[] { w(paramow, paramqm) };
  }
  
  public long[] b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (!paramow.j()) {
      return c(paramow, paramqm);
    }
    adw localadw = paramqm.h().e();
    long[] arrayOfLong = (long[])localadw.a();
    int i = 0;
    long l;
    if (paramow.b() != pb.e)
    {
      l = w(paramow, paramqm);
      if (i < arrayOfLong.length) {
        break label104;
      }
      arrayOfLong = (long[])localadw.a(arrayOfLong, i);
      i = 0;
    }
    label104:
    for (;;)
    {
      int j = i + 1;
      arrayOfLong[i] = l;
      i = j;
      break;
      return (long[])localadw.b(arrayOfLong, i);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/vl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */