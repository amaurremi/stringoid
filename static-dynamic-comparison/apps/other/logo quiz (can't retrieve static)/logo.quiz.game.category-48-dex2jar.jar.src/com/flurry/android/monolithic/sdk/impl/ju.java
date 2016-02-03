package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

class ju
  extends kb
{
  private final int i;
  
  public ju(ka paramka, String paramString, int paramInt)
  {
    super(kj.f, paramka, paramString);
    if (paramInt < 0) {
      throw new IllegalArgumentException("Invalid fixed size: " + paramInt);
    }
    this.i = paramInt;
  }
  
  void a(kc paramkc, or paramor)
    throws IOException
  {
    if (c(paramkc, paramor)) {
      return;
    }
    paramor.d();
    paramor.a("type", "fixed");
    d(paramkc, paramor);
    if (e() != null) {
      paramor.a("doc", e());
    }
    paramor.a("size", this.i);
    this.c.a(paramor);
    a(paramor);
    paramor.e();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof ju)) {
        return false;
      }
      paramObject = (ju)paramObject;
    } while ((c((ji)paramObject)) && (a((kb)paramObject)) && (this.i == ((ju)paramObject).i) && (this.c.equals(((ju)paramObject).c)));
    return false;
  }
  
  public int l()
  {
    return this.i;
  }
  
  int m()
  {
    return super.m() + this.i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */