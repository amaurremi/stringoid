package com.scoreloop.client.android.core.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class JSONUtils
{
  private static Object a(Object paramObject)
    throws JSONException
  {
    Object localObject;
    if (JSONObject.NULL.equals(paramObject)) {
      localObject = null;
    }
    do
    {
      return localObject;
      if ((paramObject instanceof JSONArray)) {
        return a((JSONArray)paramObject);
      }
      localObject = paramObject;
    } while (!(paramObject instanceof JSONObject));
    return b((JSONObject)paramObject);
  }
  
  private static List<Object> a(JSONArray paramJSONArray)
    throws JSONException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localArrayList.add(a(paramJSONArray.opt(i)));
      i += 1;
    }
    return localArrayList;
  }
  
  public static Map<String, Object> a(JSONObject paramJSONObject)
    throws JSONException
  {
    return b(paramJSONObject);
  }
  
  public static JSONObject a(Map<String, Object> paramMap)
  {
    return new JSONObject(paramMap);
  }
  
  public static boolean a(JSONObject paramJSONObject, String paramString)
  {
    if (!paramJSONObject.has(paramString)) {
      return false;
    }
    paramJSONObject = paramJSONObject.opt(paramString);
    if (paramJSONObject == null) {
      return false;
    }
    if (JSONObject.NULL.equals(paramJSONObject)) {
      return false;
    }
    return (!(paramJSONObject instanceof String)) || (!"".equalsIgnoreCase((String)paramJSONObject));
  }
  
  private static Map<String, Object> b(JSONObject paramJSONObject)
    throws JSONException
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, a(paramJSONObject.opt(str)));
    }
    return localHashMap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/utils/JSONUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */