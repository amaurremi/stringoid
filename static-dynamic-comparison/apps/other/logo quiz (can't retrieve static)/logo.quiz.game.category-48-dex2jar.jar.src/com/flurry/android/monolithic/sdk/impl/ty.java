package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public class ty
  extends qd
{
  protected final Object e;
  
  public ty(String paramString, afm paramafm, ado paramado, xk paramxk, Object paramObject)
  {
    super(paramString, paramafm, paramado, paramxk);
    this.e = paramObject;
  }
  
  public Object a(qm paramqm, Object paramObject)
  {
    return paramqm.a(this.e, this, paramObject);
  }
  
  public void b(qm paramqm, Object paramObject)
    throws IOException
  {
    this.c.a(paramObject, a(paramqm, paramObject));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */