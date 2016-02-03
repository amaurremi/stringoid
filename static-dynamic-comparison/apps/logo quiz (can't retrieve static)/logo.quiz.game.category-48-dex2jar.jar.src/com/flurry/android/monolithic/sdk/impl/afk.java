package com.flurry.android.monolithic.sdk.impl;

final class afk
{
  private final String a;
  private final afk b;
  
  public afk(String paramString, afk paramafk)
  {
    this.a = paramString;
    this.b = paramafk;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    String str = this.a;
    for (afk localafk = this.b;; localafk = localafk.b())
    {
      if (str.length() == paramInt2)
      {
        int i = 0;
        if (str.charAt(i) != paramArrayOfChar[(paramInt1 + i)]) {}
        for (;;)
        {
          if (i != paramInt2) {
            break label72;
          }
          return str;
          int j = i + 1;
          i = j;
          if (j < paramInt2) {
            break;
          }
          i = j;
        }
      }
      label72:
      if (localafk == null) {
        return null;
      }
      str = localafk.a();
    }
  }
  
  public afk b()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/afk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */