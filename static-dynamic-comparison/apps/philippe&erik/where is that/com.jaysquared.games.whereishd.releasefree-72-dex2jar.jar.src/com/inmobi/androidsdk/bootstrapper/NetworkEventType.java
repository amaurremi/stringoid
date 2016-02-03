package com.inmobi.androidsdk.bootstrapper;

import com.inmobi.commons.metric.EventType;

public enum NetworkEventType
  implements EventType
{
  private int a;
  
  static
  {
    CONNECT_ERROR = new NetworkEventType("CONNECT_ERROR", 2, 2);
    RESPONSE_ERROR = new NetworkEventType("RESPONSE_ERROR", 3, 3);
  }
  
  private NetworkEventType(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int getValue()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/androidsdk/bootstrapper/NetworkEventType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */