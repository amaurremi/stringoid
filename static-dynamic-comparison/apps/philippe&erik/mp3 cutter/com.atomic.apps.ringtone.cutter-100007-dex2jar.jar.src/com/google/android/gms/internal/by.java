package com.google.android.gms.internal;

import com.atomic.apps.ringtone.cutter.aa;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class by
{
  private String a;
  private String b;
  private String c;
  private List d;
  private String e;
  private String f;
  private List g;
  private long h = -1L;
  private boolean i = false;
  private List j;
  private long k = -1L;
  private int l = -1;
  
  private static String a(Map paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      return (String)paramMap.get(0);
    }
    return null;
  }
  
  private static long b(Map paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = (String)paramMap.get(0);
      try
      {
        float f1 = Float.parseFloat(paramMap);
        return (f1 * 1000.0F);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        aa.e("Could not parse float from " + paramString + " header: " + paramMap);
      }
    }
    return -1L;
  }
  
  private static List c(Map paramMap, String paramString)
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
  
  public final cz a(long paramLong)
  {
    return new cz(this.b, this.c, this.d, this.g, this.h, this.i, -1L, this.j, this.k, this.l, this.a, paramLong, this.e, this.f);
  }
  
  public final void a(String paramString1, Map paramMap, String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
    a(paramMap);
  }
  
  public final void a(Map paramMap)
  {
    this.a = a(paramMap, "X-Afma-Ad-Size");
    Object localObject = c(paramMap, "X-Afma-Click-Tracking-Urls");
    if (localObject != null) {
      this.d = ((List)localObject);
    }
    localObject = (List)paramMap.get("X-Afma-Debug-Dialog");
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      this.e = ((String)((List)localObject).get(0));
    }
    localObject = c(paramMap, "X-Afma-Tracking-Urls");
    if (localObject != null) {
      this.g = ((List)localObject);
    }
    long l1 = b(paramMap, "X-Afma-Interstitial-Timeout");
    if (l1 != -1L) {
      this.h = l1;
    }
    localObject = (List)paramMap.get("X-Afma-Mediation");
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      this.i = Boolean.valueOf((String)((List)localObject).get(0)).booleanValue();
    }
    localObject = c(paramMap, "X-Afma-Manual-Tracking-Urls");
    if (localObject != null) {
      this.j = ((List)localObject);
    }
    l1 = b(paramMap, "X-Afma-Refresh-Rate");
    if (l1 != -1L) {
      this.k = l1;
    }
    localObject = (List)paramMap.get("X-Afma-Orientation");
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = (String)((List)localObject).get(0);
      if (!"portrait".equalsIgnoreCase((String)localObject)) {
        break label268;
      }
      this.l = bN.c();
    }
    for (;;)
    {
      this.f = a(paramMap, "X-Afma-ActiveView");
      return;
      label268:
      if ("landscape".equalsIgnoreCase((String)localObject)) {
        this.l = bN.b();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */