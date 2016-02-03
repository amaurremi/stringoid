package com.vungle.sdk;

import android.content.Context;

public final class ak
{
  public static float A;
  public static int B;
  public static int C;
  public static boolean D = false;
  public static String E = null;
  public static boolean F = true;
  private static Context G;
  private static boolean H;
  private static int I;
  private static int J;
  private static int K;
  private static long L = e.q;
  private static long M = e.q;
  private static long N = e.g;
  public static String a = "";
  public static String b = "";
  public static String c = "";
  public static String d = "";
  public static String e = "";
  public static String f = "";
  public static String g = "";
  public static String h = "";
  public static boolean i = false;
  public static boolean j = false;
  public static Boolean k = Boolean.valueOf(false);
  public static Boolean l = Boolean.valueOf(false);
  public static boolean m;
  public static boolean n;
  public static boolean o;
  public static boolean p;
  public static boolean q;
  public static boolean r;
  public static boolean s;
  public static boolean t;
  public static boolean u;
  public static float v;
  public static float w;
  public static float x;
  public static float y;
  public static float z;
  
  static
  {
    H = false;
    m = false;
    n = false;
    o = false;
    p = true;
    q = true;
    r = false;
    s = true;
    t = false;
    u = false;
    v = 960.0F;
    w = 540.0F;
    x = 960.0F;
    y = 540.0F;
    z = 1.0F;
    A = 1.0F;
    I = 3;
    J = 5;
    B = e.b;
    C = 0;
    K = -1;
  }
  
  public static long a()
  {
    if (L < e.q) {
      L = 300000L;
    }
    return L;
  }
  
  public static void a(int paramInt)
  {
    I = paramInt;
  }
  
  public static void a(long paramLong)
  {
    if (paramLong < e.q) {
      L = 300000L;
    }
    L = paramLong;
  }
  
  public static void a(Context paramContext)
  {
    G = paramContext.getApplicationContext();
  }
  
  public static void a(boolean paramBoolean)
  {
    if ((H) && (!paramBoolean))
    {
      e.a(System.currentTimeMillis());
      e.j();
    }
    for (;;)
    {
      H = paramBoolean;
      return;
      if ((!H) && (paramBoolean)) {
        e.i();
      }
    }
  }
  
  public static long b()
  {
    return M;
  }
  
  public static void b(long paramLong)
  {
    N = paramLong;
  }
  
  public static int c()
  {
    return I;
  }
  
  public static boolean d()
  {
    return H;
  }
  
  public static Context e()
  {
    return G;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */