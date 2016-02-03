package com.zestadz.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.util.Locale;

public class AdManager
{
  static final String LOG = "ZestADZ SDK";
  static final String SDK_SITE_ID = "14131C047A50414347574B574153415E8B";
  static final String SDK_VERSION_DATE = "20110202";
  private static String adclientId;
  private static InetAddress thisIp;
  private static String ua;
  private static String userAgent;
  
  public static String getAdclientId(Context paramContext)
  {
    if (adclientId == null) {}
    for (;;)
    {
      try
      {
        localObject = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
        if (localObject != null)
        {
          localObject = ((ApplicationInfo)localObject).metaData.getString("ZestADZ_Adclient_ID");
          Log.d("ZestADZ SDK", "AdClient ID read from AndroidManifest.xml is " + (String)localObject);
          if ((!((String)localObject).equals("14131C047A50414347574B574153415E8B")) || (!paramContext.getPackageName().equals("com.zestadz.android"))) {
            continue;
          }
          Log.i("ZestADZ SDK", "This is a default adclient ID. Please get yours from zestadz");
          adclientId = (String)localObject;
        }
      }
      catch (Exception paramContext)
      {
        Object localObject;
        Log.e("ZestADZ SDK", "Could not read ZestADZ_Adclient_ID meta-data from AndroidManifest.xml.", paramContext);
        continue;
      }
      return adclientId;
      setadclientId((String)localObject);
    }
  }
  
  static String getIPAddress()
  {
    try
    {
      thisIp = InetAddress.getLocalHost();
      String str = thisIp.getHostAddress();
      Log.v("IPADDRESS", str.toString());
      return str;
    }
    catch (Exception localException)
    {
      Log.e("INETADDRESS", localException.toString());
    }
    return null;
  }
  
  static String getUserAgent(Context paramContext)
  {
    StringBuffer localStringBuffer;
    if (userAgent == null)
    {
      localStringBuffer = new StringBuffer();
      Object localObject = Build.VERSION.RELEASE;
      if (((String)localObject).length() <= 0) {
        break label200;
      }
      localStringBuffer.append((String)localObject);
      localStringBuffer.append("; ");
      localObject = Locale.getDefault();
      String str = ((Locale)localObject).getLanguage();
      if (str == null) {
        break label210;
      }
      localStringBuffer.append(str.toLowerCase());
      localObject = ((Locale)localObject).getCountry();
      if (localObject != null)
      {
        localStringBuffer.append("-");
        localStringBuffer.append(((String)localObject).toLowerCase());
      }
      label85:
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
      paramContext = new WebView(paramContext).getSettings().getUserAgentString();
      if (!paramContext.contains("google_sdk")) {
        break label220;
      }
    }
    label200:
    label210:
    label220:
    for (ua = URLEncoder.encode("Mozilla/5.0 (Linux; U; Android 1.5; fr-; HTC Hero Build/CRB43) AppleWebKit/528.5+ (KHTML, like Gecko) Version/3.1.2 Mobile Safari/525.20.1");; ua = URLEncoder.encode(paramContext))
    {
      if (Log.isLoggable("ZestADZ SDK", 3)) {
        Log.d("ZestADZ SDK", "Phone's user-agent is:  " + paramContext);
      }
      return ua;
      localStringBuffer.append("1.0");
      break;
      localStringBuffer.append("en");
      break label85;
    }
  }
  
  protected static void integrationError(String paramString)
  {
    Log.e("ZestADZ SDK", paramString);
    throw new IllegalArgumentException(paramString);
  }
  
  public static void setadclientId(String paramString)
  {
    if (paramString == null) {
      integrationError("SETUP ERROR:  Incorrect ZestADZ adclient ID. Please specify correct AdCleint ID in AndroidManifest.xml file:  " + paramString);
    }
    if (paramString.equalsIgnoreCase("14131C047A50414347574B574153415E8B")) {
      integrationError("SETUP ERROR:  Cannot use the sample adclient ID (14131C047A50414347574B574153415E8B).  Yours is available on www.zestadz.com.");
    }
    Log.i("ZestADZ SDK", "Adclient ID set to " + paramString);
    adclientId = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/zestadz/android/AdManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */