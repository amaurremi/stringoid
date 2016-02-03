package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Map;

public final class bi
  implements bd
{
  private static int a(DisplayMetrics paramDisplayMetrics, Map<String, String> paramMap, String paramString, int paramInt)
  {
    paramMap = (String)paramMap.get(paramString);
    int i = paramInt;
    if (paramMap != null) {}
    try
    {
      i = eu.a(paramDisplayMetrics, Integer.parseInt(paramMap));
      return i;
    }
    catch (NumberFormatException paramDisplayMetrics)
    {
      ev.D("Could not parse " + paramString + " in a video GMSG: " + paramMap);
    }
    return paramInt;
  }
  
  public void b(ey paramey, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("action");
    if (str == null)
    {
      ev.D("Action missing from video GMSG.");
      return;
    }
    Object localObject = paramey.bV();
    if (localObject == null)
    {
      ev.D("Could not get ad overlay for a video GMSG.");
      return;
    }
    boolean bool1 = "new".equalsIgnoreCase(str);
    boolean bool2 = "position".equalsIgnoreCase(str);
    int i;
    int j;
    if ((bool1) || (bool2))
    {
      paramey = paramey.getContext().getResources().getDisplayMetrics();
      i = a(paramey, paramMap, "x", 0);
      j = a(paramey, paramMap, "y", 0);
      int k = a(paramey, paramMap, "w", -1);
      int m = a(paramey, paramMap, "h", -1);
      if ((bool1) && (((cg)localObject).aL() == null))
      {
        ((cg)localObject).c(i, j, k, m);
        return;
      }
      ((cg)localObject).b(i, j, k, m);
      return;
    }
    localObject = ((cg)localObject).aL();
    if (localObject == null)
    {
      ck.a(paramey, "no_video_view", null);
      return;
    }
    if ("click".equalsIgnoreCase(str))
    {
      paramey = paramey.getContext().getResources().getDisplayMetrics();
      i = a(paramey, paramMap, "x", 0);
      j = a(paramey, paramMap, "y", 0);
      long l = SystemClock.uptimeMillis();
      paramey = MotionEvent.obtain(l, l, 0, i, j, 0);
      ((ck)localObject).b(paramey);
      paramey.recycle();
      return;
    }
    if ("controls".equalsIgnoreCase(str))
    {
      paramey = (String)paramMap.get("enabled");
      if (paramey == null)
      {
        ev.D("Enabled parameter missing from controls video GMSG.");
        return;
      }
      ((ck)localObject).l(Boolean.parseBoolean(paramey));
      return;
    }
    if ("currentTime".equalsIgnoreCase(str))
    {
      paramey = (String)paramMap.get("time");
      if (paramey == null)
      {
        ev.D("Time parameter missing from currentTime video GMSG.");
        return;
      }
      try
      {
        ((ck)localObject).seekTo((int)(Float.parseFloat(paramey) * 1000.0F));
        return;
      }
      catch (NumberFormatException paramMap)
      {
        ev.D("Could not parse time parameter from currentTime video GMSG: " + paramey);
        return;
      }
    }
    if ("hide".equalsIgnoreCase(str))
    {
      ((ck)localObject).setVisibility(4);
      return;
    }
    if ("load".equalsIgnoreCase(str))
    {
      ((ck)localObject).aV();
      return;
    }
    if ("pause".equalsIgnoreCase(str))
    {
      ((ck)localObject).pause();
      return;
    }
    if ("play".equalsIgnoreCase(str))
    {
      ((ck)localObject).play();
      return;
    }
    if ("show".equalsIgnoreCase(str))
    {
      ((ck)localObject).setVisibility(0);
      return;
    }
    if ("src".equalsIgnoreCase(str))
    {
      ((ck)localObject).o((String)paramMap.get("src"));
      return;
    }
    ev.D("Unknown video action: " + str);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */