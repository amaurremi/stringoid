package com.jirbo.adcolony;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Locale;

class ADCDevice
{
  static String android_id()
  {
    return Settings.Secure.getString(AdColony.activity().getContentResolver(), "android_id");
  }
  
  static String carrier_name()
  {
    String str2 = ((TelephonyManager)AdColony.activity().getSystemService("phone")).getNetworkOperatorName();
    String str1 = str2;
    if (str2.length() == 0) {
      str1 = "unknown";
    }
    return str1;
  }
  
  static String device_id()
  {
    return Installation.id(ADC.activity());
  }
  
  static int display_height()
  {
    return ADC.activity().getWindowManager().getDefaultDisplay().getHeight();
  }
  
  static int display_width()
  {
    return ADC.activity().getWindowManager().getDefaultDisplay().getWidth();
  }
  
  static String imei()
  {
    try
    {
      String str = ((TelephonyManager)AdColony.activity().getSystemService("phone")).getDeviceId();
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  static boolean is_tablet()
  {
    DisplayMetrics localDisplayMetrics = AdColony.activity().getResources().getDisplayMetrics();
    float f1 = localDisplayMetrics.widthPixels / localDisplayMetrics.xdpi;
    float f2 = localDisplayMetrics.heightPixels / localDisplayMetrics.ydpi;
    return Math.sqrt(f1 * f1 + f2 * f2) >= 6.0D;
  }
  
  static String language()
  {
    return Locale.getDefault().getLanguage();
  }
  
  static String mac_address()
  {
    try
    {
      String str = ((WifiManager)AdColony.activity().getSystemService("wifi")).getConnectionInfo().getMacAddress();
      return str;
    }
    catch (RuntimeException localRuntimeException) {}
    return null;
  }
  
  static String manufacturer()
  {
    return Build.MANUFACTURER;
  }
  
  static int memory_class()
  {
    Context localContext = ADC.activity().getApplicationContext();
    ADC.activity();
    return ((ActivityManager)localContext.getSystemService("activity")).getMemoryClass();
  }
  
  static long memory_used()
  {
    Runtime localRuntime = Runtime.getRuntime();
    return (localRuntime.totalMemory() - localRuntime.freeMemory()) / 1048576;
  }
  
  static String model()
  {
    return Build.MODEL;
  }
  
  static String open_udid()
  {
    return "";
  }
  
  static String os_version()
  {
    return Build.VERSION.RELEASE;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */