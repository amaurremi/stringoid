package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

abstract class StringPredicate
  extends Predicate
{
  public StringPredicate(String paramString)
  {
    super(paramString);
  }
  
  protected boolean evaluateNoDefaultValues(TypeSystem.Value paramValue1, TypeSystem.Value paramValue2, Map<String, TypeSystem.Value> paramMap)
  {
    paramValue1 = Types.valueToString(paramValue1);
    paramValue2 = Types.valueToString(paramValue2);
    if ((paramValue1 == Types.getDefaultString()) || (paramValue2 == Types.getDefaultString())) {
      return false;
    }
    return evaluateString(paramValue1, paramValue2, paramMap);
  }
  
  protected abstract boolean evaluateString(String paramString1, String paramString2, Map<String, TypeSystem.Value> paramMap);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/StringPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */