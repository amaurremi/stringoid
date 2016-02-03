package com.gau.go.gostaticsdk.f;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import java.lang.reflect.Method;

public class a
{
  public static float a = 1.0F;
  public static int b;
  public static int c;
  public static int d;
  public static float e;
  public static int f = 15;
  public static int g;
  public static float h = -1.0F;
  public static float i = -1.0F;
  private static Class j = null;
  private static Method k = null;
  private static Method l = null;
  
  public static void a(Context paramContext)
  {
    if ((paramContext != null) && (paramContext.getResources() != null))
    {
      DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      a = localDisplayMetrics.density;
      e = localDisplayMetrics.scaledDensity;
      c = localDisplayMetrics.widthPixels;
      d = localDisplayMetrics.heightPixels;
      b = localDisplayMetrics.densityDpi;
      if (c.d(paramContext)) {
        g = b(paramContext) - d;
      }
    }
    try
    {
      paramContext = ViewConfiguration.get(paramContext);
      if (paramContext != null) {
        f = paramContext.getScaledTouchSlop();
      }
      return;
    }
    catch (Error paramContext)
    {
      Log.i("DrawUtils", "resetDensity has error" + paramContext.getMessage());
    }
  }
  
  public static int b(Context paramContext)
  {
    if (paramContext != null) {
      paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    }
    for (;;)
    {
      try
      {
        if (j == null) {
          j = Class.forName("android.view.Display");
        }
        if (l == null) {
          l = j.getMethod("getRealHeight", new Class[0]);
        }
        m = ((Integer)l.invoke(paramContext, new Object[0])).intValue();
      }
      catch (Exception paramContext)
      {
        int n;
        m = 0;
        continue;
      }
      n = m;
      if (m == 0) {
        n = d;
      }
      return n;
      int m = 0;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/gostaticsdk/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */