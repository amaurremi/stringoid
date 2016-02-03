package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class DataLayerMacro
  extends FunctionCallImplementation
{
  private static final String DEFAULT_VALUE = Key.DEFAULT_VALUE.toString();
  private static final String ID = FunctionType.CUSTOM_VAR.toString();
  private static final String NAME = Key.NAME.toString();
  private final DataLayer mDataLayer;
  
  public DataLayerMacro(DataLayer paramDataLayer)
  {
    super(ID, new String[] { NAME });
    this.mDataLayer = paramDataLayer;
  }
  
  public static String getDefaultValueKey()
  {
    return DEFAULT_VALUE;
  }
  
  public static String getFunctionId()
  {
    return ID;
  }
  
  public static String getNameKey()
  {
    return NAME;
  }
  
  public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> paramMap)
  {
    Object localObject = this.mDataLayer.get(Types.valueToString((TypeSystem.Value)paramMap.get(NAME)));
    if (localObject == null)
    {
      paramMap = (TypeSystem.Value)paramMap.get(DEFAULT_VALUE);
      if (paramMap != null) {
        return paramMap;
      }
      return Types.getDefaultValue();
    }
    return Types.objectToValue(localObject);
  }
  
  public boolean isCacheable()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/DataLayerMacro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */