package com.chartboost.sdk.Libraries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<**>;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  public static a a(String paramString, Object paramObject)
  {
    return new a(paramString, paramObject);
  }
  
  public static List<?> a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length()) {}
      try
      {
        Object localObject = paramJSONArray.get(i);
        if ((localObject instanceof JSONObject)) {
          localObject = a((JSONObject)localObject);
        }
        for (;;)
        {
          localArrayList.add(localObject);
          break;
          if ((localObject instanceof JSONArray))
          {
            localObject = a((JSONArray)localObject);
          }
          else
          {
            boolean bool = localObject.equals(JSONObject.NULL);
            if (bool) {
              localObject = null;
            }
          }
        }
        return localArrayList;
      }
      catch (Exception localException)
      {
        i += 1;
      }
    }
  }
  
  public static Map<String, Object> a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    for (;;)
    {
      if (localIterator.hasNext()) {}
      try
      {
        String str = (String)localIterator.next();
        Object localObject = paramJSONObject.get(str);
        if ((localObject instanceof JSONObject)) {
          localObject = a((JSONObject)localObject);
        }
        for (;;)
        {
          localHashMap.put(str, localObject);
          break;
          if ((localObject instanceof JSONArray))
          {
            localObject = a((JSONArray)localObject);
          }
          else
          {
            boolean bool = localObject.equals(JSONObject.NULL);
            if (bool) {
              localObject = null;
            }
          }
        }
        return localHashMap;
      }
      catch (Exception localException) {}
    }
  }
  
  public static JSONArray a(List<?> paramList)
  {
    if (paramList == null) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    for (;;)
    {
      if (i < paramList.size()) {}
      try
      {
        Object localObject2 = paramList.get(i);
        Object localObject1;
        if ((localObject2 instanceof Map)) {
          localObject1 = a((Map)localObject2);
        }
        for (;;)
        {
          localJSONArray.put(localObject1);
          break;
          if ((localObject2 instanceof List))
          {
            localObject1 = a((List)localObject2);
          }
          else
          {
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = JSONObject.NULL;
            }
          }
        }
        return localJSONArray;
      }
      catch (Exception localException)
      {
        i += 1;
      }
    }
  }
  
  public static JSONObject a(Map<?, ?> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramMap.entrySet().iterator();
    for (;;)
    {
      String str;
      Object localObject;
      if (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        str = paramMap.getKey().toString();
        localObject = paramMap.getValue();
      }
      try
      {
        if ((localObject instanceof Map)) {
          paramMap = a((Map)localObject);
        }
        for (;;)
        {
          localJSONObject.put(str, paramMap);
          break;
          if ((localObject instanceof List))
          {
            paramMap = a((List)localObject);
          }
          else
          {
            paramMap = (Map<?, ?>)localObject;
            if (localObject == null) {
              paramMap = JSONObject.NULL;
            }
          }
        }
        return localJSONObject;
      }
      catch (Exception paramMap) {}
    }
  }
  
  public static JSONObject a(a... paramVarArgs)
  {
    JSONObject localJSONObject = new JSONObject();
    int i = 0;
    for (;;)
    {
      if (i < paramVarArgs.length) {
        try
        {
          localJSONObject.put(a.a(paramVarArgs[i]), a.b(paramVarArgs[i]));
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            CBLogging.b("CBJSON", "Error creating JSONObject-based dictionary", localJSONException);
          }
        }
      }
    }
    return localJSONObject;
  }
  
  public static class a
  {
    private String a;
    private Object b;
    
    public a(String paramString, Object paramObject)
    {
      this.a = paramString;
      this.b = paramObject;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/Libraries/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */