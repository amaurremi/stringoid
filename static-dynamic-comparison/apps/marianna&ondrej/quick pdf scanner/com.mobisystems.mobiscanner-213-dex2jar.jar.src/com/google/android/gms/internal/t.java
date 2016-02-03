package com.google.android.gms.internal;

import java.util.Map;

public final class t
  implements s
{
  private static boolean p(Map<String, String> paramMap)
  {
    return "1".equals(paramMap.get("custom_close"));
  }
  
  private static int q(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("o");
    if (paramMap != null)
    {
      if ("p".equalsIgnoreCase(paramMap)) {
        return bw.pO();
      }
      if ("l".equalsIgnoreCase(paramMap)) {
        return bw.pN();
      }
    }
    return -1;
  }
  
  public void a(dd paramdd, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("a");
    if (str == null)
    {
      ce.D("Action missing from an open GMSG.");
      return;
    }
    ch localch = paramdd.pX();
    if ("expand".equalsIgnoreCase(str))
    {
      if (paramdd.qa())
      {
        ce.D("Cannot expand WebView that is already expanded.");
        return;
      }
      localch.a(p(paramMap), q(paramMap));
      return;
    }
    if ("webapp".equalsIgnoreCase(str))
    {
      paramdd = (String)paramMap.get("u");
      if (paramdd != null)
      {
        localch.a(p(paramMap), q(paramMap), paramdd);
        return;
      }
      localch.a(p(paramMap), q(paramMap), (String)paramMap.get("html"), (String)paramMap.get("baseurl"));
      return;
    }
    localch.a(new bn((String)paramMap.get("i"), (String)paramMap.get("u"), (String)paramMap.get("m"), (String)paramMap.get("p"), (String)paramMap.get("c"), (String)paramMap.get("f"), (String)paramMap.get("e")));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */