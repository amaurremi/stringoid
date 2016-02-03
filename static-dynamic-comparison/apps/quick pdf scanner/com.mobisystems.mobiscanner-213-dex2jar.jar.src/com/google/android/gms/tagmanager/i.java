package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

class i
{
  private static String WP;
  static Map<String, String> WQ = new HashMap();
  
  static void bp(String paramString)
  {
    try
    {
      WP = paramString;
      return;
    }
    finally {}
  }
  
  static void g(Context paramContext, String paramString)
  {
    z.a(paramContext, "gtm_install_referrer", "referrer", paramString);
    h(paramContext, paramString);
  }
  
  static void h(Context paramContext, String paramString)
  {
    String str = i(paramString, "conv");
    if ((str != null) && (str.length() > 0))
    {
      WQ.put(str, paramString);
      z.a(paramContext, "gtm_click_referrers", str, paramString);
    }
  }
  
  static String i(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      if (paramString1.length() > 0) {
        return paramString1;
      }
      return null;
    }
    return Uri.parse("http://hostname/?" + paramString1).getQueryParameter(paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/tagmanager/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */