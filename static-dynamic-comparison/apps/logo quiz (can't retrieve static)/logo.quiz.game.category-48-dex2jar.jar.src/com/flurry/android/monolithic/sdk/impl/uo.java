package com.flurry.android.monolithic.sdk.impl;

import java.util.Currency;

public class uo
  extends um<Currency>
{
  public uo()
  {
    super(Currency.class);
  }
  
  protected Currency b(String paramString, qm paramqm)
    throws IllegalArgumentException
  {
    return Currency.getInstance(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/uo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */