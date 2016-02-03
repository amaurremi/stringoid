package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class EndsWithPredicate
  extends StringPredicate
{
  private static final String ID = FunctionType.ENDS_WITH.toString();
  
  public EndsWithPredicate()
  {
    super(ID);
  }
  
  public static String getFunctionId()
  {
    return ID;
  }
  
  protected boolean evaluateString(String paramString1, String paramString2, Map<String, TypeSystem.Value> paramMap)
  {
    return paramString1.endsWith(paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/EndsWithPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */