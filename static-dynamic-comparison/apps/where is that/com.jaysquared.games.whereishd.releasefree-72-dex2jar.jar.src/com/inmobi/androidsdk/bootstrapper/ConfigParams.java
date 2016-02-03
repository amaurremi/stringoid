package com.inmobi.androidsdk.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.metric.MetricConfigParams;
import com.inmobi.commons.uid.UID;
import java.util.Map;

public class ConfigParams
{
  int a = 20;
  int b = 60;
  int c = 60;
  int d = 60;
  IMAIConfigParams e = new IMAIConfigParams();
  MetricConfigParams f = new MetricConfigParams();
  UID g = new UID();
  AppGalleryConfigParams h = new AppGalleryConfigParams();
  NativeConfigParams i = new NativeConfigParams();
  
  public AppGalleryConfigParams getAppAppGalleryConfigParams()
  {
    return this.h;
  }
  
  public int getDefaultRefreshRate()
  {
    return this.b;
  }
  
  public int getFetchTimeOut()
  {
    return this.c * 1000;
  }
  
  public IMAIConfigParams getImai()
  {
    return this.e;
  }
  
  public MetricConfigParams getMetric()
  {
    return this.f;
  }
  
  public int getMinimumRefreshRate()
  {
    return this.a;
  }
  
  public NativeConfigParams getNativeSdkConfigParams()
  {
    return this.i;
  }
  
  public int getRenderTimeOut()
  {
    return this.d * 1000;
  }
  
  public UID getUID()
  {
    return this.g;
  }
  
  public void setFromMap(Map<String, Object> paramMap)
  {
    this.a = InternalSDKUtil.getIntFromMap(paramMap, "mrr", 1, 2147483647L);
    this.b = InternalSDKUtil.getIntFromMap(paramMap, "drr", -1, 2147483647L);
    this.c = InternalSDKUtil.getIntFromMap(paramMap, "fto", 1, 2147483647L);
    this.d = InternalSDKUtil.getIntFromMap(paramMap, "rto", 1, 2147483647L);
    this.e.setFromMap((Map)paramMap.get("imai"));
    this.f.setFromMap((Map)paramMap.get("metric"));
    this.g.setFromMap((Map)paramMap.get("ids"));
    this.h.setFromMap((Map)paramMap.get("ag"));
    this.i.setFromMap((Map)paramMap.get("native"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/androidsdk/bootstrapper/ConfigParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */