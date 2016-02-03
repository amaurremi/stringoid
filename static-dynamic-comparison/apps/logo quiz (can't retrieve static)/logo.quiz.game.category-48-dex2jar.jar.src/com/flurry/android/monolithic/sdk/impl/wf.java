package com.flurry.android.monolithic.sdk.impl;

final class wf
  extends we
{
  wf()
  {
    super(Boolean.class);
  }
  
  public Boolean c(String paramString, qm paramqm)
    throws qw
  {
    if ("true".equals(paramString)) {
      return Boolean.TRUE;
    }
    if ("false".equals(paramString)) {
      return Boolean.FALSE;
    }
    throw paramqm.a(this.a, paramString, "value not 'true' or 'false'");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/wf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */