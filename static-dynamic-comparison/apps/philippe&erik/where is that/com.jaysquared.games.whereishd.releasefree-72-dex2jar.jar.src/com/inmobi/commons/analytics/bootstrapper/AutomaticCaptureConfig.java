package com.inmobi.commons.analytics.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class AutomaticCaptureConfig
{
  private boolean a = true;
  private boolean b = false;
  
  public boolean getAutoPurchaseCapture()
  {
    return this.b;
  }
  
  public boolean getAutoSessionCapture()
  {
    return this.a;
  }
  
  public void setFromMap(Map<String, Object> paramMap)
  {
    this.a = InternalSDKUtil.getBooleanFromMap(paramMap, "session");
    this.b = InternalSDKUtil.getBooleanFromMap(paramMap, "purchase");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/bootstrapper/AutomaticCaptureConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */