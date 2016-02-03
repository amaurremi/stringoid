package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.lang.reflect.Constructor;

public final class sy
  extends sw
{
  protected final sw i;
  protected final Constructor<?> j;
  
  public sy(sw paramsw, Constructor<?> paramConstructor)
  {
    super(paramsw);
    this.i = paramsw;
    this.j = paramConstructor;
  }
  
  protected sy(sy paramsy, qu<Object> paramqu)
  {
    super(paramsy, paramqu);
    this.i = paramsy.i.a(paramqu);
    this.j = paramsy.j;
  }
  
  public void a(ow paramow, qm paramqm, Object paramObject)
    throws IOException, oz
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramow.e() == pb.m) {
      if (this.f == null) {
        paramow = (ow)localObject2;
      }
    }
    for (;;)
    {
      a(paramObject, paramow);
      return;
      paramow = this.f.a(paramqm);
      continue;
      if (this.e != null) {
        paramow = this.d.a(paramow, paramqm, this.e);
      }
      try
      {
        localObject2 = this.j.newInstance(new Object[] { paramObject });
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          adz.b(localException, "Failed to instantiate class " + this.j.getDeclaringClass().getName() + ", problem: " + localException.getMessage());
        }
      }
      this.d.a(paramow, paramqm, localObject1);
      paramow = (ow)localObject1;
    }
  }
  
  public final void a(Object paramObject1, Object paramObject2)
    throws IOException
  {
    this.i.a(paramObject1, paramObject2);
  }
  
  public sy b(qu<Object> paramqu)
  {
    return new sy(this, paramqu);
  }
  
  public xk b()
  {
    return this.i.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/sy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */