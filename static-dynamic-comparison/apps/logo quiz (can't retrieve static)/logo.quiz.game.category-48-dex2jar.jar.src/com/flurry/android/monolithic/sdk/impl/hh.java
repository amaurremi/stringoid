package com.flurry.android.monolithic.sdk.impl;

import android.util.Base64;
import java.util.List;
import org.apache.http.NameValuePair;

public class hh
{
  public static String a(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + ":" + paramString2;
    return "Basic " + Base64.encodeToString(paramString1.getBytes(), 10);
  }
  
  public static String a(List<NameValuePair> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuilder.append(a((NameValuePair)paramList.get(i)) + "/");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String a(NameValuePair paramNameValuePair)
  {
    return (paramNameValuePair.getName() + "=" + paramNameValuePair.getValue()).replaceAll(" ", "%20");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/hh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */