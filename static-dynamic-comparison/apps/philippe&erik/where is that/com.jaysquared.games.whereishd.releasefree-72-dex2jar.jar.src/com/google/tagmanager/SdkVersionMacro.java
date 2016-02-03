package com.google.tagmanager;

import android.os.Build.VERSION;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class SdkVersionMacro
  extends FunctionCallImplementation
{
  private static final String ID = FunctionType.SDK_VERSION.toString();
  
  public SdkVersionMacro()
  {
    super(ID, new String[0]);
  }
  
  public static String getFunctionId()
  {
    return ID;
  }
  
  public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> paramMap)
  {
    return Types.objectToValue(Integer.valueOf(Build.VERSION.SDK_INT));
  }
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/SdkVersionMacro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */