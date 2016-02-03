package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.lang.reflect.Method;

public class uj
  extends wv<Object>
{
  protected final Class<?> a;
  protected final Method b;
  
  public uj(Class<?> paramClass, xl paramxl)
  {
    super(Enum.class);
    this.a = paramClass;
    this.b = paramxl.e();
  }
  
  public Object a(ow paramow, qm paramqm)
    throws IOException, oz
  {
    pb localpb = paramow.e();
    if ((localpb != pb.h) && (localpb != pb.f)) {
      throw paramqm.b(this.a);
    }
    paramow = paramow.k();
    try
    {
      paramow = this.b.invoke(this.a, new Object[] { paramow });
      return paramow;
    }
    catch (Exception paramow)
    {
      adz.c(paramow);
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/uj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */