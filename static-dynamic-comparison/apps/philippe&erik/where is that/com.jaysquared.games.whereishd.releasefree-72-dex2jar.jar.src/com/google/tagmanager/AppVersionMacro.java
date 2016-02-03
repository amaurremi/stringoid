package com.google.tagmanager;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class AppVersionMacro
  extends FunctionCallImplementation
{
  private static final String ID = FunctionType.APP_VERSION.toString();
  private final Context mContext;
  
  public AppVersionMacro(Context paramContext)
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
    try
    {
      paramMap = Types.objectToValue(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
      return paramMap;
    }
    catch (PackageManager.NameNotFoundException paramMap)
    {
      Log.e("Package name " + this.mContext.getPackageName() + " not found. " + paramMap.getMessage());
    }
    return Types.getDefaultValue();
  }
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/AppVersionMacro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */