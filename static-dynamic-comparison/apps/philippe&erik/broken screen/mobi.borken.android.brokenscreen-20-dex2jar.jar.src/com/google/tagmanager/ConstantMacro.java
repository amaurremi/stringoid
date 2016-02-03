package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class ConstantMacro
  extends FunctionCallImplementation
{
  private static final String ID = FunctionType.CONSTANT.toString();
  private static final String VALUE = Key.VALUE.toString();
  
  public ConstantMacro()
  {
    super(ID, new String[] { VALUE });
  }
  
  public static String getFunctionId()
  {
    return ID;
  }
  
  public static String getValueKey()
  {
    return VALUE;
  }
  
  public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> paramMap)
  {
    return (TypeSystem.Value)paramMap.get(VALUE);
  }
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/ConstantMacro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */