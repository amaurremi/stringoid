package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.Method;

final class wr
  extends we
{
  final Method b;
  
  public wr(Method paramMethod)
  {
    super(paramMethod.getDeclaringClass());
    this.b = paramMethod;
  }
  
  public Object b(String paramString, qm paramqm)
    throws Exception
  {
    return this.b.invoke(null, new Object[] { paramString });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/wr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */