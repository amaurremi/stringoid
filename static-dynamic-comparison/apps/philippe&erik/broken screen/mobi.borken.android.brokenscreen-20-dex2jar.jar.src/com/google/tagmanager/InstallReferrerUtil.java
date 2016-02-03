package com.google.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

class InstallReferrerUtil
{
  static final String INTENT_EXTRA_REFERRER = "referrer";
  static final String PREF_KEY_REFERRER = "referrer";
  static final String PREF_NAME_CLICK_REFERRERS = "gtm_click_referrers";
  static final String PREF_NAME_INSTALL_REFERRER = "gtm_install_referrer";
  @VisibleForTesting
  static Map<String, String> clickReferrers = new HashMap();
  private static String installReferrer;
  
  static void addClickReferrer(Context paramContext, String paramString)
  {
    String str = extractComponent(paramString, "conv");
    if ((str != null) && (str.length() > 0))
    {
      clickReferrers.put(str, paramString);
      SharedPreferencesUtil.saveAsync(paramContext, "gtm_click_referrers", str, paramString);
    }
  }
  
  static void cacheInstallReferrer(String paramString)
  {
    try
    {
      installReferrer = paramString;
      return;
    }
    finally {}
  }
  
  static String extractComponent(String paramString1, String paramString2)
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
  
  static String getClickReferrer(Context paramContext, String paramString1, String paramString2)
  {
    String str = (String)clickReferrers.get(paramString1);
    Object localObject = str;
    if (str == null)
    {
      paramContext = paramContext.getSharedPreferences("gtm_click_referrers", 0);
      if (paramContext == null) {
        break label63;
      }
    }
    label63:
    for (paramContext = paramContext.getString(paramString1, "");; paramContext = "")
    {
      clickReferrers.put(paramString1, paramContext);
      localObject = paramContext;
      return extractComponent((String)localObject, paramString2);
    }
  }
  
  /* Error */
  static String getInstallReferrer(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 61	com/google/tagmanager/InstallReferrerUtil:installReferrer	Ljava/lang/String;
    //   3: ifnonnull +40 -> 43
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 61	com/google/tagmanager/InstallReferrerUtil:installReferrer	Ljava/lang/String;
    //   12: ifnonnull +28 -> 40
    //   15: aload_0
    //   16: ldc 15
    //   18: iconst_0
    //   19: invokevirtual 96	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   22: astore_0
    //   23: aload_0
    //   24: ifnull +27 -> 51
    //   27: aload_0
    //   28: ldc 8
    //   30: ldc 98
    //   32: invokeinterface 103 3 0
    //   37: putstatic 61	com/google/tagmanager/InstallReferrerUtil:installReferrer	Ljava/lang/String;
    //   40: ldc 2
    //   42: monitorexit
    //   43: getstatic 61	com/google/tagmanager/InstallReferrerUtil:installReferrer	Ljava/lang/String;
    //   46: aload_1
    //   47: invokestatic 39	com/google/tagmanager/InstallReferrerUtil:extractComponent	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   50: areturn
    //   51: ldc 98
    //   53: putstatic 61	com/google/tagmanager/InstallReferrerUtil:installReferrer	Ljava/lang/String;
    //   56: goto -16 -> 40
    //   59: astore_0
    //   60: ldc 2
    //   62: monitorexit
    //   63: aload_0
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramContext	Context
    //   0	65	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   9	23	59	finally
    //   27	40	59	finally
    //   40	43	59	finally
    //   51	56	59	finally
    //   60	63	59	finally
  }
  
  static void saveInstallReferrer(Context paramContext, String paramString)
  {
    SharedPreferencesUtil.saveAsync(paramContext, "gtm_install_referrer", "referrer", paramString);
    addClickReferrer(paramContext, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/InstallReferrerUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */