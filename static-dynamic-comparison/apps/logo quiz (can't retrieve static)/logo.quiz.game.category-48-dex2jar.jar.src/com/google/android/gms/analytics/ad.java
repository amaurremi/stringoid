package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

class ad
  implements l
{
  private static ad Bi;
  private static Object xz = new Object();
  private final Context mContext;
  
  protected ad(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static ad eR()
  {
    synchronized (xz)
    {
      ad localad = Bi;
      return localad;
    }
  }
  
  public static void y(Context paramContext)
  {
    synchronized (xz)
    {
      if (Bi == null) {
        Bi = new ad(paramContext);
      }
      return;
    }
  }
  
  public boolean ac(String paramString)
  {
    return "&sr".equals(paramString);
  }
  
  protected String eS()
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
    return eS();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/analytics/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */