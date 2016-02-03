package com.flurry.android.monolithic.sdk.impl;

final class wi
  extends we
{
  wi()
  {
    super(Character.class);
  }
  
  public Character c(String paramString, qm paramqm)
    throws qw
  {
    if (paramString.length() == 1) {
      return Character.valueOf(paramString.charAt(0));
    }
    throw paramqm.a(this.a, paramString, "can only convert 1-character Strings");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/wi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */