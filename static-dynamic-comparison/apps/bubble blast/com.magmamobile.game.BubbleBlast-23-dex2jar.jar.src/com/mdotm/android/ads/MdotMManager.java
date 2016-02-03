package com.mdotm.android.ads;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class MdotMManager
{
  public static final String LOG_TAG = "MdotM SDK";
  private static final String SDK_VERSION_DATE = "20110102";
  private static String androidId;
  private static String appKey;
  private static String devicId;
  private static String mediationLayerName;
  private static int mediationLayerVersion = 0;
  private static String systemVersion = null;
  private static boolean testMode;
  private static String userAgent;
  
  static
  {
    mediationLayerName = "STANDALONE";
    testMode = false;
  }
  
  public static String getAndroidId(Context paramContext)
  {
    if ((androidId == null) || (androidId.length() < 64)) {
      androidId = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    }
    return androidId;
  }
  
  public static String getAppKey()
  {
    return appKey;
  }
  
  public static String getDeviceId(Context paramContext)
    throws NoSuchAlgorithmException
  {
    if ((devicId == null) || (devicId.length() < 32)) {
      devicId = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    }
    Log.d("MdotM SDK", devicId);
    return devicId;
  }
  
  public static String getMediationLayerName()
  {
    return mediationLayerName;
  }
  
  public static int getMediationLayerVersion()
  {
    return mediationLayerVersion;
  }
  
  public static String getSystemVersion()
  {
    String str;
    if ((systemVersion == null) || (systemVersion.length() == 0))
    {
      str = Build.VERSION.RELEASE;
      if (str.length() <= 0) {
        break label34;
      }
    }
    label34:
    for (systemVersion = str;; systemVersion = "1.0") {
      return systemVersion;
    }
  }
  
  public static int getTestModeValue()
  {
    if (isTestMode()) {
      return 1;
    }
    return 2;
  }
  
  static String getUserAgent()
  {
    StringBuffer localStringBuffer;
    Object localObject;
    if (userAgent == null)
    {
      localStringBuffer = new StringBuffer();
      localObject = Build.VERSION.RELEASE;
      if (((String)localObject).length() <= 0) {
        break label191;
      }
      localStringBuffer.append((String)localObject);
      localStringBuffer.append("; ");
      localObject = Locale.getDefault();
      String str = ((Locale)localObject).getLanguage();
      if (str == null) {
        break label201;
      }
      localStringBuffer.append(str.toLowerCase());
      localObject = ((Locale)localObject).getCountry();
      if (localObject != null)
      {
        localStringBuffer.append("-");
        localStringBuffer.append(((String)localObject).toLowerCase());
      }
    }
    for (;;)
    {
      localObject = Build.MODEL;
      if (((String)localObject).length() > 0)
      {
        localStringBuffer.append("; ");
        localStringBuffer.append((String)localObject);
      }
      localObject = Build.ID;
      if (((String)localObject).length() > 0)
      {
        localStringBuffer.append(" Build/");
        localStringBuffer.append((String)localObject);
      }
      userAgent = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/525.10+ (KHTML, like Gecko) Version/3.0.4 Mobile Safari/523.12.2 (AdWhirl-MdotM-ANDROID-%s)", new Object[] { localStringBuffer, "20110102" });
      if (Log.isLoggable("MdotM SDK", 3)) {
        Log.d("MdotM SDK", "Phone's user-agent is:  " + userAgent);
      }
      return userAgent;
      label191:
      localStringBuffer.append("1.0");
      break;
      label201:
      localStringBuffer.append("en");
    }
  }
  
  private static boolean isTestMode()
  {
    return testMode;
  }
  
  public static void setMediationLayerName(String paramString)
  {
    mediationLayerName = paramString;
  }
  
  public static void setMediationLayerVersion(int paramInt)
  {
    mediationLayerVersion = paramInt;
  }
  
  public static void setPublisherId(String paramString)
  {
    if ((paramString == null) || (paramString.length() != 32))
    {
      if (appKey == null) {
        appKey = "17e4d5882ed6fb8513c38c32d728e5a6";
      }
      return;
    }
    appKey = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/mdotm/android/ads/MdotMManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */