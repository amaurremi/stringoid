package com.flurry.android.monolithic.sdk.impl;

import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As;

public class ym
  extends yk
{
  protected final String a;
  
  public ym(afm paramafm, yi paramyi, qc paramqc, Class<?> paramClass, String paramString)
  {
    super(paramafm, paramyi, paramqc, paramClass);
    this.a = paramString;
  }
  
  public JsonTypeInfo.As a()
  {
    return JsonTypeInfo.As.EXTERNAL_PROPERTY;
  }
  
  public String b()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ym.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */