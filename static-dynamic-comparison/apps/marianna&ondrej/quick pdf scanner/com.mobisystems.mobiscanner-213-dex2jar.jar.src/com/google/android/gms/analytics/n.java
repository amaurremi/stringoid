package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

class n
  implements af
{
  private static Object mL = new Object();
  private static n nf;
  private final Context mContext;
  
  protected n(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static n kX()
  {
    synchronized (mL)
    {
      n localn = nf;
      return localn;
    }
  }
  
  public static void q(Context paramContext)
  {
    synchronized (mL)
    {
      if (nf == null) {
        nf = new n(paramContext);
      }
      return;
    }
  }
  
  public String getValue(String paramString)
  {
    if (paramString == null) {}
    while (!paramString.equals("&sr")) {
      return null;
    }
    return kY();
  }
  
  protected String kY()
  {
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    return localDisplayMetrics.widthPixels + "x" + localDisplayMetrics.heightPixels;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/analytics/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */