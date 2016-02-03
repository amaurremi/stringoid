package com.flurry.android.monolithic.sdk.impl;

import java.util.Map;

public class i
{
  public final String a;
  public final Map<String, String> b;
  public final bh c;
  
  public i(String paramString, Map<String, String> paramMap, bh parambh)
  {
    this.a = paramString;
    this.b = paramMap;
    this.c = parambh;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("action=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",params=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */