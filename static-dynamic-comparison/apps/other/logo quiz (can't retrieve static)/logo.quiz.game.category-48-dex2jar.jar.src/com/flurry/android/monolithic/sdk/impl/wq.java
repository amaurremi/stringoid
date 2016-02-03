package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.Constructor;

final class wq
  extends we
{
  protected final Constructor<?> b;
  
  public wq(Constructor<?> paramConstructor)
  {
    super(paramConstructor.getDeclaringClass());
    this.b = paramConstructor;
  }
  
  public Object b(String paramString, qm paramqm)
    throws Exception
  {
    return this.b.newInstance(new Object[] { paramString });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/wq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */