package com.flurry.android.monolithic.sdk.impl;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class afv
  extends LinkedHashMap<String, String>
{
  public static final afv a = new afv();
  
  private afv()
  {
    super(192, 0.8F, true);
  }
  
  public String a(String paramString)
  {
    try
    {
      String str2 = (String)get(paramString);
      String str1 = str2;
      if (str2 == null)
      {
        str1 = paramString.intern();
        put(str1, str1);
      }
      return str1;
    }
    finally {}
  }
  
  protected boolean removeEldestEntry(Map.Entry<String, String> paramEntry)
  {
    return size() > 192;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/afv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */