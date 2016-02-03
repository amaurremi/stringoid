package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

class jz
  extends ji
{
  private final ji f;
  
  public jz(ji paramji)
  {
    super(kj.d);
    this.f = paramji;
  }
  
  void a(kc paramkc, or paramor)
    throws IOException
  {
    paramor.d();
    paramor.a("type", "map");
    paramor.a("values");
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
      if (!(paramObject instanceof jz)) {
        return false;
      }
      paramObject = (jz)paramObject;
    } while ((c((ji)paramObject)) && (this.f.equals(((jz)paramObject).f)) && (this.c.equals(((jz)paramObject).c)));
    return false;
  }
  
  public ji j()
  {
    return this.f;
  }
  
  int m()
  {
    return super.m() + this.f.m();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/jz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */