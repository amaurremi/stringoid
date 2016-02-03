package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.Locale;

public class uq
  extends um<Locale>
{
  public uq()
  {
    super(Locale.class);
  }
  
  protected Locale b(String paramString, qm paramqm)
    throws IOException
  {
    int i = paramString.indexOf('_');
    if (i < 0) {
      return new Locale(paramString);
    }
    paramqm = paramString.substring(0, i);
    paramString = paramString.substring(i + 1);
    i = paramString.indexOf('_');
    if (i < 0) {
      return new Locale(paramqm, paramString);
    }
    return new Locale(paramqm, paramString.substring(0, i), paramString.substring(i + 1));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/uq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */