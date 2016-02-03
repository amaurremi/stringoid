package com.google.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;

class DeviceIdMacro
  extends FunctionCallImplementation
{
  private static final String ID = FunctionType.DEVICE_ID.toString();
  private final Context mContext;
  
  public DeviceIdMacro(Context paramContext)
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
    paramMap = getAndroidId(this.mContext);
    if (paramMap == null) {
      return Types.getDefaultValue();
    }
    return Types.objectToValue(paramMap);
  }
  
  @VisibleForTesting
  protected String getAndroidId(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/DeviceIdMacro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */