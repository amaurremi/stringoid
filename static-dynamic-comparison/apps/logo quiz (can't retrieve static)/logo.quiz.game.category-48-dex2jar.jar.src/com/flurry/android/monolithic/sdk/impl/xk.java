package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.Member;

public abstract class xk
  extends xg
{
  protected final xp b;
  
  protected xk(xp paramxp)
  {
    this.b = paramxp;
  }
  
  public abstract void a(Object paramObject1, Object paramObject2)
    throws UnsupportedOperationException, IllegalArgumentException;
  
  public abstract Class<?> h();
  
  public abstract Member i();
  
  protected xp j()
  {
    return this.b;
  }
  
  public final void k()
  {
    adz.a(i());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/xk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */