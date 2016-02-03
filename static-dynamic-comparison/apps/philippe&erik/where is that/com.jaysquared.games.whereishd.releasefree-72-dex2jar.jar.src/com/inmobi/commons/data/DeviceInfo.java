package com.inmobi.commons.data;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import java.util.Locale;
import java.util.Properties;
import java.util.UUID;

public class DeviceInfo
{
  private static String a;
  private static String b;
  private static String c;
  private static String d = null;
  private static String e = null;
  private static String f;
  private static String g;
  private static int h;
  private static DeviceInfo j = new DeviceInfo();
  private Activity i;
  
  private static String a()
  {
    return c;
  }
  
  private static void a(int paramInt)
  {
    h = paramInt;
  }
  
  private static void a(Context paramContext)
  {
    try
    {
      if (f == null) {
        f = paramContext.getSharedPreferences("inmobisdkaid", 0).getString("A_ID", null);
      }
      if (f == null)
      {
        f = UUID.randomUUID().toString();
        paramContext = paramContext.getSharedPreferences("inmobisdkaid", 0).edit();
        paramContext.putString("A_ID", f);
        paramContext.commit();
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private static void a(String paramString)
  {
    a = paramString;
  }
  
  private static void b(String paramString)
  {
    b = paramString;
  }
  
  private static void c(String paramString)
  {
    c = paramString;
  }
  
  public static String getAid()
  {
    return f;
  }
  
  public static DeviceInfo getInstance()
  {
    return j;
  }
  
  public static String getLocalization()
  {
    return b;
  }
  
  public static String getNetworkType()
  {
    return a;
  }
  
  public static int getOrientation()
  {
    return h;
  }
  
  public static String getPhoneDefaultUserAgent()
  {
    if (g == null) {
      return "";
    }
    return g;
  }
  
  public static String getScreenDensity()
  {
    return e;
  }
  
  public static String getScreenSize()
  {
    return d;
  }
  
  public static void setPhoneDefaultUserAgent(String paramString)
  {
    g = paramString;
  }
  
  public static void setScreenDensity(String paramString)
  {
    e = paramString;
  }
  
  public static void setScreenSize(String paramString)
  {
    d = paramString;
  }
  
  public void fillDeviceInfo()
  {
    Object localObject;
    String str1;
    String str2;
    if (a() == null)
    {
      c(Build.BRAND);
      localObject = Locale.getDefault();
      str1 = ((Locale)localObject).getLanguage();
      if (str1 != null)
      {
        str1 = str1.toLowerCase(Locale.ENGLISH);
        str2 = ((Locale)localObject).getCountry();
        localObject = str1;
        if (str2 != null) {
          localObject = str1 + "_" + str2.toLowerCase(Locale.ENGLISH);
        }
        b((String)localObject);
      }
    }
    else
    {
      if (InternalSDKUtil.getContext() != null) {
        a(InternalSDKUtil.getContext());
      }
      a(InternalSDKUtil.getConnectivityType(InternalSDKUtil.getContext()));
    }
    label227:
    for (;;)
    {
      int k;
      try
      {
        k = WrapperFunctions.getCurrentOrientationInFixedValues(this.i);
        if (k == 9)
        {
          a(2);
          return;
          localObject = (String)System.getProperties().get("user.language");
          str2 = (String)System.getProperties().get("user.region");
          if ((localObject == null) || (str2 == null)) {
            break label227;
          }
          str1 = (String)localObject + "_" + str2;
          localObject = str1;
          if (str1 != null) {
            break;
          }
          localObject = "en";
          break;
        }
        if (k == 8)
        {
          a(4);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.debug("[InMobi]-4.1.1", "Error getting the orientation info ", localException);
        return;
      }
      if (k == 0)
      {
        a(3);
        return;
      }
      a(1);
      return;
    }
  }
  
  public void init(Activity paramActivity)
  {
    this.i = paramActivity;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/data/DeviceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */