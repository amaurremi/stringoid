package com.inmobi.commons.analytics.iat.impl.config;

import com.inmobi.commons.metric.EventType;

public enum AdTrackerEventType
  implements EventType
{
  private int a;
  
  static
  {
    GOAL_FAILURE = new AdTrackerEventType("GOAL_FAILURE", 1, 1);
  }
  
  private AdTrackerEventType(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int getValue()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/iat/impl/config/AdTrackerEventType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */