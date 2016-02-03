package com.google.android.apps.analytics;

import java.util.Random;

public class AdMobInfo
{
  private static final AdMobInfo INSTANCE = new AdMobInfo();
  private int adHitId;
  private Random random = new Random();
  
  public static AdMobInfo getInstance()
  {
    return INSTANCE;
  }
  
  public int generateAdHitId()
  {
    this.adHitId = this.random.nextInt();
    return this.adHitId;
  }
  
  public int getAdHitId()
  {
    return this.adHitId;
  }
  
  public String getJoinId()
  {
    if (this.adHitId == 0) {}
    Object localObject;
    String str;
    do
    {
      return null;
      localObject = GoogleAnalyticsTracker.getInstance();
      str = ((GoogleAnalyticsTracker)localObject).getVisitorIdForAds();
      localObject = ((GoogleAnalyticsTracker)localObject).getSessionIdForAds();
    } while ((str == null) || (localObject == null));
    return String.format("A,%s,%s,%d", new Object[] { str, localObject, Integer.valueOf(this.adHitId) });
  }
  
  public void setAdHitId(int paramInt)
  {
    this.adHitId = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/google/android/apps/analytics/AdMobInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */