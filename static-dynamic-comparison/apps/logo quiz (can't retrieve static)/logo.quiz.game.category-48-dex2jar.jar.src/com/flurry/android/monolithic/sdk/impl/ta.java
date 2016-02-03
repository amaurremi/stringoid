package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.lang.reflect.Method;

public final class ta
  extends sw
{
  protected final xl i;
  protected final Method j;
  
  protected ta(ta paramta, qu<Object> paramqu)
  {
    super(paramta, paramqu);
    this.i = paramta.i;
    this.j = paramta.j;
  }
  
  public ta(String paramString, afm paramafm, rw paramrw, ado paramado, xl paramxl)
  {
    super(paramString, paramafm, paramrw, paramado);
    this.i = paramxl;
    this.j = paramxl.e();
  }
  
  public void a(ow paramow, qm paramqm, Object paramObject)
    throws IOException, oz
  {
    a(paramObject, a(paramow, paramqm));
  }
  
  public final void a(Object paramObject1, Object paramObject2)
    throws IOException
  {
    try
    {
      this.j.invoke(paramObject1, new Object[] { paramObject2 });
      return;
    }
    catch (Exception paramObject1)
    {
      a((Exception)paramObject1, paramObject2);
    }
  }
  
  public ta b(qu<Object> paramqu)
  {
    return new ta(this, paramqu);
  }
  
  public xk b()
  {
    return this.i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */