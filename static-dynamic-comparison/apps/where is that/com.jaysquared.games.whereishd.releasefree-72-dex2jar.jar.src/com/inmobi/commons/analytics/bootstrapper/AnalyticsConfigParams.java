package com.inmobi.commons.analytics.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.uid.UID;
import java.util.Map;

public class AnalyticsConfigParams
{
  private static final Long a = null;
  private UID b = new UID();
  private AnalyticsEndPointsConfig c = new AnalyticsEndPointsConfig();
  private ThinICEConfig d = new ThinICEConfig();
  private Long e = a;
  private int f = 5;
  private int g = 1000;
  private int h = 100;
  private int i = 3;
  private int j = 20;
  private int k = 50;
  private int l = 100;
  private int m = 5;
  private AutomaticCaptureConfig n = new AutomaticCaptureConfig();
  private int o = 100;
  
  public AutomaticCaptureConfig getAutomaticCapture()
  {
    return this.n;
  }
  
  public AnalyticsEndPointsConfig getEndPoints()
  {
    return this.c;
  }
  
  public int getExtraParamsLimit()
  {
    return this.l;
  }
  
  public int getGetParamsLimit()
  {
    return this.h;
  }
  
  public Long getLTVId()
  {
    return this.e;
  }
  
  public int getMaxAppIdLength()
  {
    return this.o;
  }
  
  public int getMaxDbEvents()
  {
    return this.g;
  }
  
  public int getMaxKeyLength()
  {
    return this.j;
  }
  
  public int getMaxRetryBeforeCacheDiscard()
  {
    return this.m;
  }
  
  public int getMaxValLength()
  {
    return this.k;
  }
  
  public int getMinEventsToCompress()
  {
    return this.f;
  }
  
  public int getPingInterval()
  {
    return this.i * 1000;
  }
  
  public ThinICEConfig getThinIceConfig()
  {
    return this.d;
  }
  
  public UID getUID()
  {
    return this.b;
  }
  
  public void setFromMap(Map<String, Object> paramMap)
  {
    this.h = InternalSDKUtil.getIntFromMap(paramMap, "elim", 1, 2147483647L);
    this.g = InternalSDKUtil.getIntFromMap(paramMap, "mdb", 1, 2147483647L);
    this.j = InternalSDKUtil.getIntFromMap(paramMap, "mkey", 1, 2147483647L);
    this.k = InternalSDKUtil.getIntFromMap(paramMap, "mval", 1, 2147483647L);
    this.i = InternalSDKUtil.getIntFromMap(paramMap, "pint", 1, 2147483647L);
    this.l = InternalSDKUtil.getIntFromMap(paramMap, "plim", 1, 2147483647L);
    this.e = Long.valueOf(InternalSDKUtil.getLongFromMap(paramMap, "ltvid", Long.MIN_VALUE, Long.MAX_VALUE));
    this.f = InternalSDKUtil.getIntFromMap(paramMap, "mec", 1, 2147483647L);
    this.m = InternalSDKUtil.getIntFromMap(paramMap, "mr", 0, 2147483647L);
    this.o = InternalSDKUtil.getIntFromMap(paramMap, "aidl", 1, 2147483647L);
    this.b.setFromMap((Map)paramMap.get("ids"));
    this.c.setFromMap((Map)paramMap.get("endpoints"));
    this.d.setFromMap((Map)paramMap.get("tic"));
    this.n.setFromMap((Map)paramMap.get("at"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/bootstrapper/AnalyticsConfigParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */