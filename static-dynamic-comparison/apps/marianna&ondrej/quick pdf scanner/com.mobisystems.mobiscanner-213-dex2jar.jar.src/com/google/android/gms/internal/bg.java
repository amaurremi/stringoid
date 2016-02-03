package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class bg
{
  private String Ee;
  private String Ef;
  private String Eg;
  private List<String> Eh;
  private List<String> Ei;
  private long Ej = -1L;
  private boolean Ek = false;
  private final long El = -1L;
  private List<String> Em;
  private long En = -1L;
  private int Eo = -1;
  
  private void A(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Orientation");
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = (String)paramMap.get(0);
      if (!"portrait".equalsIgnoreCase(paramMap)) {
        break label53;
      }
      this.Eo = bw.pO();
    }
    label53:
    while (!"landscape".equalsIgnoreCase(paramMap)) {
      return;
    }
    this.Eo = bw.pN();
  }
  
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
        ce.D("Could not parse float from " + paramString + " header: " + paramMap);
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
  
  private void t(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Ad-Size");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      this.Ee = ((String)paramMap.get(0));
    }
  }
  
  private void u(Map<String, List<String>> paramMap)
  {
    paramMap = b(paramMap, "X-Afma-Click-Tracking-Urls");
    if (paramMap != null) {
      this.Eh = paramMap;
    }
  }
  
  private void v(Map<String, List<String>> paramMap)
  {
    paramMap = b(paramMap, "X-Afma-Tracking-Urls");
    if (paramMap != null) {
      this.Ei = paramMap;
    }
  }
  
  private void w(Map<String, List<String>> paramMap)
  {
    long l = a(paramMap, "X-Afma-Interstitial-Timeout");
    if (l != -1L) {
      this.Ej = l;
    }
  }
  
  private void x(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Mediation");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      this.Ek = Boolean.valueOf((String)paramMap.get(0)).booleanValue();
    }
  }
  
  private void y(Map<String, List<String>> paramMap)
  {
    paramMap = b(paramMap, "X-Afma-Manual-Tracking-Urls");
    if (paramMap != null) {
      this.Em = paramMap;
    }
  }
  
  private void z(Map<String, List<String>> paramMap)
  {
    long l = a(paramMap, "X-Afma-Refresh-Rate");
    if (l != -1L) {
      this.En = l;
    }
  }
  
  public void a(String paramString1, Map<String, List<String>> paramMap, String paramString2)
  {
    this.Ef = paramString1;
    this.Eg = paramString2;
    s(paramMap);
  }
  
  public cf j(long paramLong)
  {
    return new cf(this.Ef, this.Eg, this.Eh, this.Ei, this.Ej, this.Ek, -1L, this.Em, this.En, this.Eo, this.Ee, paramLong);
  }
  
  public void s(Map<String, List<String>> paramMap)
  {
    t(paramMap);
    u(paramMap);
    v(paramMap);
    w(paramMap);
    x(paramMap);
    y(paramMap);
    z(paramMap);
    A(paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */