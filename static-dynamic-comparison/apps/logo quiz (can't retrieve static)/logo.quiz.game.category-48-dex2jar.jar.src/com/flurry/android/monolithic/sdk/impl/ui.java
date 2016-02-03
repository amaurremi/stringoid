package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

@sa
public class ui
  extends wv<Enum<?>>
{
  protected final aed<?> a;
  
  public ui(aed<?> paramaed)
  {
    super(Enum.class);
    this.a = paramaed;
  }
  
  public static qu<?> a(qk paramqk, Class<?> paramClass, xl paramxl)
  {
    if (paramxl.b(0) != String.class) {
      throw new IllegalArgumentException("Parameter #0 type for factory method (" + paramxl + ") not suitable, must be java.lang.String");
    }
    if (paramqk.a(ql.f)) {
      adz.a(paramxl.i());
    }
    return new uj(paramClass, paramxl);
  }
  
  public Enum<?> b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    Object localObject = paramow.e();
    if ((localObject == pb.h) || (localObject == pb.f))
    {
      paramow = paramow.k();
      localObject = this.a.a(paramow);
      paramow = (ow)localObject;
      if (localObject == null) {
        throw paramqm.b(this.a.a(), "value not one of declared Enum instance names");
      }
    }
    else if (localObject == pb.i)
    {
      if (paramqm.a(ql.m)) {
        throw paramqm.b("Not allowed to deserialize Enum value out of JSON number (disable DeserializationConfig.Feature.FAIL_ON_NUMBERS_FOR_ENUMS to allow)");
      }
      int i = paramow.t();
      localObject = this.a.a(i);
      paramow = (ow)localObject;
      if (localObject == null) {
        throw paramqm.c(this.a.a(), "index value outside legal index range [0.." + this.a.b() + "]");
      }
    }
    else
    {
      throw paramqm.b(this.a.a());
    }
    return paramow;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */