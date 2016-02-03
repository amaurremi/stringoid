package com.google.android.gms.internal;

import java.util.Map;

public final class ay
  implements bb
{
  private final az mF;
  
  public ay(az paramaz)
  {
    this.mF = paramaz;
  }
  
  public void b(dz paramdz, Map<String, String> paramMap)
  {
    paramdz = (String)paramMap.get("name");
    if (paramdz == null)
    {
      dw.z("App event with no name parameter.");
      return;
    }
    this.mF.onAppEvent(paramdz, (String)paramMap.get("info"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */