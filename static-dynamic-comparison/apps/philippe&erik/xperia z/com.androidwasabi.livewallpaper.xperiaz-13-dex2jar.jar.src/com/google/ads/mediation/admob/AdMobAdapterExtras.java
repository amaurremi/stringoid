package com.google.ads.mediation.admob;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;
import java.util.Map;

public class AdMobAdapterExtras
  implements NetworkExtras
{
  private boolean a = false;
  private Map<String, Object> b;
  
  public AdMobAdapterExtras()
  {
    clearExtras();
  }
  
  public AdMobAdapterExtras(AdMobAdapterExtras paramAdMobAdapterExtras)
  {
    this();
    if (paramAdMobAdapterExtras != null)
    {
      this.a = paramAdMobAdapterExtras.a;
      this.b.putAll(paramAdMobAdapterExtras.b);
    }
  }
  
  public AdMobAdapterExtras addExtra(String paramString, Object paramObject)
  {
    this.b.put(paramString, paramObject);
    return this;
  }
  
  public AdMobAdapterExtras clearExtras()
  {
    this.b = new HashMap();
    return this;
  }
  
  public Map<String, Object> getExtras()
  {
    return this.b;
  }
  
  @Deprecated
  public boolean getPlusOneOptOut()
  {
    return false;
  }
  
  public boolean getUseExactAdSize()
  {
    return this.a;
  }
  
  public AdMobAdapterExtras setExtras(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      throw new IllegalArgumentException("Argument 'extras' may not be null");
    }
    this.b = paramMap;
    return this;
  }
  
  @Deprecated
  public AdMobAdapterExtras setPlusOneOptOut(boolean paramBoolean)
  {
    return this;
  }
  
  public AdMobAdapterExtras setUseExactAdSize(boolean paramBoolean)
  {
    this.a = paramBoolean;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/mediation/admob/AdMobAdapterExtras.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */