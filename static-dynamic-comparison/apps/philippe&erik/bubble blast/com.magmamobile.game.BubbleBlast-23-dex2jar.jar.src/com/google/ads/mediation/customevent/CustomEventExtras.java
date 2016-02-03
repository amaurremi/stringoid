package com.google.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

public class CustomEventExtras
  implements NetworkExtras
{
  private final HashMap<String, Object> a = new HashMap();
  
  public CustomEventExtras addExtra(String paramString, Object paramObject)
  {
    this.a.put(paramString, paramObject);
    return this;
  }
  
  public CustomEventExtras clearExtras()
  {
    this.a.clear();
    return this;
  }
  
  public Object getExtra(String paramString)
  {
    return this.a.get(paramString);
  }
  
  public Object removeExtra(String paramString)
  {
    return this.a.remove(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/mediation/customevent/CustomEventExtras.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */