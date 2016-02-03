package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

public final class CustomEventExtras
  implements NetworkExtras
{
  private final HashMap<String, Object> ji = new HashMap();
  
  public Object getExtra(String paramString)
  {
    return this.ji.get(paramString);
  }
  
  public void setExtra(String paramString, Object paramObject)
  {
    this.ji.put(paramString, paramObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/ads/mediation/customevent/CustomEventExtras.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */