package com.inmobi.commons.metric;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class MetricConfigParams
{
  private int a = 432000;
  private int b = 1000;
  private int c = 1000;
  private int d = 10;
  private String e = "";
  
  public int getDumpThreshhold()
  {
    return this.d;
  }
  
  public int getMaxInQueue()
  {
    return this.b;
  }
  
  public int getNextRetryInterval()
  {
    return this.a;
  }
  
  public int getSamplingFactor()
  {
    return this.c;
  }
  
  public String getUrl()
  {
    return this.e;
  }
  
  public void setFromMap(Map<String, Object> paramMap)
  {
    this.c = InternalSDKUtil.getIntFromMap(paramMap, "sf", 1, 2147483647L);
    this.d = InternalSDKUtil.getIntFromMap(paramMap, "dt", 1, 2147483647L);
    this.b = InternalSDKUtil.getIntFromMap(paramMap, "max", 1, 2147483647L);
    this.a = InternalSDKUtil.getIntFromMap(paramMap, "nri", 1, 2147483647L);
    this.e = InternalSDKUtil.getStringFromMap(paramMap, "url");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/metric/MetricConfigParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */