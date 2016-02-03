package com.chartboost.sdk.impl;

import java.util.regex.Pattern;

public class af
{
  private static Pattern a = Pattern.compile("\\s+", 40);
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2) {
      throw new a("" + paramInt1 + " != " + paramInt2);
    }
  }
  
  public static class a
    extends RuntimeException
  {
    final String a;
    
    a(String paramString)
    {
      super();
      this.a = paramString;
    }
    
    public String toString()
    {
      return this.a;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */