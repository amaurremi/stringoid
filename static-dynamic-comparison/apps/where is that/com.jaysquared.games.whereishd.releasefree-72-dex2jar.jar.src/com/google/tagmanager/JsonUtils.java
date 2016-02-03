package com.google.tagmanager;

import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class JsonUtils
{
  public static ResourceUtil.ExpandedResource expandedResourceFromJsonString(String paramString)
    throws JSONException
  {
    paramString = jsonObjectToValue(new JSONObject(paramString));
    ResourceUtil.ExpandedResourceBuilder localExpandedResourceBuilder = ResourceUtil.ExpandedResource.newBuilder();
    int i = 0;
    while (i < paramString.getMapKeyCount())
    {
      localExpandedResourceBuilder.addMacro(ResourceUtil.ExpandedFunctionCall.newBuilder().addProperty(Key.INSTANCE_NAME.toString(), paramString.getMapKey(i)).addProperty(Key.FUNCTION.toString(), Types.functionIdToValue(ConstantMacro.getFunctionId())).addProperty(ConstantMacro.getValueKey(), paramString.getMapValue(i)).build());
      i += 1;
    }
    return localExpandedResourceBuilder.build();
  }
  
  @VisibleForTesting
  static Object jsonObjectToObject(Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof JSONArray)) {
      throw new RuntimeException("JSONArrays are not supported");
    }
    if (JSONObject.NULL.equals(paramObject)) {
      throw new RuntimeException("JSON nulls are not supported");
    }
    if ((paramObject instanceof JSONObject))
    {
      JSONObject localJSONObject = (JSONObject)paramObject;
      HashMap localHashMap = new HashMap();
      Iterator localIterator = localJSONObject.keys();
      for (;;)
      {
        paramObject = localHashMap;
        if (!localIterator.hasNext()) {
          break;
        }
        paramObject = (String)localIterator.next();
        localHashMap.put(paramObject, jsonObjectToObject(localJSONObject.get((String)paramObject)));
      }
    }
    return paramObject;
  }
  
  private static TypeSystem.Value jsonObjectToValue(Object paramObject)
    throws JSONException
  {
    return Types.objectToValue(jsonObjectToObject(paramObject));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/JsonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */