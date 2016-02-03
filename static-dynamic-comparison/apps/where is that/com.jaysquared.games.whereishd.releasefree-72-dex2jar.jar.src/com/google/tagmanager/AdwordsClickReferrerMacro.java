package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class AdwordsClickReferrerMacro
  extends FunctionCallImplementation
{
  private static final String COMPONENT = Key.COMPONENT.toString();
  private static final String CONVERSION_ID = Key.CONVERSION_ID.toString();
  private static final String ID = FunctionType.ADWORDS_CLICK_REFERRER.toString();
  private final Context context;
  
  public AdwordsClickReferrerMacro(Context paramContext)
  {
    super(ID, new String[] { CONVERSION_ID });
    this.context = paramContext;
  }
  
  public static String getFunctionId()
  {
    return ID;
  }
  
  public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> paramMap)
  {
    Object localObject = (TypeSystem.Value)paramMap.get(CONVERSION_ID);
    if (localObject == null) {
      return Types.getDefaultValue();
    }
    localObject = Types.valueToString((TypeSystem.Value)localObject);
    paramMap = (TypeSystem.Value)paramMap.get(COMPONENT);
    if (paramMap != null) {}
    for (paramMap = Types.valueToString(paramMap);; paramMap = null)
    {
      paramMap = InstallReferrerUtil.getClickReferrer(this.context, (String)localObject, paramMap);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/AdwordsClickReferrerMacro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */