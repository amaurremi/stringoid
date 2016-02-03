package com.google.android.gms.analytics;

import android.os.Build.VERSION;
import java.io.File;

class ai
{
  public static int a()
  {
    try
    {
      int i = Integer.parseInt(Build.VERSION.SDK);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      aa.A("Invalid version number: " + Build.VERSION.SDK);
    }
    return 0;
  }
  
  static boolean a(String paramString)
  {
    if (a() < 9) {
      return false;
    }
    paramString = new File(paramString);
    paramString.setReadable(false, false);
    paramString.setWritable(false, false);
    paramString.setReadable(true, true);
    paramString.setWritable(true, true);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */