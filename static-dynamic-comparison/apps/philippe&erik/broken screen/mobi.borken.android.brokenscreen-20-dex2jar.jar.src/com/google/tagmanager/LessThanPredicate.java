package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class LessThanPredicate
  extends NumberPredicate
{
  private static final String ID = FunctionType.LESS_THAN.toString();
  
  public LessThanPredicate()
  {
    super(ID);
  }
  
  public static String getFunctionId()
  {
    return ID;
  }
  
  protected boolean evaluateNumber(TypedNumber paramTypedNumber1, TypedNumber paramTypedNumber2, Map<String, TypeSystem.Value> paramMap)
  {
    return paramTypedNumber1.compareTo(paramTypedNumber2) < 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/LessThanPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */