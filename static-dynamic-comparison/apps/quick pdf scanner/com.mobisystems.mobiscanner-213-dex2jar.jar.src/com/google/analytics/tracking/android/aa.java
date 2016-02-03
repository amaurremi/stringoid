package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

class aa
  implements j
{
  private static Object hT = new Object();
  private static aa lo;
  private final Context mContext;
  
  protected aa(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static void d(Context paramContext)
  {
    synchronized (hT)
    {
      if (lo == null) {
        lo = new aa(paramContext);
      }
      return;
    }
  }
  
  public static aa kl()
  {
    synchronized (hT)
    {
      aa localaa = lo;
      return localaa;
    }
  }
  
  public String getValue(String paramString)
  {
    if (paramString == null) {}
    while (!paramString.equals("&sr")) {
      return null;
    }
    return km();
  }
  
  protected String km()
  {
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    return localDisplayMetrics.widthPixels + "x" + localDisplayMetrics.heightPixels;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/analytics/tracking/android/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */