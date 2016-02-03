package com.mopub.mobileads.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Json
{
  public static String[] jsonArrayToStringArray(String paramString)
  {
    paramString = "{key:" + paramString + "}";
    try
    {
      JSONArray localJSONArray = ((JSONObject)new JSONTokener(paramString).nextValue()).getJSONArray("key");
      String[] arrayOfString = new String[localJSONArray.length()];
      int i = 0;
      for (;;)
      {
        paramString = arrayOfString;
        if (i >= arrayOfString.length) {
          break;
        }
        arrayOfString[i] = localJSONArray.getString(i);
        i += 1;
      }
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString = new String[0];
    }
  }
  
  public static Map<String, String> jsonStringToMap(String paramString)
    throws Exception
  {
    HashMap localHashMap = new HashMap();
    if ((paramString == null) || (paramString.equals(""))) {}
    for (;;)
    {
      return localHashMap;
      paramString = (JSONObject)new JSONTokener(paramString).nextValue();
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramString.getString(str));
      }
    }
  }
  
  public static String mapToJsonString(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    int i = 1;
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (i == 0) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append("\"");
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append("\":\"");
      localStringBuilder.append((String)localEntry.getValue());
      localStringBuilder.append("\"");
      i = 0;
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/util/Json.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */