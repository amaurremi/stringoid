package com.google.android.gms.internal;

import java.util.Map;

public final class az
  implements bc
{
  private final ba mS;
  
  public az(ba paramba)
  {
    this.mS = paramba;
  }
  
  public void b(ex paramex, Map<String, String> paramMap)
  {
    paramex = (String)paramMap.get("name");
    if (paramex == null)
    {
      eu.D("App event with no name parameter.");
      return;
    }
    this.mS.onAppEvent(paramex, (String)paramMap.get("info"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */