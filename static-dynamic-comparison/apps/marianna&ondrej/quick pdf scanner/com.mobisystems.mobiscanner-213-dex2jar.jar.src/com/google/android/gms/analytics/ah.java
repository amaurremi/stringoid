package com.google.android.gms.analytics;

import android.os.Build.VERSION;
import java.io.File;

class ah
{
  static boolean ah(String paramString)
  {
    if (version() < 9) {
      return false;
    }
    paramString = new File(paramString);
    paramString.setReadable(false, false);
    paramString.setWritable(false, false);
    paramString.setReadable(true, true);
    paramString.setWritable(true, true);
    return true;
  }
  
  public static int version()
  {
    try
    {
      int i = Integer.parseInt(Build.VERSION.SDK);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      j.Z("Invalid version number: " + Build.VERSION.SDK);
    }
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/analytics/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */