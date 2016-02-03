package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class eb
{
  private int mOrientation = -1;
  private String qD;
  private String qE;
  private String qF;
  private List<String> qG;
  private String qH;
  private String qI;
  private List<String> qJ;
  private long qK = -1L;
  private boolean qL = false;
  private final long qM = -1L;
  private List<String> qN;
  private long qO = -1L;
  
  private static String a(Map<String, List<String>> paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      return (String)paramMap.get(0);
    }
    return null;
  }
  
  private static long b(Map<String, List<String>> paramMap, String paramString)
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
        ev.D("Could not parse float from " + paramString + " header: " + paramMap);
      }
    }
    return -1L;
  }
  
  private static List<String> c(Map<String, List<String>> paramMap, String paramString)
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
    this.qD = a(paramMap, "X-Afma-Ad-Size");
  }
  
  private void f(Map<String, List<String>> paramMap)
  {
    paramMap = c(paramMap, "X-Afma-Click-Tracking-Urls");
    if (paramMap != null) {
      this.qG = paramMap;
    }
  }
  
  private void g(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Debug-Dialog");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      this.qH = ((String)paramMap.get(0));
    }
  }
  
  private void h(Map<String, List<String>> paramMap)
  {
    paramMap = c(paramMap, "X-Afma-Tracking-Urls");
    if (paramMap != null) {
      this.qJ = paramMap;
    }
  }
  
  private void i(Map<String, List<String>> paramMap)
  {
    long l = b(paramMap, "X-Afma-Interstitial-Timeout");
    if (l != -1L) {
      this.qK = l;
    }
  }
  
  private void j(Map<String, List<String>> paramMap)
  {
    this.qI = a(paramMap, "X-Afma-ActiveView");
  }
  
  private void k(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Mediation");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      this.qL = Boolean.valueOf((String)paramMap.get(0)).booleanValue();
    }
  }
  
  private void l(Map<String, List<String>> paramMap)
  {
    paramMap = c(paramMap, "X-Afma-Manual-Tracking-Urls");
    if (paramMap != null) {
      this.qN = paramMap;
    }
  }
  
  private void m(Map<String, List<String>> paramMap)
  {
    long l = b(paramMap, "X-Afma-Refresh-Rate");
    if (l != -1L) {
      this.qO = l;
    }
  }
  
  private void n(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Orientation");
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = (String)paramMap.get(0);
      if (!"portrait".equalsIgnoreCase(paramMap)) {
        break label53;
      }
      this.mOrientation = ep.bN();
    }
    label53:
    while (!"landscape".equalsIgnoreCase(paramMap)) {
      return;
    }
    this.mOrientation = ep.bM();
  }
  
  public void a(String paramString1, Map<String, List<String>> paramMap, String paramString2)
  {
    this.qE = paramString1;
    this.qF = paramString2;
    d(paramMap);
  }
  
  public void d(Map<String, List<String>> paramMap)
  {
    e(paramMap);
    f(paramMap);
    g(paramMap);
    h(paramMap);
    i(paramMap);
    k(paramMap);
    l(paramMap);
    m(paramMap);
    n(paramMap);
    j(paramMap);
  }
  
  public dv i(long paramLong)
  {
    return new dv(this.qE, this.qF, this.qG, this.qJ, this.qK, this.qL, -1L, this.qN, this.qO, this.mOrientation, this.qD, paramLong, this.qH, this.qI);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/eb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */