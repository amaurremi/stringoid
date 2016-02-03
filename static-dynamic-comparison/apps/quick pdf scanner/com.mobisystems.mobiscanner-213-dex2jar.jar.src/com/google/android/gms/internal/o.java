package com.google.android.gms.internal;

import java.util.Map;

public final class o
  implements s
{
  private final q xJ;
  
  public o(q paramq)
  {
    this.xJ = paramq;
  }
  
  public void a(dd paramdd, Map<String, String> paramMap)
  {
    paramdd = (String)paramMap.get("name");
    if (paramdd == null)
    {
      ce.D("App event with no name parameter.");
      return;
    }
    this.xJ.d(paramdd, (String)paramMap.get("info"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */