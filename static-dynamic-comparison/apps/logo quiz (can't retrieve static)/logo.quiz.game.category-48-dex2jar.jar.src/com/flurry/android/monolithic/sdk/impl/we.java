package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public abstract class we
  extends rc
{
  protected final Class<?> a;
  
  protected we(Class<?> paramClass)
  {
    this.a = paramClass;
  }
  
  protected int a(String paramString)
    throws IllegalArgumentException
  {
    return Integer.parseInt(paramString);
  }
  
  public Class<?> a()
  {
    return this.a;
  }
  
  public final Object a(String paramString, qm paramqm)
    throws IOException, oz
  {
    Object localObject1;
    if (paramString == null) {
      localObject1 = null;
    }
    for (;;)
    {
      return localObject1;
      try
      {
        Object localObject2 = b(paramString, paramqm);
        localObject1 = localObject2;
        if (localObject2 != null) {
          continue;
        }
        throw paramqm.a(this.a, paramString, "not a valid representation");
      }
      catch (Exception localException)
      {
        throw paramqm.a(this.a, paramString, "not a valid representation: " + localException.getMessage());
      }
    }
  }
  
  protected long b(String paramString)
    throws IllegalArgumentException
  {
    return Long.parseLong(paramString);
  }
  
  protected abstract Object b(String paramString, qm paramqm)
    throws Exception;
  
  protected double c(String paramString)
    throws IllegalArgumentException
  {
    return pt.c(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/we.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */