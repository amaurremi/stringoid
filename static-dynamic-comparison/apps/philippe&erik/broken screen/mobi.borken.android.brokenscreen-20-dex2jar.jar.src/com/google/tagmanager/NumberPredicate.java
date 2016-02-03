package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

abstract class NumberPredicate
  extends Predicate
{
  public NumberPredicate(String paramString)
  {
    super(paramString);
  }
  
  protected boolean evaluateNoDefaultValues(TypeSystem.Value paramValue1, TypeSystem.Value paramValue2, Map<String, TypeSystem.Value> paramMap)
  {
    paramValue1 = Types.valueToNumber(paramValue1);
    paramValue2 = Types.valueToNumber(paramValue2);
    if ((paramValue1 == Types.getDefaultNumber()) || (paramValue2 == Types.getDefaultNumber())) {
      return false;
    }
    return evaluateNumber(paramValue1, paramValue2, paramMap);
  }
  
  protected abstract boolean evaluateNumber(TypedNumber paramTypedNumber1, TypedNumber paramTypedNumber2, Map<String, TypeSystem.Value> paramMap);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/NumberPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */