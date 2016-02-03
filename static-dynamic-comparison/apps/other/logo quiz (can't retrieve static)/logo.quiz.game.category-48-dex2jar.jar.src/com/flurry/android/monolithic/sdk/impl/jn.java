package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

class jn
  extends ji
{
  private final ji f;
  
  public jn(ji paramji)
  {
    super(kj.c);
    this.f = paramji;
  }
  
  void a(kc paramkc, or paramor)
    throws IOException
  {
    paramor.d();
    paramor.a("type", "array");
    paramor.a("items");
    this.f.a(paramkc, paramor);
    this.c.a(paramor);
    paramor.e();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof jn)) {
        return false;
      }
      paramObject = (jn)paramObject;
    } while ((c((ji)paramObject)) && (this.f.equals(((jn)paramObject).f)) && (this.c.equals(((jn)paramObject).c)));
    return false;
  }
  
  public ji i()
  {
    return this.f;
  }
  
  int m()
  {
    return super.m() + this.f.m();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/jn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */