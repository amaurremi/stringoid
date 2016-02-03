package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Map;

public final class ap
  implements an
{
  private static int a(DisplayMetrics paramDisplayMetrics, Map<String, String> paramMap, String paramString, int paramInt)
  {
    paramMap = (String)paramMap.get(paramString);
    int i = paramInt;
    if (paramMap != null) {}
    try
    {
      i = cs.a(paramDisplayMetrics, Integer.parseInt(paramMap));
      return i;
    }
    catch (NumberFormatException paramDisplayMetrics)
    {
      ct.v("Could not parse " + paramString + " in a video GMSG: " + paramMap);
    }
    return paramInt;
  }
  
  public void a(cw paramcw, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("action");
    if (str == null)
    {
      ct.v("Action missing from video GMSG.");
      return;
    }
    Object localObject = paramcw.aB();
    if (localObject == null)
    {
      ct.v("Could not get ad overlay for a video GMSG.");
      return;
    }
    boolean bool1 = "new".equalsIgnoreCase(str);
    boolean bool2 = "position".equalsIgnoreCase(str);
    int i;
    int j;
    if ((bool1) || (bool2))
    {
      paramcw = paramcw.getContext().getResources().getDisplayMetrics();
      i = a(paramcw, paramMap, "x", 0);
      j = a(paramcw, paramMap, "y", 0);
      int k = a(paramcw, paramMap, "w", -1);
      int m = a(paramcw, paramMap, "h", -1);
      if ((bool1) && (((bk)localObject).W() == null))
      {
        ((bk)localObject).c(i, j, k, m);
        return;
      }
      ((bk)localObject).b(i, j, k, m);
      return;
    }
    localObject = ((bk)localObject).W();
    if (localObject == null)
    {
      bo.a(paramcw, "no_video_view", null);
      return;
    }
    if ("click".equalsIgnoreCase(str))
    {
      paramcw = paramcw.getContext().getResources().getDisplayMetrics();
      i = a(paramcw, paramMap, "x", 0);
      j = a(paramcw, paramMap, "y", 0);
      long l = SystemClock.uptimeMillis();
      paramcw = MotionEvent.obtain(l, l, 0, i, j, 0);
      ((bo)localObject).b(paramcw);
      paramcw.recycle();
      return;
    }
    if ("controls".equalsIgnoreCase(str))
    {
      paramcw = (String)paramMap.get("enabled");
      if (paramcw == null)
      {
        ct.v("Enabled parameter missing from controls video GMSG.");
        return;
      }
      ((bo)localObject).i(Boolean.parseBoolean(paramcw));
      return;
    }
    if ("currentTime".equalsIgnoreCase(str))
    {
      paramcw = (String)paramMap.get("time");
      if (paramcw == null)
      {
        ct.v("Time parameter missing from currentTime video GMSG.");
        return;
      }
      try
      {
        ((bo)localObject).seekTo((int)(Float.parseFloat(paramcw) * 1000.0F));
        return;
      }
      catch (NumberFormatException paramMap)
      {
        ct.v("Could not parse time parameter from currentTime video GMSG: " + paramcw);
        return;
      }
    }
    if ("hide".equalsIgnoreCase(str))
    {
      ((bo)localObject).setVisibility(4);
      return;
    }
    if ("load".equalsIgnoreCase(str))
    {
      ((bo)localObject).af();
      return;
    }
    if ("pause".equalsIgnoreCase(str))
    {
      ((bo)localObject).pause();
      return;
    }
    if ("play".equalsIgnoreCase(str))
    {
      ((bo)localObject).play();
      return;
    }
    if ("show".equalsIgnoreCase(str))
    {
      ((bo)localObject).setVisibility(0);
      return;
    }
    if ("src".equalsIgnoreCase(str))
    {
      ((bo)localObject).n((String)paramMap.get("src"));
      return;
    }
    ct.v("Unknown video action: " + str);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */