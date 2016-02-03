package com.gau.go.gostaticsdk.f;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.File;
import java.util.Locale;

public class c
{
  private static boolean a = false;
  private static boolean b = false;
  private static int c = -1;
  
  public static int a()
  {
    if (c == 1) {
      return 1;
    }
    if (c == 0) {
      return 0;
    }
    String[] arrayOfString = new String[5];
    arrayOfString[0] = "/system/bin/";
    arrayOfString[1] = "/system/xbin/";
    arrayOfString[2] = "/system/sbin/";
    arrayOfString[3] = "/sbin/";
    arrayOfString[4] = "/vendor/bin/";
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < arrayOfString.length)
        {
          File localFile = new File(arrayOfString[i] + "su");
          if ((localFile == null) || (!localFile.exists())) {
            break label108;
          }
          c = 1;
          return 1;
        }
      }
      catch (Exception localException)
      {
        c = 0;
        return 0;
      }
      label108:
      i += 1;
    }
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext.getSimState() == 5) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramContext = paramContext.getLine1Number();
        return paramContext;
      }
      return "";
    }
    catch (Exception paramContext)
    {
      return "";
    }
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSimOperator();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private static boolean b()
  {
    boolean bool = true;
    if ((a.a >= 1.5D) || (a.a <= 0.0F)) {
      bool = false;
    }
    do
    {
      return bool;
      if (a.c >= a.d) {
        break;
      }
    } while ((a.c > 480) && (a.d > 800));
    while ((a.c <= 800) || (a.d <= 480)) {
      return false;
    }
    return true;
  }
  
  public static String c(Context paramContext)
  {
    try
    {
      String str1 = ((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso();
      if ((str1 == null) || (str1.trim().equals("")))
      {
        str3 = f(paramContext);
        return str3;
      }
    }
    catch (Exception localException)
    {
      String[] arrayOfString;
      do
      {
        String str2;
        do
        {
          do
          {
            for (;;)
            {
              str2 = "";
            }
            str3 = str2;
          } while (!str2.contains(","));
          arrayOfString = str2.split(",");
          str3 = str2;
        } while (arrayOfString == null);
        String str3 = str2;
      } while (arrayOfString.length <= 1);
      if ((arrayOfString[0] != null) && (!arrayOfString[0].trim().equals(""))) {
        return arrayOfString[0];
      }
      if ((arrayOfString[1] != null) && (!arrayOfString[1].trim().equals(""))) {
        return arrayOfString[1];
      }
    }
    return f(paramContext);
  }
  
  public static boolean d(Context paramContext)
  {
    if (a == true) {
      return b;
    }
    a = true;
    b = b();
    return b;
  }
  
  public static boolean e(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnected())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static String f(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().locale.getCountry();
  }
  
  public static String g(Context paramContext)
  {
    String str = null;
    if (paramContext != null) {
      str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    }
    return str;
  }
  
  public static boolean h(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      int i;
      if (paramContext.getSimState() != 5)
      {
        i = 1;
        paramContext = paramContext.getSimOperator();
        if ((i == 0) && (!TextUtils.isEmpty(paramContext))) {
          break label69;
        }
        paramContext = Locale.getDefault().getCountry();
        if ((paramContext == null) || (!paramContext.contains("CN"))) {
          break label67;
        }
      }
      label67:
      label69:
      while (paramContext.startsWith("460"))
      {
        return true;
        i = 0;
        break;
        return false;
      }
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/gostaticsdk/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */