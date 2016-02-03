package com.flurry.android.monolithic.sdk.impl;

final class wg
  extends we
{
  wg()
  {
    super(Byte.class);
  }
  
  public Byte c(String paramString, qm paramqm)
    throws qw
  {
    int i = a(paramString);
    if ((i < -128) || (i > 127)) {
      throw paramqm.a(this.a, paramString, "overflow, value can not be represented as 8-bit value");
    }
    return Byte.valueOf((byte)i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/wg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */