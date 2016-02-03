package com.google.android.gms.tagmanager;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class cq$c
{
  private final String aeU;
  private final List<cq.e> agZ;
  private final Map<String, List<cq.a>> aha;
  private final int ahb;
  
  private cq$c(List<cq.e> paramList, Map<String, List<cq.a>> paramMap, String paramString, int paramInt)
  {
    this.agZ = Collections.unmodifiableList(paramList);
    this.aha = Collections.unmodifiableMap(paramMap);
    this.aeU = paramString;
    this.ahb = paramInt;
  }
  
  public static cq.d mr()
  {
    return new cq.d(null);
  }
  
  public String getVersion()
  {
    return this.aeU;
  }
  
  public List<cq.e> ms()
  {
    return this.agZ;
  }
  
  public Map<String, List<cq.a>> mt()
  {
    return this.aha;
  }
  
  public String toString()
  {
    return "Rules: " + ms() + "  Macros: " + this.aha;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/cq$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */