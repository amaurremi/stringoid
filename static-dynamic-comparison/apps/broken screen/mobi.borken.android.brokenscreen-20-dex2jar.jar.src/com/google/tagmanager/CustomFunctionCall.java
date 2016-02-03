package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class CustomFunctionCall
  extends FunctionCallImplementation
{
  private static final String ADDITIONAL_PARAMS = Key.ADDITIONAL_PARAMS.toString();
  private static final String FUNCTION_CALL_NAME;
  private static final String ID = FunctionType.FUNCTION_CALL.toString();
  private final CustomEvaluator mFunctionCallEvaluator;
  
  static
  {
    FUNCTION_CALL_NAME = Key.FUNCTION_CALL_NAME.toString();
  }
  
  public CustomFunctionCall(CustomEvaluator paramCustomEvaluator)
  {
    super(ID, new String[] { FUNCTION_CALL_NAME });
    this.mFunctionCallEvaluator = paramCustomEvaluator;
  }
  
  public static String getAdditionalParamsKey()
  {
    return ADDITIONAL_PARAMS;
  }
  
  public static String getFunctionCallNameKey()
  {
    return FUNCTION_CALL_NAME;
  }
  
  public static String getFunctionId()
  {
    return ID;
  }
  
  public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> paramMap)
  {
    String str = Types.valueToString((TypeSystem.Value)paramMap.get(FUNCTION_CALL_NAME));
    HashMap localHashMap = new HashMap();
    paramMap = (TypeSystem.Value)paramMap.get(ADDITIONAL_PARAMS);
    if (paramMap != null)
    {
      paramMap = Types.valueToObject(paramMap);
      if (!(paramMap instanceof Map))
      {
        Log.w("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
        return Types.getDefaultValue();
      }
      paramMap = ((Map)paramMap).entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localHashMap.put(localEntry.getKey().toString(), localEntry.getValue());
      }
    }
    try
    {
      paramMap = Types.objectToValue(this.mFunctionCallEvaluator.evaluate(str, localHashMap));
      return paramMap;
    }
    catch (Exception paramMap)
    {
      Log.w("Custom macro/tag " + str + " threw exception " + paramMap.getMessage());
    }
    return Types.getDefaultValue();
  }
  
  public boolean isCacheable()
  {
    return false;
  }
  
  public static abstract interface CustomEvaluator
  {
    public abstract Object evaluate(String paramString, Map<String, Object> paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/CustomFunctionCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */