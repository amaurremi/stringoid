package com.appflood.mraid;

import java.util.HashMap;
import java.util.Map;

public final class i
{
  private static Map<String, a> a;
  
  static
  {
    HashMap localHashMap = new HashMap();
    a = localHashMap;
    localHashMap.put("close", new a()
    {
      public final d a(Map<String, String> paramAnonymousMap, AFBannerWebView paramAnonymousAFBannerWebView)
      {
        return new f(paramAnonymousMap, paramAnonymousAFBannerWebView);
      }
    });
    a.put("expand", new a()
    {
      public final d a(Map<String, String> paramAnonymousMap, AFBannerWebView paramAnonymousAFBannerWebView)
      {
        return new g(paramAnonymousMap, paramAnonymousAFBannerWebView);
      }
    });
    a.put("resize", new a()
    {
      public final d a(Map<String, String> paramAnonymousMap, AFBannerWebView paramAnonymousAFBannerWebView)
      {
        return new j(paramAnonymousMap, paramAnonymousAFBannerWebView);
      }
    });
    a.put("usecustomclose", new a()
    {
      public final d a(Map<String, String> paramAnonymousMap, AFBannerWebView paramAnonymousAFBannerWebView)
      {
        return new l(paramAnonymousMap, paramAnonymousAFBannerWebView);
      }
    });
    a.put("open", new a()
    {
      public final d a(Map<String, String> paramAnonymousMap, AFBannerWebView paramAnonymousAFBannerWebView)
      {
        return new h(paramAnonymousMap, paramAnonymousAFBannerWebView);
      }
    });
    a.put("playVideo", new a()
    {
      public final d a(Map<String, String> paramAnonymousMap, AFBannerWebView paramAnonymousAFBannerWebView)
      {
        return new v(paramAnonymousMap, paramAnonymousAFBannerWebView);
      }
    });
    a.put("storePicture", new a()
    {
      public final d a(Map<String, String> paramAnonymousMap, AFBannerWebView paramAnonymousAFBannerWebView)
      {
        return new k(paramAnonymousMap, paramAnonymousAFBannerWebView);
      }
    });
    a.put("createCalendarEvent", new a()
    {
      public final d a(Map<String, String> paramAnonymousMap, AFBannerWebView paramAnonymousAFBannerWebView)
      {
        return new e(paramAnonymousMap, paramAnonymousAFBannerWebView);
      }
    });
  }
  
  public static d a(String paramString, Map<String, String> paramMap, AFBannerWebView paramAFBannerWebView)
  {
    paramString = (a)a.get(paramString);
    if (paramString != null) {
      return paramString.a(paramMap, paramAFBannerWebView);
    }
    return null;
  }
  
  static abstract interface a
  {
    public abstract d a(Map<String, String> paramMap, AFBannerWebView paramAFBannerWebView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/mraid/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */