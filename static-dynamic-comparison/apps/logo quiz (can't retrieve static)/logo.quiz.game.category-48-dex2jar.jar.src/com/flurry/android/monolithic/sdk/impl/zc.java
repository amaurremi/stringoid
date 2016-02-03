package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.Method;
import java.util.Map;

public class zc
{
  protected final Method a;
  protected final abl b;
  
  public zc(xl paramxl, abl paramabl)
  {
    this.a = paramxl.e();
    this.b = paramabl;
  }
  
  public void a(ru paramru)
    throws qw
  {
    this.b.a(paramru);
  }
  
  public void a(Object paramObject, or paramor, ru paramru)
    throws Exception
  {
    paramObject = this.a.invoke(paramObject, new Object[0]);
    if (paramObject == null) {
      return;
    }
    if (!(paramObject instanceof Map)) {
      throw new qw("Value returned by 'any-getter' (" + this.a.getName() + "()) not java.util.Map but " + paramObject.getClass().getName());
    }
    this.b.b((Map)paramObject, paramor, paramru);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/zc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */