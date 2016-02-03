package com.google.android.apps.analytics;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class AnalyticsParameterEncoder
{
  public static String encode(String paramString)
  {
    return encode(paramString, "UTF-8");
  }
  
  static String encode(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = URLEncoder.encode(paramString1, paramString2).replace("+", "%20");
      return paramString2;
    }
    catch (UnsupportedEncodingException paramString2)
    {
      throw new AssertionError("URL encoding failed for: " + paramString1);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/android/apps/analytics/AnalyticsParameterEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */