package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class a
{
  static boolean A = false;
  static boolean B = false;
  static boolean C = true;
  static boolean D = false;
  static boolean E = false;
  static boolean F = false;
  static h G;
  static AdColonyAd H;
  static ADCVideo I;
  static ADCVideo J;
  static a.a K;
  static a.b L;
  static boolean M = false;
  static boolean N = false;
  static boolean O = false;
  static boolean P = false;
  static int Q = 0;
  static String R;
  static String S;
  static String T;
  static String U;
  static ArrayList<String> V = new ArrayList();
  static boolean W = false;
  static long X = 0L;
  static int Y = 0;
  static ArrayList<Bitmap> Z = new ArrayList();
  public static final boolean a = false;
  static ArrayList<AdColonyV4VCListener> aa = new ArrayList();
  static ArrayList<AdColonyAdAvailabilityListener> ab = new ArrayList();
  static ArrayList<AdColonyNativeAdView> ac = new ArrayList();
  static HashMap ad;
  private static Activity ae;
  public static final boolean b = false;
  public static final boolean c = false;
  public static final boolean d = false;
  public static String e = null;
  public static final String f = null;
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  static final String k = "AdColony";
  static d l = new d();
  static boolean m;
  static int n = 2;
  static boolean o;
  static boolean p;
  static boolean q;
  static boolean r;
  static boolean s;
  static boolean t;
  static boolean u = false;
  static boolean v = true;
  static int w = 0;
  static double x = 1.0D;
  static boolean y = false;
  static boolean z = false;
  
  static void a(int paramInt)
  {
    boolean bool2 = false;
    n = paramInt;
    l locall = l.a;
    if (paramInt <= 0)
    {
      bool1 = true;
      locall.f = bool1;
      locall = l.b;
      if (paramInt > 1) {
        break label96;
      }
      bool1 = true;
      label32:
      locall.f = bool1;
      locall = l.c;
      if (paramInt > 2) {
        break label101;
      }
    }
    label96:
    label101:
    for (boolean bool1 = true;; bool1 = false)
    {
      locall.f = bool1;
      locall = l.d;
      bool1 = bool2;
      if (paramInt <= 3) {
        bool1 = true;
      }
      locall.f = bool1;
      if (paramInt <= 0) {
        b("DEVELOPER LOGGING ENABLED");
      }
      if (paramInt <= 1) {
        c("DEBUG LOGGING ENABLED");
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label32;
    }
  }
  
  static void a(int paramInt, String paramString)
  {
    if (n <= paramInt) {}
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
    case 1: 
      Log.d("AdColony", paramString);
      return;
    case 2: 
      Log.i("AdColony", paramString);
      return;
    }
    Log.e("AdColony", paramString);
  }
  
  static void a(Activity paramActivity)
  {
    if ((paramActivity == ae) || (paramActivity == null)) {
      return;
    }
    ae = paramActivity;
    K = new a.a();
    L = new a.b();
    new p.a();
  }
  
  static void a(AdColonyNativeAdView paramAdColonyNativeAdView)
  {
    ac.add(paramAdColonyNativeAdView);
  }
  
  static void a(j paramj)
  {
    l.a(paramj);
  }
  
  static void a(RuntimeException paramRuntimeException)
  {
    E = true;
    e(paramRuntimeException.toString());
    paramRuntimeException.printStackTrace();
  }
  
  static void a(String paramString)
  {
    E = true;
    e(paramString);
  }
  
  static void a(String paramString, AdColonyAd paramAdColonyAd)
  {
    l.a(paramString, null, paramAdColonyAd);
  }
  
  static void a(String paramString1, String paramString2)
  {
    l.a(paramString1, paramString2);
  }
  
  static void a(String paramString1, String paramString2, AdColonyAd paramAdColonyAd)
  {
    l.a(paramString1, paramString2, paramAdColonyAd);
  }
  
  static boolean a()
  {
    return ae == null;
  }
  
  static Activity b()
  {
    if (ae == null) {
      throw new AdColonyException("AdColony.configure() must be called before any other AdColony methods. If you have called AdColony.configure(), the Activity reference you passed in via AdColony.configure() OR AdColony.resume() is null.");
    }
    return ae;
  }
  
  static void b(Activity paramActivity)
  {
    p = false;
    a(paramActivity);
    G = null;
    m = g.i();
    if (E)
    {
      E = false;
      o = false;
      l = new d();
    }
  }
  
  static void b(String paramString)
  {
    a(0, paramString);
  }
  
  static boolean b(int paramInt)
  {
    return n <= paramInt;
  }
  
  static void c(String paramString)
  {
    a(1, paramString);
  }
  
  static boolean c()
  {
    return (E) || (q) || (!o);
  }
  
  static void d(String paramString)
  {
    a(2, paramString);
  }
  
  static boolean d()
  {
    return (o) && (!E) && (!q);
  }
  
  static void e()
  {
    b();
  }
  
  static void e(String paramString)
  {
    a(3, paramString);
  }
  
  static void f(String paramString)
  {
    Toast.makeText(b(), paramString, 0).show();
  }
  
  static boolean f()
  {
    return n <= 0;
  }
  
  static double g(String paramString)
  {
    return l.a(paramString);
  }
  
  static boolean g()
  {
    return n <= 1;
  }
  
  static int h(String paramString)
  {
    return l.b(paramString);
  }
  
  static void h()
  {
    if (l == null) {
      break label6;
    }
    label6:
    while ((ab.size() == 0) || (ad == null)) {
      return;
    }
    Iterator localIterator = ad.entrySet().iterator();
    label103:
    label238:
    label239:
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      boolean bool2 = ((Boolean)localEntry.getValue()).booleanValue();
      boolean bool1;
      if (AdColony.isZoneV4VC((String)localEntry.getKey()))
      {
        bool1 = l.b((String)localEntry.getKey(), true, false);
        if (!AdColony.isZoneNative((String)localEntry.getKey())) {
          break label238;
        }
        bool1 = new AdColonyNativeAdView(b(), (String)localEntry.getKey(), 300, true).a(true);
      }
      for (;;)
      {
        if (bool2 == bool1) {
          break label239;
        }
        ad.put(localEntry.getKey(), Boolean.valueOf(bool1));
        int i1 = 0;
        while (i1 < ab.size())
        {
          ((AdColonyAdAvailabilityListener)ab.get(i1)).onAdColonyAdAvailabilityChange(bool1, (String)localEntry.getKey());
          i1 += 1;
        }
        break;
        bool1 = l.a((String)localEntry.getKey(), true, false);
        break label103;
      }
    }
  }
  
  static boolean i(String paramString)
  {
    return l.c(paramString);
  }
  
  static String j(String paramString)
  {
    return l.d(paramString);
  }
  
  static void k(String paramString)
  {
    l.a(paramString, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */