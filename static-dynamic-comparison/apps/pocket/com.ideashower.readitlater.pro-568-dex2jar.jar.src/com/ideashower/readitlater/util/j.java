package com.ideashower.readitlater.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.ideashower.readitlater.a.g;

public class j
{
  public static int a;
  private static DisplayMetrics b;
  
  public static float a(int paramInt)
  {
    if (b == null) {
      b = g.c().getResources().getDisplayMetrics();
    }
    return paramInt / b.density;
  }
  
  public static int a()
  {
    if (a == 0) {
      a = j();
    }
    if (a == 0) {
      return 1;
    }
    return a;
  }
  
  public static int a(float paramFloat)
  {
    if (b == null) {
      b = g.c().getResources().getDisplayMetrics();
    }
    return (int)TypedValue.applyDimension(1, paramFloat, b);
  }
  
  public static int a(float paramFloat1, float paramFloat2)
  {
    if (c()) {
      return a(paramFloat2);
    }
    return a(paramFloat1);
  }
  
  public static boolean a(boolean paramBoolean)
  {
    if (!"Amazon".equalsIgnoreCase(Build.MANUFACTURER)) {}
    do
    {
      do
      {
        return false;
      } while ((!"Kindle Fire".equalsIgnoreCase(Build.PRODUCT)) && (!"Kindle Fire".equalsIgnoreCase(Build.MODEL)));
      if (!paramBoolean) {
        return true;
      }
    } while ((!"Kindle Fire".equalsIgnoreCase(Build.MODEL)) && (!"KFOT".equalsIgnoreCase(Build.MODEL)) && (!"KFTT".equalsIgnoreCase(Build.MODEL)));
    return true;
  }
  
  public static float b(float paramFloat)
  {
    return a((int)paramFloat);
  }
  
  public static String b(boolean paramBoolean)
  {
    if (d()) {
      return "tablet";
    }
    if (e()) {
      return "smalltablet";
    }
    if (paramBoolean) {
      return null;
    }
    return "phone";
  }
  
  public static void b()
  {
    a();
  }
  
  public static boolean c()
  {
    return (a() == 5) || (a() == 3) || (a() == 4);
  }
  
  public static boolean d()
  {
    return a() == 5;
  }
  
  public static boolean e()
  {
    return (a() == 3) || (a() == 4);
  }
  
  public static boolean f()
  {
    return (a() == 1) || (a() == 2);
  }
  
  public static boolean g()
  {
    return (a() == 5) || (a() == 3);
  }
  
  public static String h()
  {
    switch ()
    {
    default: 
      return "Unknown";
    case 1: 
      return "Handset";
    case 2: 
      return "Phablet";
    case 3: 
      return "Small Tablet";
    case 4: 
      return "Micro Tablet";
    }
    return "Tablet";
  }
  
  @SuppressLint({"NewApi"})
  public static boolean i()
  {
    if (a.i()) {
      return ViewConfiguration.get(g.c()).hasPermanentMenuKey();
    }
    return !a.e();
  }
  
  private static int j()
  {
    switch (g.c().getResources().getConfiguration().screenLayout & 0xF)
    {
    default: 
      return 1;
    case 4: 
      return 5;
    }
    return k();
  }
  
  private static int k()
  {
    float f1;
    if (Build.VERSION.SDK_INT >= 13) {
      f1 = new b().a();
    }
    while (f1 >= 590.0F)
    {
      return 3;
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)g.c().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      float f2 = a(localDisplayMetrics.widthPixels);
      float f3 = a(localDisplayMetrics.heightPixels);
      if ((f2 == 0.0F) || (f3 == 0.0F)) {
        return 0;
      }
      f1 = f3;
      if (f2 <= f3) {
        f1 = f2;
      }
    }
    if (f1 >= 525.0F) {
      return 4;
    }
    return 2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */