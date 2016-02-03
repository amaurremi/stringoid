package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

abstract class ub<N extends ou>
  extends vo<N>
{
  public ub(Class<N> paramClass)
  {
    super(paramClass);
  }
  
  protected final afd a(ow paramow, qm paramqm, aez paramaez)
    throws IOException, oz
  {
    afd localafd = paramaez.c();
    Object localObject2 = paramow.e();
    Object localObject1 = localObject2;
    if (localObject2 == pb.b) {
      localObject1 = paramow.b();
    }
    if (localObject1 == pb.f)
    {
      localObject2 = paramow.g();
      switch (uc.a[paramow.b().ordinal()])
      {
      default: 
        localObject1 = c(paramow, paramqm, paramaez);
      }
      for (;;)
      {
        ou localou = localafd.a((String)localObject2, (ou)localObject1);
        if (localou != null) {
          a((String)localObject2, localafd, localou, (ou)localObject1);
        }
        localObject1 = paramow.b();
        break;
        localObject1 = a(paramow, paramqm, paramaez);
        continue;
        localObject1 = b(paramow, paramqm, paramaez);
        continue;
        localObject1 = paramaez.a(paramow.k());
      }
    }
    return localafd;
  }
  
  public Object a(ow paramow, qm paramqm, rw paramrw)
    throws IOException, oz
  {
    return paramrw.d(paramow, paramqm);
  }
  
  protected void a(String paramString, afd paramafd, ou paramou1, ou paramou2)
    throws oz
  {}
  
  protected final aeo b(ow paramow, qm paramqm, aez paramaez)
    throws IOException, oz
  {
    aeo localaeo = paramaez.b();
    for (;;)
    {
      switch (uc.a[paramow.b().ordinal()])
      {
      default: 
        localaeo.a(c(paramow, paramqm, paramaez));
        break;
      case 1: 
        localaeo.a(a(paramow, paramqm, paramaez));
        break;
      case 2: 
        localaeo.a(b(paramow, paramqm, paramaez));
        break;
      case 3: 
        localaeo.a(paramaez.a(paramow.k()));
      }
    }
    return localaeo;
  }
  
  protected final ou c(ow paramow, qm paramqm, aez paramaez)
    throws IOException, oz
  {
    switch (uc.a[paramow.e().ordinal()])
    {
    case 4: 
    default: 
      throw paramqm.b(f());
    case 1: 
      return a(paramow, paramqm, paramaez);
    case 2: 
      return b(paramow, paramqm, paramaez);
    case 5: 
      return a(paramow, paramqm, paramaez);
    case 6: 
      paramow = paramow.z();
      if (paramow == null) {
        return paramaez.a();
      }
      if (paramow.getClass() == byte[].class) {
        return paramaez.a((byte[])paramow);
      }
      return paramaez.a(paramow);
    case 3: 
      return paramaez.a(paramow.k());
    case 7: 
      oy localoy = paramow.q();
      if ((localoy == oy.c) || (paramqm.a(ql.h))) {
        return paramaez.a(paramow.v());
      }
      if (localoy == oy.a) {
        return paramaez.a(paramow.t());
      }
      return paramaez.a(paramow.u());
    case 8: 
      if ((paramow.q() == oy.f) || (paramqm.a(ql.g))) {
        return paramaez.a(paramow.y());
      }
      return paramaez.a(paramow.x());
    case 9: 
      return paramaez.a(true);
    case 10: 
      return paramaez.a(false);
    }
    return paramaez.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */