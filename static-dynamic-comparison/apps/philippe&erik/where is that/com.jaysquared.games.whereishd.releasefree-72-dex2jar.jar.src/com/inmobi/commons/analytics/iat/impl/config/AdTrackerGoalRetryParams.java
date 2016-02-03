package com.inmobi.commons.analytics.iat.impl.config;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class AdTrackerGoalRetryParams
{
  private int a = 1000;
  private int b = 900;
  
  public int getMaxRetry()
  {
    return this.a;
  }
  
  public int getMaxWaitTime()
  {
    return this.b * 1000;
  }
  
  public void setFromMap(Map<String, Object> paramMap)
  {
    this.a = InternalSDKUtil.getIntFromMap(paramMap, "mr", 0, 2147483647L);
    this.b = InternalSDKUtil.getIntFromMap(paramMap, "mw", 0, 2147483647L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/iat/impl/config/AdTrackerGoalRetryParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */