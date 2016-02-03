package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Map;

public final class be
  implements bb
{
  private static int a(DisplayMetrics paramDisplayMetrics, Map<String, String> paramMap, String paramString, int paramInt)
  {
    paramMap = (String)paramMap.get(paramString);
    int i = paramInt;
    if (paramMap != null) {}
    try
    {
      i = dv.a(paramDisplayMetrics, Integer.parseInt(paramMap));
      return i;
    }
    catch (NumberFormatException paramDisplayMetrics)
    {
      dw.z("Could not parse " + paramString + " in a video GMSG: " + paramMap);
    }
    return paramInt;
  }
  
  public void b(dz paramdz, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("action");
    if (str == null)
    {
      dw.z("Action missing from video GMSG.");
      return;
    }
    Object localObject = paramdz.bH();
    if (localObject == null)
    {
      dw.z("Could not get ad overlay for a video GMSG.");
      return;
    }
    boolean bool1 = "new".equalsIgnoreCase(str);
    boolean bool2 = "position".equalsIgnoreCase(str);
    int i;
    int j;
    if ((bool1) || (bool2))
    {
      paramdz = paramdz.getContext().getResources().getDisplayMetrics();
      i = a(paramdz, paramMap, "x", 0);
      j = a(paramdz, paramMap, "y", 0);
      int k = a(paramdz, paramMap, "w", -1);
      int m = a(paramdz, paramMap, "h", -1);
      if ((bool1) && (((cc)localObject).aK() == null))
      {
        ((cc)localObject).c(i, j, k, m);
        return;
      }
      ((cc)localObject).b(i, j, k, m);
      return;
    }
    localObject = ((cc)localObject).aK();
    if (localObject == null)
    {
      cg.a(paramdz, "no_video_view", null);
      return;
    }
    if ("click".equalsIgnoreCase(str))
    {
      paramdz = paramdz.getContext().getResources().getDisplayMetrics();
      i = a(paramdz, paramMap, "x", 0);
      j = a(paramdz, paramMap, "y", 0);
      long l = SystemClock.uptimeMillis();
      paramdz = MotionEvent.obtain(l, l, 0, i, j, 0);
      ((cg)localObject).b(paramdz);
      paramdz.recycle();
      return;
    }
    if ("controls".equalsIgnoreCase(str))
    {
      paramdz = (String)paramMap.get("enabled");
      if (paramdz == null)
      {
        dw.z("Enabled parameter missing from controls video GMSG.");
        return;
      }
      ((cg)localObject).k(Boolean.parseBoolean(paramdz));
      return;
    }
    if ("currentTime".equalsIgnoreCase(str))
    {
      paramdz = (String)paramMap.get("time");
      if (paramdz == null)
      {
        dw.z("Time parameter missing from currentTime video GMSG.");
        return;
      }
      try
      {
        ((cg)localObject).seekTo((int)(Float.parseFloat(paramdz) * 1000.0F));
        return;
      }
      catch (NumberFormatException paramMap)
      {
        dw.z("Could not parse time parameter from currentTime video GMSG: " + paramdz);
        return;
      }
    }
    if ("hide".equalsIgnoreCase(str))
    {
      ((cg)localObject).setVisibility(4);
      return;
    }
    if ("load".equalsIgnoreCase(str))
    {
      ((cg)localObject).aU();
      return;
    }
    if ("pause".equalsIgnoreCase(str))
    {
      ((cg)localObject).pause();
      return;
    }
    if ("play".equalsIgnoreCase(str))
    {
      ((cg)localObject).play();
      return;
    }
    if ("show".equalsIgnoreCase(str))
    {
      ((cg)localObject).setVisibility(0);
      return;
    }
    if ("src".equalsIgnoreCase(str))
    {
      ((cg)localObject).o((String)paramMap.get("src"));
      return;
    }
    dw.z("Unknown video action: " + str);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */