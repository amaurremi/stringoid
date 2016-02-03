package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

@rz
final class vn
  extends ve<String[]>
{
  public vn()
  {
    super(String[].class);
  }
  
  private final String[] c(ow paramow, qm paramqm)
    throws IOException, oz
  {
    Object localObject = null;
    if (!paramqm.a(ql.o))
    {
      if ((paramow.e() == pb.h) && (paramqm.a(ql.q)) && (paramow.k().length() == 0)) {
        return null;
      }
      throw paramqm.b(this.q);
    }
    if (paramow.e() == pb.m) {}
    for (paramow = (ow)localObject;; paramow = paramow.k()) {
      return new String[] { paramow };
    }
  }
  
  public String[] b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (!paramow.j()) {
      return c(paramow, paramqm);
    }
    aeh localaeh = paramqm.g();
    Object[] arrayOfObject = localaeh.a();
    int i = 0;
    Object localObject = paramow.b();
    if (localObject != pb.e) {
      if (localObject == pb.m)
      {
        localObject = null;
        label54:
        if (i < arrayOfObject.length) {
          break label120;
        }
        arrayOfObject = localaeh.a(arrayOfObject);
        i = 0;
      }
    }
    label120:
    for (;;)
    {
      int j = i + 1;
      arrayOfObject[i] = localObject;
      i = j;
      break;
      localObject = paramow.k();
      break label54;
      paramow = (String[])localaeh.a(arrayOfObject, i, String.class);
      paramqm.a(localaeh);
      return paramow;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/vn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */