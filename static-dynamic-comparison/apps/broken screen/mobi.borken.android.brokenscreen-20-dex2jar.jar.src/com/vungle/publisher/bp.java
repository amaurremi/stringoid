package com.vungle.publisher;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bp
{
  public static Boolean a(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = null;
    boolean bool = paramJSONObject.optBoolean(paramString, false);
    if (!bool)
    {
      bool = paramJSONObject.optBoolean(paramString, true);
      paramJSONObject = (JSONObject)localObject;
      if (bool != true) {
        paramJSONObject = Boolean.valueOf(bool);
      }
      return paramJSONObject;
    }
    return Boolean.valueOf(bool);
  }
  
  public static <T extends by> JSONArray a(T[] paramArrayOfT)
    throws JSONException
  {
    Object localObject = null;
    if (paramArrayOfT != null)
    {
      JSONArray localJSONArray = new JSONArray();
      int j = paramArrayOfT.length;
      int i = 0;
      for (;;)
      {
        localObject = localJSONArray;
        if (i >= j) {
          break;
        }
        localJSONArray.put(a(paramArrayOfT[i]));
        i += 1;
      }
    }
    return (JSONArray)localObject;
  }
  
  public static JSONObject a(by paramby)
    throws JSONException
  {
    JSONObject localJSONObject = null;
    if (paramby != null) {
      localJSONObject = paramby.b();
    }
    return localJSONObject;
  }
  
  public static Float b(JSONObject paramJSONObject, String paramString)
  {
    double d = paramJSONObject.optDouble(paramString);
    if (d == NaN.0D)
    {
      d = paramJSONObject.optDouble(paramString, -1.0D);
      if (d == -1.0D) {
        break label58;
      }
      paramJSONObject = Double.valueOf(d);
    }
    for (;;)
    {
      if (paramJSONObject == null)
      {
        return null;
        paramJSONObject = Double.valueOf(d);
      }
      else
      {
        return Float.valueOf(paramJSONObject.floatValue());
        label58:
        paramJSONObject = null;
      }
    }
  }
  
  public static Integer c(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = null;
    int i = paramJSONObject.optInt(paramString, -1);
    if (i == -1)
    {
      i = paramJSONObject.optInt(paramString, -2);
      paramJSONObject = (JSONObject)localObject;
      if (i != -2) {
        paramJSONObject = Integer.valueOf(i);
      }
      return paramJSONObject;
    }
    return Integer.valueOf(i);
  }
  
  public static String d(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.isNull(paramString)) {
      return null;
    }
    return paramJSONObject.optString(paramString, null);
  }
  
  public static String[] e(JSONObject paramJSONObject, String paramString)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
    if (localJSONArray != null)
    {
      int j = localJSONArray.length();
      paramString = new String[j];
      int i = 0;
      for (;;)
      {
        paramJSONObject = paramString;
        if (i >= j) {
          break;
        }
        paramString[i] = localJSONArray.optString(i, null);
        i += 1;
      }
    }
    paramJSONObject = null;
    return paramJSONObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */