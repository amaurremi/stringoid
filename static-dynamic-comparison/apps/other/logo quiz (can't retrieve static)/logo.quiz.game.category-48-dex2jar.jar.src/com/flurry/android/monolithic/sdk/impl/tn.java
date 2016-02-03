package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public class tn
  extends sw
{
  protected final xn i;
  protected final Object j;
  
  protected tn(tn paramtn, qu<Object> paramqu)
  {
    super(paramtn, paramqu);
    this.i = paramtn.i;
    this.j = paramtn.j;
  }
  
  public tn(String paramString, afm paramafm, rw paramrw, ado paramado, xn paramxn, int paramInt, Object paramObject)
  {
    super(paramString, paramafm, paramrw, paramado);
    this.i = paramxn;
    this.h = paramInt;
    this.j = paramObject;
  }
  
  public void a(ow paramow, qm paramqm, Object paramObject)
    throws IOException, oz
  {
    a(paramObject, a(paramow, paramqm));
  }
  
  public void a(Object paramObject1, Object paramObject2)
    throws IOException
  {}
  
  public tn b(qu<Object> paramqu)
  {
    return new tn(this, paramqu);
  }
  
  public xk b()
  {
    return this.i;
  }
  
  public Object k()
  {
    return this.j;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/tn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */