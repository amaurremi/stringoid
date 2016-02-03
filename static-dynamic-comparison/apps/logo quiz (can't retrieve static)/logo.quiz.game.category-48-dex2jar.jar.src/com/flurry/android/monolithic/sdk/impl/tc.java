package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.lang.reflect.Method;

public final class tc
  extends sw
{
  protected final xl i;
  protected final Method j;
  
  protected tc(tc paramtc, qu<Object> paramqu)
  {
    super(paramtc, paramqu);
    this.i = paramtc.i;
    this.j = paramtc.j;
  }
  
  public tc(String paramString, afm paramafm, rw paramrw, ado paramado, xl paramxl)
  {
    super(paramString, paramafm, paramrw, paramado);
    this.i = paramxl;
    this.j = paramxl.e();
  }
  
  public final void a(ow paramow, qm paramqm, Object paramObject)
    throws IOException, oz
  {
    if (paramow.e() == pb.m) {
      return;
    }
    try
    {
      paramObject = this.j.invoke(paramObject, new Object[0]);
      if (paramObject == null) {
        throw new qw("Problem deserializing 'setterless' property '" + c() + "': get method returned null");
      }
    }
    catch (Exception paramow)
    {
      a(paramow);
      return;
    }
    this.d.a(paramow, paramqm, paramObject);
  }
  
  public final void a(Object paramObject1, Object paramObject2)
    throws IOException
  {
    throw new UnsupportedOperationException("Should never call 'set' on setterless property");
  }
  
  public tc b(qu<Object> paramqu)
  {
    return new tc(this, paramqu);
  }
  
  public xk b()
  {
    return this.i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/tc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */