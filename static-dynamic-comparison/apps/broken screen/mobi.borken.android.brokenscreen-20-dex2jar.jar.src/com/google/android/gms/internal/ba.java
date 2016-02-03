package com.google.android.gms.internal;

import java.util.Map;

public final class ba
  implements bd
{
  private final bb mQ;
  
  public ba(bb parambb)
  {
    this.mQ = parambb;
  }
  
  public void b(ey paramey, Map<String, String> paramMap)
  {
    paramey = (String)paramMap.get("name");
    if (paramey == null)
    {
      ev.D("App event with no name parameter.");
      return;
    }
    this.mQ.onAppEvent(paramey, (String)paramMap.get("info"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */