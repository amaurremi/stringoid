package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class RandomMacro
  extends FunctionCallImplementation
{
  private static final String ID = FunctionType.RANDOM.toString();
  private static final String MAX = Key.MAX.toString();
  private static final String MIN = Key.MIN.toString();
  
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
    double d4 = 0.0D;
    double d5 = 2.147483647E9D;
    Object localObject = (TypeSystem.Value)paramMap.get(MIN);
    paramMap = (TypeSystem.Value)paramMap.get(MAX);
    double d2 = d5;
    double d1 = d4;
    if (localObject != null)
    {
      d2 = d5;
      d1 = d4;
      if (localObject != Types.getDefaultValue())
      {
        d2 = d5;
        d1 = d4;
        if (paramMap != null)
        {
          d2 = d5;
          d1 = d4;
          if (paramMap != Types.getDefaultValue())
          {
            localObject = Types.valueToNumber((TypeSystem.Value)localObject);
            paramMap = Types.valueToNumber(paramMap);
            d2 = d5;
            d1 = d4;
            if (localObject != Types.getDefaultNumber())
            {
              d2 = d5;
              d1 = d4;
              if (paramMap != Types.getDefaultNumber())
              {
                double d6 = ((TypedNumber)localObject).doubleValue();
                double d3 = paramMap.doubleValue();
                d2 = d5;
                d1 = d4;
                if (d6 <= d3)
                {
                  d1 = d6;
                  d2 = d3;
                }
              }
            }
          }
        }
      }
    }
    return Types.objectToValue(Long.valueOf(Math.round(Math.random() * (d2 - d1) + d1)));
  }
  
  public boolean isCacheable()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/RandomMacro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */