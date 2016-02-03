package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

abstract class TrackingTag
  extends FunctionCallImplementation
{
  public TrackingTag(String paramString, String... paramVarArgs)
  {
    super(paramString, paramVarArgs);
  }
  
  public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> paramMap)
  {
    evaluateTrackingTag(paramMap);
    return Types.getDefaultValue();
  }
  
  public abstract void evaluateTrackingTag(Map<String, TypeSystem.Value> paramMap);
  
  public boolean isCacheable()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/TrackingTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */