package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

class l
  implements ag
{
  private static l a;
  private static Object b = new Object();
  private final Context c;
  
  protected l(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public static l a()
  {
    synchronized (b)
    {
      l locall = a;
      return locall;
    }
  }
  
  public static void a(Context paramContext)
  {
    synchronized (b)
    {
      if (a == null) {
        a = new l(paramContext);
      }
      return;
    }
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {}
    while (!paramString.equals("&sr")) {
      return null;
    }
    return b();
  }
  
  protected String b()
  {
    DisplayMetrics localDisplayMetrics = this.c.getResources().getDisplayMetrics();
    return localDisplayMetrics.widthPixels + "x" + localDisplayMetrics.heightPixels;
  }
  
  public boolean b(String paramString)
  {
    return "&sr".equals(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */