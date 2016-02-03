package com.greystripe.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

final class DeviceInfo
{
  private static Display b;
  private static int c;
  private static Location d;
  private static ArrayList e;
  private static DeviceInfo f;
  private Context a;
  
  private DeviceInfo() {}
  
  private DeviceInfo(Context paramContext)
  {
    this.a = paramContext;
    d = null;
  }
  
  protected static Location a()
  {
    return d;
  }
  
  private static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return paramString;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    try
    {
      paramString1 = MessageDigest.getInstance(paramString2).digest(str.getBytes());
      paramString2 = new BigInteger(1, paramString1);
      paramString1 = String.format("%0" + (paramString1.length << 1) + "x", new Object[] { paramString2 });
      return paramString1;
    }
    catch (NoSuchAlgorithmException paramString1)
    {
      bd.e("Unable to generate device digest...", new Object[0]);
    }
    return "bad_id";
  }
  
  public static void addLocationListener(DeviceInfo.LocationListener paramLocationListener)
  {
    if (e == null) {
      e = new ArrayList();
    }
    e.add(new WeakReference(paramLocationListener));
  }
  
  private static DisplayMetrics c()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    b.getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public static DeviceInfo getDeviceInfoController(Context paramContext)
  {
    try
    {
      if (f == null)
      {
        f = new DeviceInfo(paramContext);
        b = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
        c = paramContext.getResources().getConfiguration().screenLayout & 0xF;
      }
      paramContext = f;
      return paramContext;
    }
    finally {}
  }
  
  public static void updateLocation(Location paramLocation)
  {
    d = paramLocation;
    if (e != null)
    {
      Iterator localIterator = e.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        if (localObject != null)
        {
          localObject = (DeviceInfo.LocationListener)((WeakReference)localObject).get();
          if (localObject != null) {
            ((DeviceInfo.LocationListener)localObject).onLocationUpdated(paramLocation);
          }
        }
      }
    }
  }
  
  protected final String b()
  {
    try
    {
      String str = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128).metaData.getString("gs_guid");
      return str;
    }
    catch (Exception localException)
    {
      bd.b("No application wide Greystripe GUID was found.", new Object[0]);
    }
    return null;
  }
  
  @JavascriptInterface
  public final String getAndroidVersion()
  {
    return a("Android-" + Build.VERSION.RELEASE);
  }
  
  @JavascriptInterface
  public final float getDensity()
  {
    return c().density;
  }
  
  @JavascriptInterface
  public final int getDensityDpi()
  {
    return c().densityDpi;
  }
  
  @JavascriptInterface
  public final String getGuid()
  {
    return bj.b();
  }
  
  @JavascriptInterface
  public final String getHashedAndroidId(String paramString)
  {
    return a(a(Settings.Secure.getString(this.a.getContentResolver(), "android_id")), paramString);
  }
  
  @JavascriptInterface
  public final String getHashedImeiId(String paramString)
  {
    if (paramString == null) {
      return "$$GSHIID$$";
    }
    if (paramString.startsWith("SHA-1")) {
      return "$$GSHIID$$";
    }
    return "$$GSMHIID$$";
  }
  
  @JavascriptInterface
  public final int getHeightPixels()
  {
    return c().heightPixels;
  }
  
  @JavascriptInterface
  public final String getLanguage()
  {
    return Locale.getDefault().getLanguage();
  }
  
  @JavascriptInterface
  public final int getOrientation()
  {
    return b.getOrientation();
  }
  
  @JavascriptInterface
  public final int getScreenSize()
  {
    return c;
  }
  
  @JavascriptInterface
  public final int getWidthPixels()
  {
    return c().widthPixels;
  }
  
  @JavascriptInterface
  public final boolean hasTelephony()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)this.a.getSystemService("phone");
    return (localTelephonyManager != null) && (localTelephonyManager.getPhoneType() != 0);
  }
  
  @JavascriptInterface
  public final boolean isTablet()
  {
    if ((11 <= Build.VERSION.SDK_INT) && (Build.VERSION.SDK_INT <= 13)) {}
    while ((this.a.getResources().getConfiguration().screenLayout & 0xF) >= 3) {
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/DeviceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */