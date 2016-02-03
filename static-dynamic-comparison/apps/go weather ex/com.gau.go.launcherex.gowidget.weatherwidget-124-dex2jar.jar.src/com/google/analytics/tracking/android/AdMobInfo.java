package com.google.analytics.tracking.android;

import java.util.Map;
import java.util.Random;

class AdMobInfo
{
  private static final AdMobInfo INSTANCE = new AdMobInfo();
  private int adHitId;
  private Random random = new Random();
  
  static AdMobInfo getInstance()
  {
    return INSTANCE;
  }
  
  int generateAdHitId()
  {
    this.adHitId = (this.random.nextInt(2147483646) + 1);
    return this.adHitId;
  }
  
  int getAdHitId()
  {
    return this.adHitId;
  }
  
  Map<String, String> getJoinIds()
  {
    return null;
  }
  
  void setAdHitId(int paramInt)
  {
    this.adHitId = paramInt;
  }
  
  static enum AdMobKey
  {
    CLIENT_ID_KEY("ga_cid"),  HIT_ID_KEY("ga_hid"),  PROPERTY_ID_KEY("ga_wpids"),  VISITOR_ID_KEY("ga_uid");
    
    private String bowParameter;
    
    private AdMobKey(String paramString)
    {
      this.bowParameter = paramString;
    }
    
    String getBowParameter()
    {
      return this.bowParameter;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/analytics/tracking/android/AdMobInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */