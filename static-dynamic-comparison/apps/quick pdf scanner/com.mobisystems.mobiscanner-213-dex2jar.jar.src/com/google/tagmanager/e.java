package com.google.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

class e
{
  private static String ail;
  static Map<String, String> aim = new HashMap();
  
  static void cS(String paramString)
  {
    try
    {
      ail = paramString;
      return;
    }
    finally {}
  }
  
  static void i(Context paramContext, String paramString)
  {
    i.b(paramContext, "gtm_install_referrer", "referrer", paramString);
    j(paramContext, paramString);
  }
  
  static void j(Context paramContext, String paramString)
  {
    String str = q(paramString, "conv");
    if ((str != null) && (str.length() > 0))
    {
      aim.put(str, paramString);
      i.b(paramContext, "gtm_click_referrers", str, paramString);
    }
  }
  
  static String q(String paramString1, String paramString2)
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */