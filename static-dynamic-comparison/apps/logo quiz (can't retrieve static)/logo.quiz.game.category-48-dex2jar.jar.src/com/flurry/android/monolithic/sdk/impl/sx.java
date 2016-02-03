package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.lang.reflect.Field;

public final class sx
  extends sw
{
  protected final xj i;
  protected final Field j;
  
  protected sx(sx paramsx, qu<Object> paramqu)
  {
    super(paramsx, paramqu);
    this.i = paramsx.i;
    this.j = paramsx.j;
  }
  
  public sx(String paramString, afm paramafm, rw paramrw, ado paramado, xj paramxj)
  {
    super(paramString, paramafm, paramrw, paramado);
    this.i = paramxj;
    this.j = paramxj.e();
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
      this.j.set(paramObject1, paramObject2);
      return;
    }
    catch (Exception paramObject1)
    {
      a((Exception)paramObject1, paramObject2);
    }
  }
  
  public sx b(qu<Object> paramqu)
  {
    return new sx(this, paramqu);
  }
  
  public xk b()
  {
    return this.i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/sx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */