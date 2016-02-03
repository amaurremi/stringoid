package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public class zg
  extends aaz
{
  public zg(afm paramafm, zf[] paramArrayOfzf1, zf[] paramArrayOfzf2, zc paramzc, Object paramObject)
  {
    super(paramafm, paramArrayOfzf1, paramArrayOfzf2, paramzc, paramObject);
  }
  
  public zg(Class<?> paramClass, zf[] paramArrayOfzf1, zf[] paramArrayOfzf2, zc paramzc, Object paramObject)
  {
    super(paramClass, paramArrayOfzf1, paramArrayOfzf2, paramzc, paramObject);
  }
  
  public static zg a(Class<?> paramClass)
  {
    return new zg(paramClass, a, null, null, null);
  }
  
  public ra<Object> a()
  {
    return new aax(this);
  }
  
  public final void a(Object paramObject, or paramor, ru paramru)
    throws IOException, oq
  {
    paramor.d();
    if (this.e != null) {
      c(paramObject, paramor, paramru);
    }
    for (;;)
    {
      paramor.e();
      return;
      b(paramObject, paramor, paramru);
    }
  }
  
  public String toString()
  {
    return "BeanSerializer for " + c().getName();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/zg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */