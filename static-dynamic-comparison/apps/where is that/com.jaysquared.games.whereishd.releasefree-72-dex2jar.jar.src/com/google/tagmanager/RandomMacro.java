package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class RandomMacro
  extends FunctionCallImplementation
{
  private static final String ID = FunctionType.RANDOM.toString();
  
  public RandomMacro()
  {
    super(ID, new String[0]);
  }
  
  public static String getFunctionId()
  {
    return ID;
  }
  
  public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> paramMap)
  {
    return Types.objectToValue(Long.valueOf(Math.round(Math.random() * 2.147483647E9D)));
  }
  
  public boolean isCacheable()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/RandomMacro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */