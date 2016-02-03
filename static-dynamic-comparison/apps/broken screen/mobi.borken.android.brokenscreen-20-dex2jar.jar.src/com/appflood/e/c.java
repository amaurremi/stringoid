package com.appflood.e;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.appflood.b.b;
import com.appflood.b.b.a;
import com.appflood.c.d;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Locale;

public final class c
{
  public static String A;
  public static String B = "";
  public static String C = "";
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static int g;
  public static int h;
  public static boolean i = false;
  public static int j;
  public static String k;
  public static String l;
  public static String m;
  public static String n;
  public static String o;
  public static String p;
  public static double q;
  public static double r;
  public static int s;
  public static boolean t = false;
  public static boolean u;
  public static boolean v;
  public static String w;
  public static String x;
  public static boolean y = false;
  public static String z;
  
  public static void a(Context paramContext)
  {
    new StringBuilder("sysutils initialize is_initialed = ").append(y).toString();
    j.a();
    if (y) {
      return;
    }
    try
    {
      localObject1 = (TelephonyManager)paramContext.getSystemService("phone");
    }
    catch (Throwable localThrowable4)
    {
      try
      {
        for (;;)
        {
          Object localObject1;
          a = ((TelephonyManager)localObject1).getDeviceId();
          try
          {
            c = ((TelephonyManager)localObject1).getSubscriberId();
            try
            {
              o = ((TelephonyManager)localObject1).getSimOperator();
              try
              {
                p = ((TelephonyManager)localObject1).getSimOperatorName();
                if (a == null) {
                  a = "";
                }
                if (c == null) {
                  c = "";
                }
                if (f == null) {
                  f = "";
                }
                if (o == null) {
                  o = "";
                }
                if (p == null) {
                  p = "";
                }
                try
                {
                  localObject1 = (LocationManager)paramContext.getSystemService("location");
                  localObject1 = ((LocationManager)localObject1).getLastKnownLocation(((LocationManager)localObject1).getBestProvider(new Criteria(), false));
                  if (localObject1 != null)
                  {
                    q = ((Location)localObject1).getLatitude();
                    r = ((Location)localObject1).getLongitude();
                  }
                }
                catch (Throwable localThrowable9)
                {
                  for (;;) {}
                }
                j = j.a(Build.VERSION.SDK, 3);
                k = Build.MODEL;
                l = Build.BRAND;
                localObject1 = Build.DEVICE;
                m = Build.MANUFACTURER;
                d = Build.VERSION.RELEASE;
                n = Build.DISPLAY;
                localObject1 = Build.PRODUCT;
                localObject1 = Build.BOARD;
                localObject1 = Build.VERSION.INCREMENTAL;
                localObject1 = Build.USER;
                localObject1 = Build.HOST;
                if (j < 8) {
                  System.setProperty("http.keepAlive", "false");
                }
                try
                {
                  b = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
                  label259:
                  if (b == null) {
                    b = "";
                  }
                }
                catch (Throwable localThrowable4)
                {
                  try
                  {
                    localObject1 = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
                    g = ((Display)localObject1).getWidth();
                    h = ((Display)localObject1).getHeight();
                  }
                  catch (Throwable localThrowable4)
                  {
                    try
                    {
                      label299:
                      if ("mounted".equals(Environment.getExternalStorageState()))
                      {
                        localObject1 = new File(Environment.getExternalStorageDirectory(), "__af_tmp");
                        if (((File)localObject1).exists()) {
                          ((File)localObject1).delete();
                        }
                        if (((File)localObject1).createNewFile())
                        {
                          i = true;
                          ((File)localObject1).delete();
                        }
                      }
                    }
                    catch (Throwable localThrowable4)
                    {
                      try
                      {
                        label352:
                        e = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
                        if (e == null) {
                          e = "";
                        }
                        try
                        {
                          localObject1 = (ConnectivityManager)paramContext.getSystemService("connectivity");
                          if (((ConnectivityManager)localObject1).getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED)
                          {
                            bool = true;
                            label409:
                            u = bool;
                            if (((ConnectivityManager)localObject1).getNetworkInfo(1).getState() != NetworkInfo.State.CONNECTED) {
                              break label701;
                            }
                            bool = true;
                            v = bool;
                          }
                        }
                        catch (Throwable localThrowable7)
                        {
                          boolean bool;
                          label500:
                          label701:
                          for (;;) {}
                        }
                        try
                        {
                          s = 0;
                          localObject1 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.tencent.mobileqq"));
                          localObject1 = paramContext.getPackageManager().queryIntentActivities((Intent)localObject1, 0);
                          new StringBuilder("Google Play is supported on this device. (").append(((List)localObject1).size()).append(")").toString();
                          j.a();
                          s = 1;
                          try
                          {
                            localObject1 = Locale.getDefault();
                            w = ((Locale)localObject1).getISO3Country();
                            x = ((Locale)localObject1).getISO3Language();
                            localObject1 = new DisplayMetrics();
                            ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
                            int i1 = ((DisplayMetrics)localObject1).densityDpi;
                            localObject1 = a.a(paramContext, "google_refer");
                            if (j.a(z)) {
                              z = (String)localObject1;
                            }
                            new StringBuilder("Sysutils refer =  ").append(z).toString();
                            j.a();
                            A = new WebView(paramContext).getSettings().getUserAgentString();
                            if (paramContext.checkCallingOrSelfPermission("android.permission.CALL_PHONE") == 0) {
                              t = true;
                            }
                            C = paramContext.getPackageName();
                            new Thread(new Runnable()
                            {
                              public final void run()
                              {
                                try
                                {
                                  Object localObject = AdvertisingIdClient.getAdvertisingIdInfo(this.a);
                                  if (j.a(((AdvertisingIdClient.Info)localObject).getId())) {}
                                  for (localObject = "";; localObject = ((AdvertisingIdClient.Info)localObject).getId())
                                  {
                                    c.B = (String)localObject;
                                    new StringBuilder(" adid = ").append(c.B).toString();
                                    j.a();
                                    d.a();
                                    c.b(this.a);
                                    return;
                                  }
                                  return;
                                }
                                catch (Exception localException)
                                {
                                  d.a();
                                  j.b(localException, " catch advertier id");
                                }
                              }
                            }).start();
                            y = true;
                            return;
                            localThrowable1 = localThrowable1;
                            Object localObject2 = null;
                            j.a();
                            continue;
                            localThrowable2 = localThrowable2;
                            j.b(localThrowable2, "Failed to get ANDROID_ID");
                            break label259;
                            localThrowable3 = localThrowable3;
                            j.a(localThrowable3, "Failed to get display info");
                            break label299;
                            localThrowable4 = localThrowable4;
                            j.b(localThrowable4, "Failed to test external storage writable");
                            break label352;
                            bool = false;
                            break label409;
                            bool = false;
                          }
                          catch (Throwable localThrowable5)
                          {
                            for (;;) {}
                          }
                        }
                        catch (Throwable localThrowable6)
                        {
                          break label500;
                        }
                      }
                      catch (Throwable localThrowable8)
                      {
                        for (;;) {}
                      }
                    }
                  }
                }
              }
              catch (Throwable localThrowable10)
              {
                for (;;) {}
              }
            }
            catch (Throwable localThrowable11)
            {
              for (;;) {}
            }
          }
          catch (Throwable localThrowable12)
          {
            for (;;) {}
          }
        }
      }
      catch (Throwable localThrowable13)
      {
        for (;;) {}
      }
    }
  }
  
  public static boolean a()
  {
    if (j.a(o))
    {
      if (!Locale.getDefault().toString().equals(Locale.CHINA.toString())) {}
    }
    else {
      while (o.startsWith("460")) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */