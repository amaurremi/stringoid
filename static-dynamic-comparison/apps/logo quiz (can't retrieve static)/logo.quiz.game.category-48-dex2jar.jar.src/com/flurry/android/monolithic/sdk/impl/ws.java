package com.flurry.android.monolithic.sdk.impl;

final class ws
  extends we
{
  private static final ws b = new ws(String.class);
  private static final ws c = new ws(Object.class);
  
  private ws(Class<?> paramClass)
  {
    super(paramClass);
  }
  
  public static ws a(Class<?> paramClass)
  {
    if (paramClass == String.class) {
      return b;
    }
    if (paramClass == Object.class) {
      return c;
    }
    return new ws(paramClass);
  }
  
  public String c(String paramString, qm paramqm)
    throws qw
  {
    return paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ws.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */