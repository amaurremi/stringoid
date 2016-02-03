package com.inmobi.commons.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONMapBuilder
  implements MapBuilder
{
  private void a(JSONObject paramJSONObject, Map<String, Object> paramMap)
  {
    Iterator localIterator = paramJSONObject.keys();
    for (;;)
    {
      String str;
      if (localIterator.hasNext()) {
        str = (String)localIterator.next();
      }
      try
      {
        Object localObject = paramJSONObject.get(str);
        if ((localObject instanceof JSONObject))
        {
          HashMap localHashMap = new HashMap();
          paramMap.put(str, localHashMap);
          a((JSONObject)localObject, localHashMap);
          continue;
        }
        paramMap.put(str, localObject);
      }
      catch (JSONException localJSONException) {}
      return;
    }
  }
  
  public Map<String, Object> buildMap(String paramString)
    throws Exception
  {
    paramString = new JSONObject(paramString);
    HashMap localHashMap = new HashMap();
    a(paramString, localHashMap);
    return localHashMap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/cache/JSONMapBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */