package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

@rz
public class abf
  extends abq<Enum<?>>
{
  protected final aee a;
  
  public abf(aee paramaee)
  {
    super(Enum.class, false);
    this.a = paramaee;
  }
  
  public static abf a(Class<Enum<?>> paramClass, rq paramrq, xq paramxq)
  {
    paramxq = paramrq.a();
    if (paramrq.a(rr.t)) {}
    for (paramClass = aee.c(paramClass, paramxq);; paramClass = aee.b(paramClass, paramxq)) {
      return new abf(paramClass);
    }
  }
  
  public final void a(Enum<?> paramEnum, or paramor, ru paramru)
    throws IOException, oq
  {
    if (paramru.a(rr.u))
    {
      paramor.b(paramEnum.ordinal());
      return;
    }
    paramor.b(this.a.a(paramEnum));
  }
  
  public aee d()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/abf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */