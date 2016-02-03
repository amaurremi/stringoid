package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class ch
{
  private String hP;
  private String hQ;
  private String hR;
  private List<String> hS;
  private List<String> hT;
  private long hU = -1L;
  private boolean hV = false;
  private final long hW = -1L;
  private List<String> hX;
  private long hY = -1L;
  private int mOrientation = -1;
  
  private static long a(Map<String, List<String>> paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = (String)paramMap.get(0);
      try
      {
        float f = Float.parseFloat(paramMap);
        return (f * 1000.0F);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        ct.v("Could not parse float from " + paramString + " header: " + paramMap);
      }
    }
    return -1L;
  }
  
  private static List<String> b(Map<String, List<String>> paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = (String)paramMap.get(0);
      if (paramMap != null) {
        return Arrays.asList(paramMap.trim().split("\\s+"));
      }
    }
    return null;
  }
  
  private void e(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Ad-Size");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      this.hP = ((String)paramMap.get(0));
    }
  }
  
  private void f(Map<String, List<String>> paramMap)
  {
    paramMap = b(paramMap, "X-Afma-Click-Tracking-Urls");
    if (paramMap != null) {
      this.hS = paramMap;
    }
  }
  
  private void g(Map<String, List<String>> paramMap)
  {
    paramMap = b(paramMap, "X-Afma-Tracking-Urls");
    if (paramMap != null) {
      this.hT = paramMap;
    }
  }
  
  private void h(Map<String, List<String>> paramMap)
  {
    long l = a(paramMap, "X-Afma-Interstitial-Timeout");
    if (l != -1L) {
      this.hU = l;
    }
  }
  
  private void i(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Mediation");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      this.hV = Boolean.valueOf((String)paramMap.get(0)).booleanValue();
    }
  }
  
  private void j(Map<String, List<String>> paramMap)
  {
    paramMap = b(paramMap, "X-Afma-Manual-Tracking-Urls");
    if (paramMap != null) {
      this.hX = paramMap;
    }
  }
  
  private void k(Map<String, List<String>> paramMap)
  {
    long l = a(paramMap, "X-Afma-Refresh-Rate");
    if (l != -1L) {
      this.hY = l;
    }
  }
  
  private void l(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Orientation");
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = (String)paramMap.get(0);
      if (!"portrait".equalsIgnoreCase(paramMap)) {
        break label53;
      }
      this.mOrientation = co.av();
    }
    label53:
    while (!"landscape".equalsIgnoreCase(paramMap)) {
      return;
    }
    this.mOrientation = co.au();
  }
  
  public void a(String paramString1, Map<String, List<String>> paramMap, String paramString2)
  {
    this.hQ = paramString1;
    this.hR = paramString2;
    d(paramMap);
  }
  
  public cb aq()
  {
    return new cb(this.hQ, this.hR, this.hS, this.hT, this.hU, this.hV, -1L, this.hX, this.hY, this.mOrientation, this.hP);
  }
  
  public void d(Map<String, List<String>> paramMap)
  {
    e(paramMap);
    f(paramMap);
    g(paramMap);
    h(paramMap);
    i(paramMap);
    j(paramMap);
    k(paramMap);
    l(paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */