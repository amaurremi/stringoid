package com.inmobi.commons.internal;

import com.inmobi.commons.metric.MetricConfigParams;
import com.inmobi.commons.uid.UID;
import java.util.Map;

public class CommonsConfig
{
  private static Log.INTERNAL_LOG_LEVEL a = Log.INTERNAL_LOG_LEVEL.NONE;
  private static Log.INTERNAL_LOG_LEVEL b = a;
  private MetricConfigParams c = new MetricConfigParams();
  
  protected static int getLogLevelConfig()
  {
    return b.getValue();
  }
  
  public MetricConfigParams getApiStatsConfig()
  {
    return this.c;
  }
  
  public final void setFromMap(Map<String, Object> paramMap)
    throws Exception
  {
    paramMap = InternalSDKUtil.populateToNewMap((Map)paramMap.get("AND"), (Map)paramMap.get("common"), true);
    new UID().setFromMap((Map)paramMap.get("ids"));
    UID.getCommonsUid().setFromMap((Map)paramMap.get("ids"));
    b = Log.getLogLevelValue(InternalSDKUtil.getIntFromMap(paramMap, "ll", 0, 2L));
    this.c.setFromMap((Map)paramMap.get("api"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/internal/CommonsConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */