package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

@rz
final class vf
  extends ve<boolean[]>
{
  public vf()
  {
    super(boolean[].class);
  }
  
  private final boolean[] c(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if ((paramow.e() == pb.h) && (paramqm.a(ql.q)) && (paramow.k().length() == 0)) {
      return null;
    }
    if (!paramqm.a(ql.o)) {
      throw paramqm.b(this.q);
    }
    return new boolean[] { n(paramow, paramqm) };
  }
  
  public boolean[] b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (!paramow.j()) {
      return c(paramow, paramqm);
    }
    adr localadr = paramqm.h().a();
    boolean[] arrayOfBoolean = (boolean[])localadr.a();
    int i = 0;
    boolean bool;
    if (paramow.b() != pb.e)
    {
      bool = n(paramow, paramqm);
      if (i < arrayOfBoolean.length) {
        break label104;
      }
      arrayOfBoolean = (boolean[])localadr.a(arrayOfBoolean, i);
      i = 0;
    }
    label104:
    for (;;)
    {
      int j = i + 1;
      arrayOfBoolean[i] = bool;
      i = j;
      break;
      return (boolean[])localadr.b(arrayOfBoolean, i);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/vf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */