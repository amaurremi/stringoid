package com.google.android.gms.internal;

import java.util.Map;

public final class ao
  implements an
{
  private static boolean a(Map<String, String> paramMap)
  {
    return "1".equals(paramMap.get("custom_close"));
  }
  
  private static int b(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("o");
    if (paramMap != null)
    {
      if ("p".equalsIgnoreCase(paramMap)) {
        return co.av();
      }
      if ("l".equalsIgnoreCase(paramMap)) {
        return co.au();
      }
    }
    return -1;
  }
  
  public void a(cw paramcw, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("a");
    if (str == null)
    {
      ct.v("Action missing from an open GMSG.");
      return;
    }
    cx localcx = paramcw.aC();
    if ("expand".equalsIgnoreCase(str))
    {
      if (paramcw.aF())
      {
        ct.v("Cannot expand WebView that is already expanded.");
        return;
      }
      localcx.a(a(paramMap), b(paramMap));
      return;
    }
    if ("webapp".equalsIgnoreCase(str))
    {
      paramcw = (String)paramMap.get("u");
      if (paramcw != null)
      {
        localcx.a(a(paramMap), b(paramMap), paramcw);
        return;
      }
      localcx.a(a(paramMap), b(paramMap), (String)paramMap.get("html"), (String)paramMap.get("baseurl"));
      return;
    }
    localcx.a(new bj((String)paramMap.get("i"), (String)paramMap.get("u"), (String)paramMap.get("m"), (String)paramMap.get("p"), (String)paramMap.get("c"), (String)paramMap.get("f"), (String)paramMap.get("e")));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */