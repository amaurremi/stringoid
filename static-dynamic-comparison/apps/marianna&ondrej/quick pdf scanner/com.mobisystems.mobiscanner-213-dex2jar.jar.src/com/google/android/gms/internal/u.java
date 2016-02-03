package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Map;

public final class u
  implements s
{
  private static int a(DisplayMetrics paramDisplayMetrics, Map<String, String> paramMap, String paramString, int paramInt)
  {
    paramMap = (String)paramMap.get(paramString);
    int i = paramInt;
    if (paramMap != null) {}
    try
    {
      i = cb.a(paramDisplayMetrics, Integer.parseInt(paramMap));
      return i;
    }
    catch (NumberFormatException paramDisplayMetrics)
    {
      ce.D("Could not parse " + paramString + " in a video GMSG: " + paramMap);
    }
    return paramInt;
  }
  
  public void a(dd paramdd, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("action");
    if (str == null)
    {
      ce.D("Action missing from video GMSG.");
      return;
    }
    Object localObject = paramdd.pW();
    if (localObject == null)
    {
      ce.D("Could not get ad overlay for a video GMSG.");
      return;
    }
    boolean bool1 = "new".equalsIgnoreCase(str);
    boolean bool2 = "position".equalsIgnoreCase(str);
    int i;
    int j;
    if ((bool1) || (bool2))
    {
      paramdd = paramdd.getContext().getResources().getDisplayMetrics();
      i = a(paramdd, paramMap, "x", 0);
      j = a(paramdd, paramMap, "y", 0);
      int k = a(paramdd, paramMap, "w", -1);
      int m = a(paramdd, paramMap, "h", -1);
      if ((bool1) && (((bo)localObject).pj() == null))
      {
        ((bo)localObject).g(i, j, k, m);
        return;
      }
      ((bo)localObject).f(i, j, k, m);
      return;
    }
    localObject = ((bo)localObject).pj();
    if (localObject == null)
    {
      bs.a(paramdd, "no_video_view", null);
      return;
    }
    if ("click".equalsIgnoreCase(str))
    {
      paramdd = paramdd.getContext().getResources().getDisplayMetrics();
      i = a(paramdd, paramMap, "x", 0);
      j = a(paramdd, paramMap, "y", 0);
      long l = SystemClock.uptimeMillis();
      paramdd = MotionEvent.obtain(l, l, 0, i, j, 0);
      ((bs)localObject).h(paramdd);
      paramdd.recycle();
      return;
    }
    if ("controls".equalsIgnoreCase(str))
    {
      paramdd = (String)paramMap.get("enabled");
      if (paramdd == null)
      {
        ce.D("Enabled parameter missing from controls video GMSG.");
        return;
      }
      ((bs)localObject).z(Boolean.parseBoolean(paramdd));
      return;
    }
    if ("currentTime".equalsIgnoreCase(str))
    {
      paramdd = (String)paramMap.get("time");
      if (paramdd == null)
      {
        ce.D("Time parameter missing from currentTime video GMSG.");
        return;
      }
      try
      {
        ((bs)localObject).seekTo((int)(Float.parseFloat(paramdd) * 1000.0F));
        return;
      }
      catch (NumberFormatException paramMap)
      {
        ce.D("Could not parse time parameter from currentTime video GMSG: " + paramdd);
        return;
      }
    }
    if ("hide".equalsIgnoreCase(str))
    {
      ((bs)localObject).setVisibility(4);
      return;
    }
    if ("load".equalsIgnoreCase(str))
    {
      ((bs)localObject).pu();
      return;
    }
    if ("pause".equalsIgnoreCase(str))
    {
      ((bs)localObject).pause();
      return;
    }
    if ("play".equalsIgnoreCase(str))
    {
      ((bs)localObject).play();
      return;
    }
    if ("show".equalsIgnoreCase(str))
    {
      ((bs)localObject).setVisibility(0);
      return;
    }
    if ("src".equalsIgnoreCase(str))
    {
      ((bs)localObject).aC((String)paramMap.get("src"));
      return;
    }
    ce.D("Unknown video action: " + str);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */