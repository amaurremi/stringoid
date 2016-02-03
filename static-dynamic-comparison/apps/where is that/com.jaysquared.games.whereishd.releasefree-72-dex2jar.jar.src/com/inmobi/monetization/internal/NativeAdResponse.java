package com.inmobi.monetization.internal;

import java.util.List;

public class NativeAdResponse
{
  public static final String KEY_ADS = "ads";
  public static final String KEY_CONTEXTCODE = "contextCode";
  public static final String KEY_NAMESPACE = "namespace";
  public static final String KEY_PUBCONTENT = "pubContent";
  private List<String> a;
  
  NativeAdResponse(List<String> paramList)
  {
    if (paramList != null) {
      this.a = paramList;
    }
  }
  
  List<String> a()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/monetization/internal/NativeAdResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */