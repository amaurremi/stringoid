package com.gtp.a.a.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.RemoteViews;
import java.io.File;
import java.lang.reflect.Method;

public class c
{
  public static boolean a;
  private static Method b;
  
  static
  {
    if (Build.VERSION.SDK_INT < 11) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      b = null;
      return;
    }
  }
  
  public static int a(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    Object localObject = new DisplayMetrics();
    paramContext.getMetrics((DisplayMetrics)localObject);
    int i = ((DisplayMetrics)localObject).heightPixels;
    int j;
    if ((Build.VERSION.SDK_INT >= 14) && (Build.VERSION.SDK_INT < 17)) {
      try
      {
        j = ((Integer)Display.class.getMethod("getRawHeight", new Class[0]).invoke(paramContext, new Object[0])).intValue();
        return j;
      }
      catch (Exception paramContext)
      {
        if (com.gtp.a.a.b.c.a()) {
          paramContext.printStackTrace();
        }
        return i;
      }
    }
    if (Build.VERSION.SDK_INT >= 17) {
      try
      {
        localObject = new Point();
        Display.class.getMethod("getRealSize", new Class[] { Point.class }).invoke(paramContext, new Object[] { localObject });
        j = ((Point)localObject).y;
        return j;
      }
      catch (Exception paramContext)
      {
        if (com.gtp.a.a.b.c.a()) {
          paramContext.printStackTrace();
        }
      }
    }
    return i;
  }
  
  public static File a()
  {
    com.gtp.a.a.b.c.a("Machine", Environment.getExternalStorageDirectory().getAbsolutePath());
    Object localObject = new File(Environment.getExternalStorageDirectory(), "GOWeatherEX");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    if (((File)localObject).isDirectory()) {}
    File localFile;
    do
    {
      return (File)localObject;
      localFile = new File("/mnt/emmc/GOWeatherEX");
      localObject = localFile;
    } while (localFile.exists());
    localFile.mkdir();
    return localFile;
  }
  
  public static void a(RemoteViews paramRemoteViews, int paramInt)
  {
    if (a) {
      return;
    }
    try
    {
      if (b == null) {
        b = View.class.getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class });
      }
      b.invoke(paramRemoteViews, new Object[] { Integer.valueOf(paramInt), null });
      return;
    }
    catch (Throwable paramRemoteViews)
    {
      a = true;
    }
  }
  
  public static boolean b()
  {
    return a.a() == 3;
  }
  
  public static boolean b(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("config_enableTranslucentDecor", "bool", "android");
    if (i == 0) {
      return false;
    }
    return paramContext.getResources().getBoolean(i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/a/a/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */