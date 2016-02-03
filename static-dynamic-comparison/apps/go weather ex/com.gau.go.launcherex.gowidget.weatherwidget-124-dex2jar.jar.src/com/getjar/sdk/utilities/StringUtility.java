package com.getjar.sdk.utilities;

import java.lang.reflect.Method;

public class StringUtility
{
  public static boolean isNullOrEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
  
  public static String zor(String paramString)
  {
    if (isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'value' must not empty or null.");
    }
    try
    {
      String str = (String)Class.forName("getjar.android.sdk.Z").getMethod("zor", new Class[] { String.class }).invoke(null, new Object[] { paramString });
      return str;
    }
    catch (Exception localException) {}
    return paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/utilities/StringUtility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */