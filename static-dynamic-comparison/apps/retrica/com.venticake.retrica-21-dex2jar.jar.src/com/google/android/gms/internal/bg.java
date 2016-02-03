package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public final class bg
  implements bc
{
  private final bd nd;
  
  public bg(bd parambd)
  {
    this.nd = parambd;
  }
  
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
        return eo.bS();
      }
      if ("l".equalsIgnoreCase(paramMap)) {
        return eo.bR();
      }
    }
    return -1;
  }
  
  public void b(ex paramex, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("a");
    if (str == null) {
      eu.D("Action missing from an open GMSG.");
    }
    ey localey;
    do
    {
      return;
      localey = paramex.cb();
      if ("expand".equalsIgnoreCase(str))
      {
        if (paramex.ce())
        {
          eu.D("Cannot expand WebView that is already expanded.");
          return;
        }
        localey.a(a(paramMap), b(paramMap));
        return;
      }
      if ("webapp".equalsIgnoreCase(str))
      {
        paramex = (String)paramMap.get("u");
        if (paramex != null)
        {
          localey.a(a(paramMap), b(paramMap), paramex);
          return;
        }
        localey.a(a(paramMap), b(paramMap), (String)paramMap.get("html"), (String)paramMap.get("baseurl"));
        return;
      }
      if (!"in_app_purchase".equalsIgnoreCase(str)) {
        break;
      }
      paramex = (String)paramMap.get("product_id");
      paramMap = (String)paramMap.get("report_urls");
    } while (this.nd == null);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = paramMap.split(" ");
      this.nd.a(paramex, new ArrayList(Arrays.asList(paramMap)));
      return;
    }
    this.nd.a(paramex, new ArrayList());
    return;
    localey.a(new ce((String)paramMap.get("i"), (String)paramMap.get("u"), (String)paramMap.get("m"), (String)paramMap.get("p"), (String)paramMap.get("c"), (String)paramMap.get("f"), (String)paramMap.get("e")));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */