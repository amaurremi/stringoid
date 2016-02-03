package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class InstallReferrerMacro
  extends FunctionCallImplementation
{
  private static final String COMPONENT = Key.COMPONENT.toString();
  private static final String ID = FunctionType.INSTALL_REFERRER.toString();
  private final Context context;
  
  public InstallReferrerMacro(Context paramContext)
  {
    super(ID, new String[0]);
    this.context = paramContext;
  }
  
  public static String getFunctionId()
  {
    return ID;
  }
  
  public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> paramMap)
  {
    if ((TypeSystem.Value)paramMap.get(COMPONENT) != null) {}
    for (paramMap = Types.valueToString((TypeSystem.Value)paramMap.get(COMPONENT));; paramMap = null)
    {
      paramMap = InstallReferrerUtil.getInstallReferrer(this.context, paramMap);
      if (paramMap == null) {
        break;
      }
      return Types.objectToValue(paramMap);
    }
    return Types.getDefaultValue();
  }
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/InstallReferrerMacro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */