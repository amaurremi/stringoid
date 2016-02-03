package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

class ae
  implements m
{
  private static Object sf = new Object();
  private static ae vH;
  private final Context mContext;
  
  protected ae(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static ae cZ()
  {
    synchronized (sf)
    {
      ae localae = vH;
      return localae;
    }
  }
  
  public static void n(Context paramContext)
  {
    synchronized (sf)
    {
      if (vH == null) {
        vH = new ae(paramContext);
      }
      return;
    }
  }
  
  public boolean C(String paramString)
  {
    return "&sr".equals(paramString);
  }
  
  protected String da()
  {
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    return localDisplayMetrics.widthPixels + "x" + localDisplayMetrics.heightPixels;
  }
  
  public String getValue(String paramString)
  {
    if (paramString == null) {}
    while (!paramString.equals("&sr")) {
      return null;
    }
    return da();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/analytics/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */