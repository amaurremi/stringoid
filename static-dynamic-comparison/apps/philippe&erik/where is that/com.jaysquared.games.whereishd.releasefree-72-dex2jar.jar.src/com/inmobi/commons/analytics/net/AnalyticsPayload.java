package com.inmobi.commons.analytics.net;

import java.util.List;

public class AnalyticsPayload
{
  private String a;
  private List<Long> b;
  private String c;
  private int d;
  
  public AnalyticsPayload(String paramString, List<Long> paramList)
  {
    this.a = paramString;
    this.b = paramList;
  }
  
  public String getCompletePayload()
  {
    return this.c;
  }
  
  public String getOnlyEvent()
  {
    return this.a;
  }
  
  public int getPayloadSize()
  {
    return this.d;
  }
  
  public List<Long> getTableIdList()
  {
    return this.b;
  }
  
  public void setCompletePayload(String paramString)
  {
    this.c = paramString;
  }
  
  public void setPayloadSize(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/net/AnalyticsPayload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */