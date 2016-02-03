package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public final class bh
  implements bd
{
  private final be nb;
  
  public bh(be parambe)
  {
    this.nb = parambe;
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
        return ep.bN();
      }
      if ("l".equalsIgnoreCase(paramMap)) {
        return ep.bM();
      }
    }
    return -1;
  }
  
  public void b(ey paramey, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("a");
    if (str == null) {
      ev.D("Action missing from an open GMSG.");
    }
    ez localez;
    do
    {
      return;
      localez = paramey.bW();
      if ("expand".equalsIgnoreCase(str))
      {
        if (paramey.bZ())
        {
          ev.D("Cannot expand WebView that is already expanded.");
          return;
        }
        localez.a(a(paramMap), b(paramMap));
        return;
      }
      if ("webapp".equalsIgnoreCase(str))
      {
        paramey = (String)paramMap.get("u");
        if (paramey != null)
        {
          localez.a(a(paramMap), b(paramMap), paramey);
          return;
        }
        localez.a(a(paramMap), b(paramMap), (String)paramMap.get("html"), (String)paramMap.get("baseurl"));
        return;
      }
      if (!"in_app_purchase".equalsIgnoreCase(str)) {
        break;
      }
      paramey = (String)paramMap.get("product_id");
      paramMap = (String)paramMap.get("report_urls");
    } while (this.nb == null);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = paramMap.split(" ");
      this.nb.a(paramey, new ArrayList(Arrays.asList(paramMap)));
      return;
    }
    this.nb.a(paramey, new ArrayList());
    return;
    localez.a(new cf((String)paramMap.get("i"), (String)paramMap.get("u"), (String)paramMap.get("m"), (String)paramMap.get("p"), (String)paramMap.get("c"), (String)paramMap.get("f"), (String)paramMap.get("e")));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */