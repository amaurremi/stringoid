package com.google.android.gms.internal;

import java.util.Map;

public final class ak
  implements an
{
  private final al fm;
  
  public ak(al paramal)
  {
    this.fm = paramal;
  }
  
  public void a(cw paramcw, Map<String, String> paramMap)
  {
    paramcw = (String)paramMap.get("name");
    if (paramcw == null)
    {
      ct.v("App event with no name parameter.");
      return;
    }
    this.fm.onAppEvent(paramcw, (String)paramMap.get("info"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */