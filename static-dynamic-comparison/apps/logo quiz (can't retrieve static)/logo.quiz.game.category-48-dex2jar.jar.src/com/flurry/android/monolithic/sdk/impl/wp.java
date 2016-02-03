package com.flurry.android.monolithic.sdk.impl;

final class wp
  extends we
{
  wp()
  {
    super(Integer.class);
  }
  
  public Short c(String paramString, qm paramqm)
    throws qw
  {
    int i = a(paramString);
    if ((i < 32768) || (i > 32767)) {
      throw paramqm.a(this.a, paramString, "overflow, value can not be represented as 16-bit value");
    }
    return Short.valueOf((short)i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/wp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */