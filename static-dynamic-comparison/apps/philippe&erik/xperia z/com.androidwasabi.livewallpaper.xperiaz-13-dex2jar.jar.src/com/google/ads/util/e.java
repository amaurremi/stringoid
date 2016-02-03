package com.google.ads.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.util.DisplayMetrics;

@TargetApi(4)
public final class e
{
  private static int a(Context paramContext, float paramFloat, int paramInt)
  {
    int i = paramInt;
    if ((paramContext.getApplicationInfo().flags & 0x2000) != 0) {
      i = (int)(paramInt / paramFloat);
    }
    return i;
  }
  
  public static int a(Context paramContext, DisplayMetrics paramDisplayMetrics)
  {
    return a(paramContext, paramDisplayMetrics.density, paramDisplayMetrics.heightPixels);
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    paramIntent.setPackage(paramString);
  }
  
  public static int b(Context paramContext, DisplayMetrics paramDisplayMetrics)
  {
    return a(paramContext, paramDisplayMetrics.density, paramDisplayMetrics.widthPixels);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/util/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */