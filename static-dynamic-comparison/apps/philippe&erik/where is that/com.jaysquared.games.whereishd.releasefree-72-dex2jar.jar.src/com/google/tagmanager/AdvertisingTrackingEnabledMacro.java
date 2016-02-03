package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class AdvertisingTrackingEnabledMacro
  extends FunctionCallImplementation
{
  private static final String ID = FunctionType.ADVERTISING_TRACKING_ENABLED.toString();
  
  public AdvertisingTrackingEnabledMacro()
  {
    super(ID, new String[0]);
  }
  
  public static String getFunctionId()
  {
    return ID;
  }
  
  public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> paramMap)
  {
    return Types.objectToValue(Boolean.valueOf(true));
  }
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/AdvertisingTrackingEnabledMacro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */