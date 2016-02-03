package com.vungle.sdk;

import android.util.Log;
import java.util.ArrayList;

final class ay
{
  private static k a;
  private static j b;
  private static String c;
  private static i d;
  private static ArrayList<String> e = null;
  private static d f = null;
  
  public static k a()
  {
    return a;
  }
  
  public static void a(i parami)
  {
    d = parami;
  }
  
  public static void a(j paramj)
  {
    b = paramj;
  }
  
  public static void a(k paramk)
  {
    a = paramk;
  }
  
  public static void a(String paramString)
  {
    if (e == null) {
      e = new ArrayList(0);
    }
    e.add(paramString);
  }
  
  public static void a(Throwable paramThrowable)
  {
    c = Log.getStackTraceString(paramThrowable);
  }
  
  public static void a(ArrayList<String> paramArrayList)
  {
    e = paramArrayList;
  }
  
  public static ArrayList<String> b()
  {
    return e;
  }
  
  public static i c()
  {
    return d;
  }
  
  public static j d()
  {
    return b;
  }
  
  public static d e()
  {
    return f;
  }
  
  public static void f()
  {
    f = null;
  }
  
  public static String g()
  {
    String str = c;
    c = null;
    return str;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */