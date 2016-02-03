package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Map;

public final class bh
  implements bc
{
  private static int a(DisplayMetrics paramDisplayMetrics, Map<String, String> paramMap, String paramString, int paramInt)
  {
    paramMap = (String)paramMap.get(paramString);
    int i = paramInt;
    if (paramMap != null) {}
    try
    {
      i = et.a(paramDisplayMetrics, Integer.parseInt(paramMap));
      return i;
    }
    catch (NumberFormatException paramDisplayMetrics)
    {
      eu.D("Could not parse " + paramString + " in a video GMSG: " + paramMap);
    }
    return paramInt;
  }
  
  public void b(ex paramex, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("action");
    if (str == null)
    {
      eu.D("Action missing from video GMSG.");
      return;
    }
    Object localObject = paramex.ca();
    if (localObject == null)
    {
      eu.D("Could not get ad overlay for a video GMSG.");
      return;
    }
    boolean bool1 = "new".equalsIgnoreCase(str);
    boolean bool2 = "position".equalsIgnoreCase(str);
    int i;
    int j;
    if ((bool1) || (bool2))
    {
      paramex = paramex.getContext().getResources().getDisplayMetrics();
      i = a(paramex, paramMap, "x", 0);
      j = a(paramex, paramMap, "y", 0);
      int k = a(paramex, paramMap, "w", -1);
      int m = a(paramex, paramMap, "h", -1);
      if ((bool1) && (((cf)localObject).aQ() == null))
      {
        ((cf)localObject).c(i, j, k, m);
        return;
      }
      ((cf)localObject).b(i, j, k, m);
      return;
    }
    localObject = ((cf)localObject).aQ();
    if (localObject == null)
    {
      cj.a(paramex, "no_video_view", null);
      return;
    }
    if ("click".equalsIgnoreCase(str))
    {
      paramex = paramex.getContext().getResources().getDisplayMetrics();
      i = a(paramex, paramMap, "x", 0);
      j = a(paramex, paramMap, "y", 0);
      long l = SystemClock.uptimeMillis();
      paramex = MotionEvent.obtain(l, l, 0, i, j, 0);
      ((cj)localObject).b(paramex);
      paramex.recycle();
      return;
    }
    if ("controls".equalsIgnoreCase(str))
    {
      paramex = (String)paramMap.get("enabled");
      if (paramex == null)
      {
        eu.D("Enabled parameter missing from controls video GMSG.");
        return;
      }
      ((cj)localObject).l(Boolean.parseBoolean(paramex));
      return;
    }
    if ("currentTime".equalsIgnoreCase(str))
    {
      paramex = (String)paramMap.get("time");
      if (paramex == null)
      {
        eu.D("Time parameter missing from currentTime video GMSG.");
        return;
      }
      try
      {
        ((cj)localObject).seekTo((int)(Float.parseFloat(paramex) * 1000.0F));
        return;
      }
      catch (NumberFormatException paramMap)
      {
        eu.D("Could not parse time parameter from currentTime video GMSG: " + paramex);
        return;
      }
    }
    if ("hide".equalsIgnoreCase(str))
    {
      ((cj)localObject).setVisibility(4);
      return;
    }
    if ("load".equalsIgnoreCase(str))
    {
      ((cj)localObject).ba();
      return;
    }
    if ("pause".equalsIgnoreCase(str))
    {
      ((cj)localObject).pause();
      return;
    }
    if ("play".equalsIgnoreCase(str))
    {
      ((cj)localObject).play();
      return;
    }
    if ("show".equalsIgnoreCase(str))
    {
      ((cj)localObject).setVisibility(0);
      return;
    }
    if ("src".equalsIgnoreCase(str))
    {
      ((cj)localObject).o((String)paramMap.get("src"));
      return;
    }
    eu.D("Unknown video action: " + str);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */