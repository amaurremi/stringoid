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

class g
{
  static String a;
  static boolean b;
  
  static String a()
  {
    return Settings.Secure.getString(AdColony.activity().getContentResolver(), "android_id");
  }
  
  static String b()
  {
    String str2 = ((TelephonyManager)AdColony.activity().getSystemService("phone")).getNetworkOperatorName();
    String str1 = str2;
    if (str2.length() == 0) {
      str1 = "unknown";
    }
    return str1;
  }
  
  static int c()
  {
    Context localContext = a.b().getApplicationContext();
    a.b();
    return ((ActivityManager)localContext.getSystemService("activity")).getMemoryClass();
  }
  
  static long d()
  {
    Runtime localRuntime = Runtime.getRuntime();
    return (localRuntime.totalMemory() - localRuntime.freeMemory()) / 1048576;
  }
  
  static String e()
  {
    return aj.a(a.b());
  }
  
  static int f()
  {
    return a.b().getWindowManager().getDefaultDisplay().getWidth();
  }
  
  static int g()
  {
    return a.b().getWindowManager().getDefaultDisplay().getHeight();
  }
  
  static String h()
  {
    return "";
  }
  
  static boolean i()
  {
    DisplayMetrics localDisplayMetrics = AdColony.activity().getResources().getDisplayMetrics();
    float f1 = localDisplayMetrics.widthPixels / localDisplayMetrics.xdpi;
    float f2 = localDisplayMetrics.heightPixels / localDisplayMetrics.ydpi;
    return Math.sqrt(f2 * f2 + f1 * f1) >= 6.0D;
  }
  
  static String j()
  {
    return Locale.getDefault().getLanguage();
  }
  
  static String k()
  {
    try
    {
      String str = ((WifiManager)AdColony.activity().getSystemService("wifi")).getConnectionInfo().getMacAddress();
      return str;
    }
    catch (RuntimeException localRuntimeException) {}
    return null;
  }
  
  static String l()
  {
    return Build.MANUFACTURER;
  }
  
  static String m()
  {
    return Build.MODEL;
  }
  
  static String n()
  {
    return "";
  }
  
  static String o()
  {
    return Build.VERSION.RELEASE;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */