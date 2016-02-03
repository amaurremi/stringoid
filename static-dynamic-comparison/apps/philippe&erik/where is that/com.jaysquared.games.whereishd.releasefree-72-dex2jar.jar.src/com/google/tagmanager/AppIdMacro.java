package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class AppIdMacro
  extends FunctionCallImplementation
{
  private static final String ID = FunctionType.APP_ID.toString();
  private final Context mContext;
  
  public AppIdMacro(Context paramContext)
  {
    super(ID, new String[0]);
    this.mContext = paramContext;
  }
  
  public static String getFunctionId()
  {
    return ID;
  }
  
  public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> paramMap)
  {
    return Types.objectToValue(this.mContext.getPackageName());
  }
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/AppIdMacro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */