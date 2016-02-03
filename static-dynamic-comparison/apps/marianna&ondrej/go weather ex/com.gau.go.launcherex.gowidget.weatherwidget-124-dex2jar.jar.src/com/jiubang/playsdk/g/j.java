package com.jiubang.playsdk.g;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;

public class j
{
  public static float a = 1.0F;
  public static int b;
  public static int c;
  public static int d;
  public static int e = 15;
  public static float f = -1.0F;
  public static float g = -1.0F;
  
  public static int a(float paramFloat)
  {
    return (int)(a * paramFloat + 0.5F);
  }
  
  public static void a(Context paramContext)
  {
    if ((paramContext != null) && (paramContext.getResources() != null))
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      a = paramContext.density;
      c = paramContext.widthPixels;
      d = paramContext.heightPixels;
      b = paramContext.densityDpi;
    }
  }
  
  public static int b(Context paramContext)
  {
    int i = 0;
    paramContext = paramContext.getResources().getDisplayMetrics();
    if (paramContext != null) {
      i = paramContext.widthPixels;
    }
    return i;
  }
  
  public static int c(Context paramContext)
  {
    int i = 0;
    paramContext = paramContext.getResources().getDisplayMetrics();
    if (paramContext != null) {
      i = paramContext.heightPixels;
    }
    return i;
  }
  
  public static boolean d(Context paramContext)
  {
    if ((paramContext.getResources().getConfiguration().screenLayout & 0xF) >= 3) {}
    for (int i = 1; (Build.VERSION.SDK_INT >= 11) && (i != 0); i = 0) {
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/g/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */