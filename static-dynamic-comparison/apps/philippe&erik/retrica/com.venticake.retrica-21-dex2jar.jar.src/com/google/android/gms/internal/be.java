package com.google.android.gms.internal;

import java.util.Map;

public class be
  implements bc
{
  private final bf nc;
  
  public be(bf parambf)
  {
    this.nc = parambf;
  }
  
  public void b(ex paramex, Map<String, String> paramMap)
  {
    boolean bool = "1".equals(paramMap.get("transparentBackground"));
    this.nc.b(bool);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */