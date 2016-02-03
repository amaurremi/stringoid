package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class StartsWithPredicate
  extends StringPredicate
{
  private static final String ID = FunctionType.STARTS_WITH.toString();
  
  public StartsWithPredicate()
  {
    super(ID);
  }
  
  public static String getFunctionId()
  {
    return ID;
  }
  
  protected boolean evaluateString(String paramString1, String paramString2, Map<String, TypeSystem.Value> paramMap)
  {
    return paramString1.startsWith(paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/StartsWithPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */