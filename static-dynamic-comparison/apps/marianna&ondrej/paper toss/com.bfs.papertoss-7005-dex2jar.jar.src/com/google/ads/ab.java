package com.google.ads;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.google.ads.internal.AdVideoView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.a;
import com.google.ads.internal.d;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.f;
import java.util.HashMap;

public class ab
  implements n
{
  private static final a a = (a)a.a.b();
  
  protected int a(HashMap<String, String> paramHashMap, String paramString, int paramInt, DisplayMetrics paramDisplayMetrics)
  {
    paramHashMap = (String)paramHashMap.get(paramString);
    int i = paramInt;
    if (paramHashMap != null) {}
    try
    {
      float f = TypedValue.applyDimension(1, Integer.parseInt(paramHashMap), paramDisplayMetrics);
      i = (int)f;
      return i;
    }
    catch (NumberFormatException paramDisplayMetrics)
    {
      b.a("Could not parse \"" + paramString + "\" in a video gmsg: " + paramHashMap);
    }
    return paramInt;
  }
  
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    String str = (String)paramHashMap.get("action");
    if (str == null)
    {
      b.a("No \"action\" parameter in a video gmsg.");
      return;
    }
    AdWebView localAdWebView;
    if ((paramWebView instanceof AdWebView))
    {
      localAdWebView = (AdWebView)paramWebView;
      paramWebView = localAdWebView.d();
      if (paramWebView == null) {
        b.a("Could not get adActivity for a video gmsg.");
      }
    }
    else
    {
      b.a("Could not get adWebView for a video gmsg.");
      return;
    }
    boolean bool1 = str.equals("new");
    boolean bool2 = str.equals("position");
    int i;
    int j;
    if ((bool1) || (bool2))
    {
      paramd = AdUtil.a(paramWebView);
      i = a(paramHashMap, "x", 0, paramd);
      j = a(paramHashMap, "y", 0, paramd);
      int k = a(paramHashMap, "w", -1, paramd);
      int m = a(paramHashMap, "h", -1, paramd);
      if ((bool1) && (paramWebView.getAdVideoView() == null))
      {
        paramWebView.newAdVideoView(i, j, k, m);
        return;
      }
      paramWebView.moveAdVideoView(i, j, k, m);
      return;
    }
    paramd = paramWebView.getAdVideoView();
    if (paramd == null)
    {
      a.a(localAdWebView, "onVideoEvent", "{'event': 'error', 'what': 'no_video_view'}");
      return;
    }
    if (str.equals("click"))
    {
      paramWebView = AdUtil.a(paramWebView);
      i = a(paramHashMap, "x", 0, paramWebView);
      j = a(paramHashMap, "y", 0, paramWebView);
      long l = SystemClock.uptimeMillis();
      paramd.a(MotionEvent.obtain(l, l, 0, i, j, 0));
      return;
    }
    if (str.equals("controls"))
    {
      paramHashMap = (String)paramHashMap.get("enabled");
      if (paramHashMap == null)
      {
        b.a("No \"enabled\" parameter in a controls video gmsg.");
        return;
      }
      if (paramHashMap.equals("true"))
      {
        paramd.setMediaControllerEnabled(true);
        return;
      }
      paramd.setMediaControllerEnabled(false);
      return;
    }
    if (str.equals("currentTime"))
    {
      paramHashMap = (String)paramHashMap.get("time");
      if (paramHashMap == null)
      {
        b.a("No \"time\" parameter in a currentTime video gmsg.");
        return;
      }
      try
      {
        paramd.a((int)(Float.parseFloat(paramHashMap) * 1000.0F));
        return;
      }
      catch (NumberFormatException paramd)
      {
        b.a("Could not parse \"time\" parameter: " + paramHashMap);
        return;
      }
    }
    if (str.equals("hide"))
    {
      paramd.setVisibility(4);
      return;
    }
    if (str.equals("load"))
    {
      paramd.b();
      return;
    }
    if (str.equals("pause"))
    {
      paramd.c();
      return;
    }
    if (str.equals("play"))
    {
      paramd.d();
      return;
    }
    if (str.equals("show"))
    {
      paramd.setVisibility(0);
      return;
    }
    if (str.equals("src"))
    {
      paramd.setSrc((String)paramHashMap.get("src"));
      return;
    }
    b.a("Unknown video action: " + str);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/google/ads/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */