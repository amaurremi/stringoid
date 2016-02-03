package com.vungle.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class e
{
  public static String A = "pre_";
  public static String B = "";
  public static String C = "OK";
  public static String D = "DownloadStats";
  public static String E = "id";
  public static String F = "url";
  public static String G = "app_id";
  public static String H = "chk";
  public static String I = "campaign";
  public static String J = "postBundle";
  public static String K = "preBundle";
  public static String L = "expiry";
  public static String M = "callToActionUrl";
  public static String N = "callToActionDest";
  public static String O = "showClose";
  public static String P = "countdown";
  public static String Q = "md5";
  public static String R = "sleep";
  public static String S = "videoHeight";
  public static String T = "videoWidth";
  public static String U = "size";
  public static String V = "asyncThreshold";
  public static String W = "retryCount";
  public static String X = "VUNGLE_PUB_APP_INFO";
  public static String Y = "IsVgAppInstalled";
  public static String Z = "VgLastViewedTime";
  public static int a = 0;
  public static String aa = "VgAdDelayDuration";
  public static String ab = "ACTIVITY_LAUNCH_MODE";
  public static String ac = "webPath";
  public static String ad = "delay";
  public static int ae = 0;
  private static int af;
  private static String[] ag;
  private static String[] ah;
  private static String[] ai;
  private static String[] aj;
  private static String[] ak;
  private static String[] al;
  private static String[] am;
  private static int an = 0;
  private static long ao = 0L;
  private static VunglePub.EventListener ap = null;
  private static Object aq = new Object();
  public static int b = 0;
  public static int c = 1;
  public static int d = 2;
  public static int e = 3;
  public static int f = 3;
  public static int g = 30000;
  public static int h = 0;
  public static int i = 1;
  public static int j = 45;
  public static int k = 1;
  public static int l = 2;
  public static int m = 1000;
  public static int n = 500;
  public static int o = 101;
  public static int p = 102;
  public static long q = 15000L;
  public static long r = 15000L;
  public static long s = 1000L;
  public static String t;
  public static String u;
  public static String v;
  public static String w;
  public static String x;
  public static String y;
  public static String z;
  
  static
  {
    af = 0;
    ag = new String[] { "http://api.vungle.com", "http://acceptance.vungle.com", "http://localhost:3000" };
    ah = new String[] { "/api/v1/requestAd", "/api/v2/requestAd" };
    ai = new String[] { "/api/v1/reportAd", "/api/v2/reportAd" };
    aj = new String[] { "/api/v1/new", "/api/v2/new" };
    ak = new String[] { "/api/v1/sessionStart", "/api/v2/sessionStart" };
    al = new String[] { "/api/v1/sessionEnd", "/api/v2/sessionEnd" };
    am = new String[] { "/api/v1/unfilled", "/api/v2/unfilled" };
    t = "Vungle";
    u = "VungleException";
    v = "Stats";
    w = "VungleDownload";
    x = "Vungle_Media";
    y = "adPayload";
    z = "post_";
  }
  
  public static String a()
  {
    return ag[0] + ah[0];
  }
  
  public static void a(double paramDouble1, double paramDouble2)
  {
    new StringBuilder("End of ad. User viewed: ").append(paramDouble1).append(" / ").append(paramDouble2).append(" seconds.");
    try
    {
      synchronized (aq)
      {
        if (ap != null) {
          new Thread(new h(ap).a(paramDouble1, paramDouble2), "AdViewCallbackThread").start();
        }
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public static void a(int paramInt)
  {
    new StringBuilder("Set to ").append(paramInt).append(" seconds.");
    an = paramInt;
    SharedPreferences.Editor localEditor = ak.e().getSharedPreferences(X, 0).edit();
    localEditor.putInt(aa, paramInt);
    localEditor.commit();
  }
  
  public static void a(long paramLong)
  {
    ao = paramLong;
    SharedPreferences.Editor localEditor = ak.e().getSharedPreferences(X, 0).edit();
    localEditor.putLong(Z, paramLong);
    localEditor.commit();
  }
  
  public static void a(VunglePub.EventListener paramEventListener)
  {
    synchronized (aq)
    {
      ap = paramEventListener;
      return;
    }
  }
  
  public static String b()
  {
    return ag[0] + ai[0];
  }
  
  public static String c()
  {
    return ag[0] + aj[0];
  }
  
  public static String d()
  {
    return ag[0] + ak[0];
  }
  
  public static String e()
  {
    return ag[0] + al[0];
  }
  
  public static String f()
  {
    return ag[0] + am[0];
  }
  
  public static int g()
  {
    return an;
  }
  
  public static long h()
  {
    return ao;
  }
  
  public static void i()
  {
    try
    {
      synchronized (aq)
      {
        if (ap != null) {
          new Thread(new f(ap), "AdStartedCallbackThread").start();
        }
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public static void j()
  {
    try
    {
      synchronized (aq)
      {
        if (ap != null) {
          new Thread(new g(ap), "AdEndCallbackThread").start();
        }
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private static abstract class a
    implements Runnable
  {
    protected VunglePub.EventListener a;
    
    public a(VunglePub.EventListener paramEventListener)
    {
      this.a = paramEventListener;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */