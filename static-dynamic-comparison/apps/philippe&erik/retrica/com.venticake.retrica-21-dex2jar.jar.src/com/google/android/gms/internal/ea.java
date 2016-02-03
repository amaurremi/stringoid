package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class ea
{
  private int mOrientation = -1;
  private String qG;
  private String qH;
  private String qI;
  private List<String> qJ;
  private String qK;
  private String qL;
  private List<String> qM;
  private long qN = -1L;
  private boolean qO = false;
  private final long qP = -1L;
  private List<String> qQ;
  private long qR = -1L;
  
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
        eu.D("Could not parse float from " + paramString + " header: " + paramMap);
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
    this.qG = a(paramMap, "X-Afma-Ad-Size");
  }
  
  private void f(Map<String, List<String>> paramMap)
  {
    paramMap = c(paramMap, "X-Afma-Click-Tracking-Urls");
    if (paramMap != null) {
      this.qJ = paramMap;
    }
  }
  
  private void g(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Debug-Dialog");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      this.qK = ((String)paramMap.get(0));
    }
  }
  
  private void h(Map<String, List<String>> paramMap)
  {
    paramMap = c(paramMap, "X-Afma-Tracking-Urls");
    if (paramMap != null) {
      this.qM = paramMap;
    }
  }
  
  private void i(Map<String, List<String>> paramMap)
  {
    long l = b(paramMap, "X-Afma-Interstitial-Timeout");
    if (l != -1L) {
      this.qN = l;
    }
  }
  
  private void j(Map<String, List<String>> paramMap)
  {
    this.qL = a(paramMap, "X-Afma-ActiveView");
  }
  
  private void k(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Mediation");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      this.qO = Boolean.valueOf((String)paramMap.get(0)).booleanValue();
    }
  }
  
  private void l(Map<String, List<String>> paramMap)
  {
    paramMap = c(paramMap, "X-Afma-Manual-Tracking-Urls");
    if (paramMap != null) {
      this.qQ = paramMap;
    }
  }
  
  private void m(Map<String, List<String>> paramMap)
  {
    long l = b(paramMap, "X-Afma-Refresh-Rate");
    if (l != -1L) {
      this.qR = l;
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
      this.mOrientation = eo.bS();
    }
    label53:
    while (!"landscape".equalsIgnoreCase(paramMap)) {
      return;
    }
    this.mOrientation = eo.bR();
  }
  
  public void a(String paramString1, Map<String, List<String>> paramMap, String paramString2)
  {
    this.qH = paramString1;
    this.qI = paramString2;
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
  
  public du i(long paramLong)
  {
    return new du(this.qH, this.qI, this.qJ, this.qM, this.qN, this.qO, -1L, this.qQ, this.qR, this.mOrientation, this.qG, paramLong, this.qK, this.qL);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */