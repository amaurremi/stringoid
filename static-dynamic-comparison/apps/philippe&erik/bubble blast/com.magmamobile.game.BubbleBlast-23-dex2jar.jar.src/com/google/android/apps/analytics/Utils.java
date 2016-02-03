package com.google.android.apps.analytics;

import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

class Utils
{
  static String addQueueTimeParameter(String paramString, long paramLong)
  {
    String str2 = Uri.parse(paramString).getQueryParameter("utmht");
    String str1 = paramString;
    if (str2 != null) {}
    try
    {
      long l = Long.parseLong(str2);
      str1 = paramString + "&utmqt=" + (paramLong - Long.valueOf(l).longValue());
      return str1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Log.e("GoogleAnalyticsTracker", "Error parsing utmht parameter: " + localNumberFormatException.toString());
    }
    return paramString;
  }
  
  static Map<String, String> parseURLParameters(String paramString)
  {
    HashMap localHashMap = new HashMap();
    paramString = paramString.split("&");
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      String[] arrayOfString = paramString[i].split("=");
      if (arrayOfString.length > 1) {
        localHashMap.put(arrayOfString[0], arrayOfString[1]);
      }
      for (;;)
      {
        i += 1;
        break;
        if (arrayOfString.length == 1) {
          localHashMap.put(arrayOfString[0], null);
        }
      }
    }
    return localHashMap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/android/apps/analytics/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */