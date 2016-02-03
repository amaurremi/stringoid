package com.google.android.gms.analytics;

public final class o
{
  private static String b(String paramString, int paramInt)
  {
    if (paramInt < 1)
    {
      aa.w("index out of range for " + paramString + " (" + paramInt + ")");
      return "";
    }
    return paramString + paramInt;
  }
  
  static String q(int paramInt)
  {
    return b("&cd", paramInt);
  }
  
  static String r(int paramInt)
  {
    return b("&cm", paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/analytics/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */