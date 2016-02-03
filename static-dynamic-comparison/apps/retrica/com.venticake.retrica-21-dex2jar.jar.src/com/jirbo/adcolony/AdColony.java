package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;

public class AdColony
{
  static boolean b;
  boolean a = false;
  
  public static Activity activity()
  {
    return a.b();
  }
  
  public static void addAdAvailabilityListener(AdColonyAdAvailabilityListener paramAdColonyAdAvailabilityListener)
  {
    if (a.ab.contains(paramAdColonyAdAvailabilityListener)) {
      return;
    }
    a.ab.add(paramAdColonyAdAvailabilityListener);
  }
  
  public static void addV4VCListener(AdColonyV4VCListener paramAdColonyV4VCListener)
  {
    if (a.aa.contains(paramAdColonyV4VCListener)) {
      return;
    }
    a.aa.add(paramAdColonyV4VCListener);
  }
  
  public static void cancelVideo()
  {
    if (a.I != null)
    {
      a.I.finish();
      a.W = true;
      a.K.b(null);
    }
  }
  
  public static void configure(Activity paramActivity, String paramString1, String paramString2, String... paramVarArgs)
  {
    b = false;
    Handler localHandler;
    Runnable local1;
    if (Build.VERSION.SDK_INT >= 11)
    {
      new AdColony.a(paramActivity).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      a.ac.clear();
      localHandler = new Handler();
      local1 = new Runnable()
      {
        public void run()
        {
          a.y = false;
        }
      };
      if ((a.y) && (!a.z)) {
        break label156;
      }
      if (!a.q) {
        break label93;
      }
    }
    for (;;)
    {
      return;
      new AdColony.a(paramActivity).execute(new Void[0]);
      break;
      label93:
      if (paramString2 == null)
      {
        a.a("Null App ID - disabling AdColony.");
        return;
      }
      if (paramVarArgs == null)
      {
        a.a("Null Zone IDs array - disabling AdColony.");
        return;
      }
      if (paramVarArgs.length == 0)
      {
        a.a("No Zone IDs provided - disabling AdColony.");
        return;
      }
      a.b(paramActivity);
      a.l.a(paramString1, paramString2, paramVarArgs);
      a.o = true;
      a.y = true;
      localHandler.postDelayed(local1, 120000L);
      label156:
      if (a.I == null) {
        a.v = true;
      }
      a.aa.clear();
      a.ab.clear();
      a.ad = new HashMap();
      int i = 0;
      while (i < paramVarArgs.length)
      {
        a.ad.put(paramVarArgs[i], Boolean.valueOf(false));
        i += 1;
      }
    }
  }
  
  public static void disable()
  {
    a.q = true;
  }
  
  public static void disableDECOverride()
  {
    a.e = null;
  }
  
  public static String getCustomID()
  {
    return a.l.a.x;
  }
  
  public static String getDeviceID()
  {
    return a.l.a.y;
  }
  
  public static int getRemainingV4VCForZone(String paramString)
  {
    if ((a.l == null) || (a.l.h == null) || (a.l.b == null) || (a.l.b.j == null) || (a.l.b.j.n == null)) {
      return l.c.c("getRemainingV4VCForZone called before AdColony has finished configuring.");
    }
    n.y localy = a.l.b.j.n.a(paramString);
    if (!localy.j.a) {
      return l.c.c("getRemainingV4VCForZone called with non-V4VC zone.");
    }
    return localy.j.b.a - a.l.h.b(paramString);
  }
  
  public static void get_images(String paramString)
  {
    a.l.a.b(paramString);
  }
  
  public static boolean isTablet()
  {
    return g.i();
  }
  
  public static boolean isZoneNative(String paramString)
  {
    if (a.l == null) {}
    for (;;)
    {
      return false;
      if ((a.l.b != null) && (a.l.b.j != null) && (a.l.b.j.n != null) && (a.l.b.j.n.a(paramString) != null) && (a.l.b.j.n.a(paramString).i != null) && (a.l.b.j.n.a(paramString).i.a != null))
      {
        int i = 0;
        while (i < a.l.b.j.n.a(paramString).i.a.size())
        {
          if (a.l.b.j.n.a(paramString).i.a(i).w.a) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static boolean isZoneV4VC(String paramString)
  {
    if (a.l == null) {}
    while ((a.l.b == null) || (a.l.b.j == null) || (a.l.b.j.n == null)) {
      return false;
    }
    return a.l.b.a(paramString, false);
  }
  
  public static void onBackPressed()
  {
    int i = 0;
    if ((a.G != null) && ((a.G instanceof ac)))
    {
      ((ViewGroup)a.G.getParent()).removeView(a.G);
      a.v = true;
      a.G.F.c(false);
      while (i < a.Z.size())
      {
        ((Bitmap)a.Z.get(i)).recycle();
        i += 1;
      }
      a.Z.clear();
      a.G = null;
    }
  }
  
  public static void pause()
  {
    l.c.b("[ADC] AdColony pause called.");
    a.t = true;
    int i = 0;
    while (i < a.ac.size())
    {
      if (a.ac.get(i) != null)
      {
        AdColonyNativeAdView localAdColonyNativeAdView = (AdColonyNativeAdView)a.ac.get(i);
        localAdColonyNativeAdView.x = true;
        if ((localAdColonyNativeAdView.V != null) && (!localAdColonyNativeAdView.r) && (localAdColonyNativeAdView.V.isPlaying()))
        {
          if (a.v) {
            localAdColonyNativeAdView.L.setVisibility(0);
          }
          localAdColonyNativeAdView.c();
        }
      }
      i += 1;
    }
  }
  
  public static void removeAdAvailabilityListener(AdColonyAdAvailabilityListener paramAdColonyAdAvailabilityListener)
  {
    a.ab.remove(paramAdColonyAdAvailabilityListener);
  }
  
  public static void removeV4VCListener(AdColonyV4VCListener paramAdColonyV4VCListener)
  {
    a.aa.remove(paramAdColonyV4VCListener);
  }
  
  public static void resume(Activity paramActivity)
  {
    l.c.b("[ADC] AdColony resume called.");
    a.t = false;
    a.a(paramActivity);
    a.s = false;
    if (paramActivity == null)
    {
      l.d.b("Activity reference is null. Disabling AdColony.");
      disable();
      return;
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        while (!AdColony.this.hasWindowFocus()) {
          try
          {
            Thread.sleep(50L);
          }
          catch (Exception localException) {}
        }
        AdColony.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            int i = 0;
            while (i < a.ac.size())
            {
              AdColonyNativeAdView localAdColonyNativeAdView = (AdColonyNativeAdView)a.ac.get(i);
              if ((localAdColonyNativeAdView != null) && (a.b() == localAdColonyNativeAdView.d) && (!localAdColonyNativeAdView.r))
              {
                localAdColonyNativeAdView.x = false;
                localAdColonyNativeAdView.invalidate();
                if (localAdColonyNativeAdView.L != null)
                {
                  localAdColonyNativeAdView.L.a = false;
                  localAdColonyNativeAdView.L.invalidate();
                }
              }
              i += 1;
            }
          }
        });
      }
    }).start();
    a.D = false;
  }
  
  public static void setCustomID(String paramString)
  {
    if (!paramString.equals(a.l.a.x))
    {
      a.l.a.x = paramString;
      a.y = false;
      a.l.b.d = true;
      a.l.b.b = false;
      a.l.b.c = true;
    }
  }
  
  public static void setDeviceID(String paramString)
  {
    if (!paramString.equals(a.l.a.y))
    {
      a.l.a.y = paramString;
      a.y = false;
      a.l.b.d = true;
      a.l.b.b = false;
      a.l.b.c = true;
    }
  }
  
  public static String statusForZone(String paramString)
  {
    if ((a.l == null) || (a.l.b == null) || (a.l.b.j == null) || (a.l.b.j.n == null)) {
      return "unknown";
    }
    n.y localy = a.l.b.j.n.a(paramString);
    if (localy != null)
    {
      if (!localy.e) {
        return "off";
      }
      if ((localy.f) && (a.l.b.c(paramString, true))) {
        return "active";
      }
      return "loading";
    }
    if (!a.p) {
      return "unknown";
    }
    return "invalid";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/AdColony.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */