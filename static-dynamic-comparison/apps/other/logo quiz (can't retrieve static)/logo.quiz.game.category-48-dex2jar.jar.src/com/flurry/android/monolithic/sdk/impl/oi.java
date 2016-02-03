package com.flurry.android.monolithic.sdk.impl;

public abstract class oi
  implements oj
{
  private final String a;
  private final String b;
  private final String c;
  
  public oi(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("MIME type may not be null");
    }
    this.a = paramString;
    int i = paramString.indexOf('/');
    if (i != -1)
    {
      this.b = paramString.substring(0, i);
      this.c = paramString.substring(i + 1);
      return;
    }
    this.b = paramString;
    this.c = null;
  }
  
  public String a()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/oi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */